package com.zqr.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kh.org.nbc.bakong_khqr.utils.StringUtils;

/**
 * @author Kendric
 * @className JWTTest
 * @description
 * @createTime 2022/11/9 14:59
 */

public class JWTTest {
    public static void main(String[] args) {
        String encryptString = encrypt("{\n" +
                "    \"amount\":\"99.00\",\n" +
                "    \"currency\":\"USD\",\n" +
                "    \"terminal\":\"12345678\",\n" +
                "    \"reference\":\"20221112\",\n" +
                "    \"transType\":\"4\",\n" +
                "    \"timeOut\":\"30\"\n" +
                "}", "apd_qr_code");
        System.out.println(encryptString);
        Claims claims = decrypt(encryptString, "apd_qr_code");
        String amount = (String)claims.get("ss");
        String currency = (String)claims.get("currency");
        String terminal = (String)claims.get("terminal");
        String reference = (String)claims.get("reference");
        String transType = (String)claims.get("transType");
        String timeOut = (String)claims.get("timeOut");
        System.out.println(claims);
    }


    /**
     * 加密
     * @param data
     * @param secret
     * @return
     */
    public static String encrypt(String data, String secret) {
        if (StringUtils.isEmpty(data) || StringUtils.isEmpty(secret)) {
            return null;
        }
        byte[] bytes = secret.getBytes();
        String JwtToken = Jwts.builder()
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                .setPayload(data)
                .signWith(SignatureAlgorithm.HS256, bytes)
                .compact();
        return JwtToken;
    }

    /**
     * 解密
     * @param data
     * @param secret
     * @return
     */
    public static Claims decrypt(String data, String secret) {
        if (StringUtils.isEmpty(data) || StringUtils.isEmpty(secret)) {
            return null;
        }
        byte[] bytes = secret.getBytes();
        Jws<Claims> decryption = Jwts.parser()
                .setSigningKey(bytes)
                .parseClaimsJws(data);
        Claims claims = decryption.getBody();
        return claims;
    }
}
