package com.zqr.test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class EMVQRGenerator {

    // 字段定义 (EMVCo 2.0核心Tag)
    private static final String TAG_PAYLOAD = "00";
    private static final String TAG_MID = "52";
    private static final String TAG_CURRENCY = "53";
    private static final String TAG_AMOUNT = "54";
    private static final String TAG_URL = "55";
    private static final String TAG_COUNTRY = "58";
    private static final String TAG_MERCHANT_NAME = "59";
    private static final String TAG_CRC = "63";

    public static void main(String[] args) throws Exception {
        // 示例1：静态二维码（含金额）
        generateQR(
                "static_qr.png",  // 输出文件名
                "123456789",      // Merchant ID
                "CNY",           // 货币代码
                "CN",            // 国家代码
                "Test Merchant", // 商户名称
                "100",           // 金额（分）
                null             // URL（静态码无需URL）
        );

        // 示例2：动态二维码（不含金额，带URL）
        generateQR(
                "dynamic_qr.png",
                "123456789",
                "CNY",
                "CN",
                "Test Merchant",
                null,            // 金额设为null
                "https://api.example.com/pay?token=DYNAMIC_TOKEN"
        );
    }

    /**
     * 通用二维码生成方法
     * @param filename    输出文件名
     * @param merchantId  商户ID (必填)
     * @param currency    货币代码 (必填)
     * @param country     国家代码 (必填)
     * @param merchantName 商户名称 (必填)
     * @param amount      金额（分，可选；与url互斥）
     * @param url         动态URL（可选；与amount互斥）
     */
    public static void generateQR(String filename, String merchantId, String currency,
                                  String country, String merchantName, String amount,
                                  String url) throws Exception {
        // 参数校验
        if (amount != null && url != null) {
            throw new IllegalArgumentException("金额和URL不能同时存在");
        }

        // 按EMVCo顺序构建字段
        Map<String, FieldMeta> fields = new LinkedHashMap<>();
        addField(fields, TAG_PAYLOAD, "EMVCo", StandardCharsets.UTF_8);
        addField(fields, TAG_MID, merchantId, StandardCharsets.US_ASCII);
        addField(fields, TAG_CURRENCY, currency, StandardCharsets.US_ASCII);
        addField(fields, TAG_AMOUNT, amount, StandardCharsets.US_ASCII);
        addField(fields, TAG_URL, url, StandardCharsets.UTF_8);
        addField(fields, TAG_COUNTRY, country, StandardCharsets.US_ASCII);
        addField(fields, TAG_MERCHANT_NAME, merchantName, StandardCharsets.UTF_8);

        // 生成TLV数据
        String tlvData = buildTLV(fields);
        byte[] qrImage = generateQRImage(tlvData);
        saveImage(qrImage, filename);
    }

    // 添加字段到Map（自动过滤null值）
    private static void addField(Map<String, FieldMeta> fields, String tag,
                                 String value, Charset charset) {
        if (value != null) {
            fields.put(tag, new FieldMeta(value, charset));
        }
    }

    // 构建完整的TLV数据（含CRC）
    private static String buildTLV(Map<String, FieldMeta> fields) {
        StringBuilder tlvBuilder = new StringBuilder();

        // 按规范顺序处理字段
        processTag(tlvBuilder, TAG_PAYLOAD, fields);
        processTag(tlvBuilder, TAG_MID, fields);
        processTag(tlvBuilder, TAG_CURRENCY, fields);
        processTag(tlvBuilder, TAG_AMOUNT, fields);
        processTag(tlvBuilder, TAG_URL, fields);
        processTag(tlvBuilder, TAG_COUNTRY, fields);
        processTag(tlvBuilder, TAG_MERCHANT_NAME, fields);

        // 计算CRC
        String crc = calculateCRC(tlvBuilder.toString());
        tlvBuilder.append(encodeCRC(crc));

        return tlvBuilder.toString();
    }

    // 处理单个Tag
    private static void processTag(StringBuilder builder, String tag,
                                   Map<String, FieldMeta> fields) {
        if (fields.containsKey(tag)) {
            FieldMeta meta = fields.get(tag);
            builder.append(encodeTLV(tag, meta.value, meta.charset));
        }
    }

    // TLV编码核心
    private static String encodeTLV(String tag, String value, Charset charset) {
        byte[] valueBytes = value.getBytes(charset);
        return String.format("%s%02X%s", tag, valueBytes.length, bytesToHex(valueBytes));
    }

    // CRC字段编码
    private static String encodeCRC(String crc) {
        return TAG_CRC + "04" + crc;
    }

    // CRC16-CCITT计算
    private static String calculateCRC(String dataHex) {
        byte[] bytes = hexToBytes(dataHex);
        int crc = 0xFFFF;
        for (byte b : bytes) {
            crc = (crc >>> 8) | (crc << 8);
            crc ^= (b & 0xFF);
            crc ^= (crc & 0xFF) >> 4;
            crc ^= (crc << 12) & 0xFFFF;
            crc ^= ((crc & 0xFF) << 5) & 0xFFFF;
        }
        crc &= 0xFFFF;
        return String.format("%04X", crc);
    }

    // 辅助方法：Hex转字节数组
    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    // 生成二维码图像（ZXing实现）
    private static byte[] generateQRImage(String tlvData) throws WriterException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(tlvData, BarcodeFormat.QR_CODE, 300, 300);

        BufferedImage image = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 300; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0x000000 : 0xFFFFFF);
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "PNG", baos);
        } catch (Exception e) {
            throw new WriterException("图像保存失败: " + e.getMessage());
        }
        return baos.toByteArray();
    }

    // 保存图像到文件
    private static void saveImage(byte[] imageData, String filename) throws Exception {
        ImageIO.write(ImageIO.read(new java.io.ByteArrayInputStream(imageData)),
                "PNG", new File(filename));
    }

    // 辅助类：存储字段元数据
    private static class FieldMeta {
        String value;
        Charset charset;

        FieldMeta(String value, Charset charset) {
            this.value = value;
            this.charset = charset;
        }
    }

    // 辅助方法：字节转Hex
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
