package com.zqr.study;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

/**
 * @author Kendric
 * @className StringToLocalDate
 * @description
 * @createTime 2023/4/22 19:59
 */

public class StringToLocalDate {
    public static void main(String[] args) {
        // String 转 LocalDate
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.parse("20220428",BASIC_ISO_DATE);
        LocalDate localDate2 = LocalDate.parse((CharSequence) "20220427",dtf);
        System.out.println(localDate);
        System.out.println(localDate2);
    }
}
