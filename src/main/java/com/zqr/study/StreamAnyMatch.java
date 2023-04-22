package com.zqr.study;

import java.util.stream.Stream;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

/**
 * @author Kendric
 * @className TestDemo01
 * @description 匹配一个集合里面的任意值(该集合里面可以存放各个类型)
 * @createTime 2022/4/28 11:48
 */

public class StreamAnyMatch {
    public static void main(String[] args) {

        // 匹配一个集合里面的任意值(该集合里面可以存放各个类型)
        Integer a = 3;
        if(Stream.of(1,2,3).anyMatch(a::equals)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}
