package com.zqr.study;

import java.util.Collections;
import java.util.Random;

/**
 * @author Kendric
 * @className RandomNumberDemo
 * @description 生成 n位随机数字
 * @createTime 2022/9/29 15:21
 */

public class RandomNumberDemo {
    public static void main(String[] args) {
        for (int i = 0;i<100;i++){
            System.out.println(generateRandomNum(6));
        }
    }

    /**
     * @Description 生成 n位随机数字
     * @param count
     * @return java.lang.String
     **/
    public static String generateRandomNum(int count) {
        Random random = new Random();
        // 生成n个9
        String s = String.join("", Collections.nCopies(count, "9"));
        int bound  = Integer.parseInt(s);
        // 生成 0 - n个9 范围内的随机值
        int num = random.nextInt(bound);
        //不足六位前面补0
        String format = "%0" + count + "d";
        String str = String.format(format, num);
        return str;
    }
}
