package com.zqr.test;

import java.util.ArrayList;
import java.util.List;

public class EmvQrParser {

    public static void main(String[] args) {
        String hexData = "0005454D56436F52093132333435363738395303434E5954033130305802434E590D54657374204D65726368616E7463047268";
        try {
            List<TLVEntry> entries = parseEMVCoQR(hexData);
            entries.forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.err.println("解析错误: " + e.getMessage());
        }
    }

    /**
     * 解析EMVCo QR码十六进制数据
     * @param hexData 原始十六进制字符串（不含空格）
     * @return TLV条目列表
     */
    public static List<TLVEntry> parseEMVCoQR(String hexData) {
        List<TLVEntry> entries = new ArrayList<>();
        int index = 0;

        while (index < hexData.length()) {
            // 1. 提取Tag（1字节）
            String tag = safeSubstring(hexData, index, 2);
            index += 2;

            // 2. 提取Length（1字节）
            String lengthHex = safeSubstring(hexData, index, 2);
            int length = Integer.parseInt(lengthHex, 16);
            index += 2;

            // 3. 提取Value
            int expectedValueLength = length * 2; // 每个字节占2个十六进制字符
            String valueHex = safeSubstring(hexData, index, expectedValueLength);
            index += expectedValueLength;

            // 4. 解码Value
            String decodedValue = decodeValue(tag, valueHex, length);

            entries.add(new TLVEntry(tag, lengthHex, valueHex, decodedValue));
        }

        return entries;
    }

    /**
     * 根据Tag类型解码Value
     */
    private static String decodeValue(String tag, String valueHex, int length) {
        try {
            switch (tag) {
                case "53": // 货币代码（ASCII）
                case "58": // 国家代码（ASCII）
                case "59": // 商户名称（ASCII）
                    return hexToAscii(valueHex);

                case "54": // 交易金额（BCD编码优先）
                    return decodeBCDAmount(valueHex);

                case "52": // 商户类别码（MCC需为4位数字）
                    String mcc = hexToAscii(valueHex);
                    return mcc.matches("\\d{4}") ? mcc : mcc + " (Invalid MCC)";

                case "63": // CRC校验码（直接返回Hex）
                    return valueHex;

                default: // 非标准Tag标记警告
                    return hexToAscii(valueHex) + " (Non-standard Tag)";
            }
        } catch (Exception e) {
            return hexToAscii(valueHex) + " (Decode Error)";
        }
    }

    /**
     * BCD解码（处理金额字段）
     */
    private static String decodeBCDAmount(String valueHex) {
        StringBuilder amount = new StringBuilder();
        for (int i = 0; i < valueHex.length(); i += 2) {
            String byteStr = valueHex.substring(i, Math.min(i + 2, valueHex.length()));
            int bcd = Integer.parseInt(byteStr, 16);
            amount.append(bcd / 10); // 高位数字
            amount.append(bcd % 10); // 低位数字
        }
        return amount.toString().replaceFirst("^0+(?!$)", "");
    }

    /**
     * 十六进制转ASCII
     */
    private static String hexToAscii(String hex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String byteStr = hex.substring(i, Math.min(i + 2, hex.length()));
            sb.append((char) Integer.parseInt(byteStr, 16));
        }
        return sb.toString();
    }

    /**
     * 安全截取子字符串（自动处理越界）
     */
    private static String safeSubstring(String str, int start, int length) {
        int end = Math.min(start + length, str.length());
        return str.substring(start, end);
    }

    /**
     * TLV条目数据类
     */
    public static class TLVEntry {
        private final String tag;
        private final String length;
        private final String valueHex;
        private final String valueDecoded;

        public TLVEntry(String tag, String length, String valueHex, String valueDecoded) {
            this.tag = tag;
            this.length = length;
            this.valueHex = valueHex;
            this.valueDecoded = valueDecoded;
        }

        @Override
        public String toString() {
            return String.format("Tag: %-2s | Length: %-2s | Value (Hex): %-20s | Decoded: %s",
                    tag, length, valueHex, valueDecoded);
        }
    }
}