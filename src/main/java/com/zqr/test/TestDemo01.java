package com.zqr.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

/**
 * @author Kendric
 * @className TestDemo01
 * @description
 * @createTime 2022/4/28 11:48
 */

public class TestDemo01 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse("20220428",BASIC_ISO_DATE);
        LocalDate localDate2 = LocalDate.parse((CharSequence) "20220427",dtf);
        System.out.println(localDate);
        System.out.println(localDate2);
    }
}
