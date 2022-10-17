package com.zqr.test;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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

          // 用JSON.parseObject，如果json字符串里面没有部分字段，并不会报错，只是这些字段的值为null
//        String s = "{\"name\":\"ss\"}";
//        com.zqr.entity.People people = JSON.parseObject(s,com.zqr.entity.People.class);
//        System.out.println(people.toString());

        // 匹配一个集合里面的任意值(该集合里面可以存放各个类型)
        Integer a = 3;
        if(Stream.of(1,2,3).anyMatch(a::equals)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}
