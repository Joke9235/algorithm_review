package com.zqr.test;

import java.util.Random;

/**
 * @author Kendric
 * @className Random
 * @description
 * @createTime 2022/9/29 15:21
 */

public class RandomNumber {
    public static void main(String[] args) {
        for (int i = 0;i<1000;i++){
            System.out.println(generateRandomNum());
        }
    }

    public static String generateRandomNum() {
        Random random = new Random();
        int num = random.nextInt(999999);
        //不足六位前面补0
        String str = String.format("%06d", num);
        return str;
    }
}
