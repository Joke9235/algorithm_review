package com.zqr.test;

import java.util.regex.Pattern;

/**
 * @author Kendric
 * @className KHQR
 * @description
 * @createTime 2022/3/7 14:42
 */

public class KHQR {
    private static String FORMAT_ACCOUNT_ID = "^[^@]+[@][^@]+$";
    public static void main(String[] args) {
//        boolean result = Pattern.matches(FORMAT_ACCOUNT_ID, "41@255");
//        System.out.println(result);
        String ccy = KHQRCurrency.USD.toString();
        System.out.println(ccy);
    }
}

 enum KHQRCurrency {
    KHR("116"),
    USD("840");

    private final String value;

    KHQRCurrency(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
