package com.zqr.test;

import java.util.stream.Stream;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

/**
 * @author Kendric
 * @className TestDemo01
 * @description
 * @createTime 2022/4/28 11:48
 */

public class TestDemo01 {
    public static void main(String[] args) {
          // String 转 LocalDate
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
//        LocalDate localDate = LocalDate.parse("20220428",BASIC_ISO_DATE);
//        LocalDate localDate2 = LocalDate.parse((CharSequence) "20220427",dtf);
//        System.out.println(localDate);
//        System.out.println(localDate2);

        // 匹配一个集合里面的任意值(该集合里面可以存放各个类型)
        Integer a = 3;
        if(Stream.of(1,2,3).anyMatch(a::equals)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}
