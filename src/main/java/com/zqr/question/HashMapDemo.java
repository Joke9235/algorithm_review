package com.zqr.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Kendric
 * @className HashMapDemo
 * @description
 * @createTime 2021/9/27 14:09
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap();
        map.put('a', 1);
        map.put('b', 2);
        map.put('c', 3);
        //取value
        map.get('a');
        //遍历
        map.forEach(
                (key, value) -> {
                    System.out.println(key + ":" + value);
                });


    }
}
