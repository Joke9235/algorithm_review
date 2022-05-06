package com.zqr.question;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * @author Kendric
 * @className Question01
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 要求给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额
 * @createTime 2021/9/2 15:52
 */
public class Question01 {
    public static void main(String[] args) {
        double[] house = {3,1,1,20,1,1};
        System.out.println(Arrays.toString(house));
        calculateMaxMoney(house);
    }

    public static void calculateMaxMoney(double[] house) {
        //1.只能偷不想零的两间房子
        //2.最后一间房子和第一件房子是相邻的

        //临时变量存储最大金额
        double maxMoney = 0;

        //数组长度-多少间屋子
        int length = house.length;
        //如果是偶数，最多能偷n/2间(我为什么非得偷完这么多间？思路错误~~~)
//        if (length % 2 == 0) {
//            //一共就两种情况
//            for (int i = 0; i < 2; i = i + 1) {
//                double tempMoney = 0;
//                for (int j = i; j < length; j = j+2) {
//                    System.out.println(j);
//                    tempMoney += house[j];
//
//                }
//                if (maxMoney < tempMoney) maxMoney = tempMoney;
//                System.out.println(tempMoney);
//            }
//        }
        //如果是奇数，最多能偷(n-1)/2间



        System.out.println("最多可以偷" + maxMoney);

    }

    public double rob(double[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }

        double[] dp = new double[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    public static int getNext(int index, int length) {
        index++;
        return (index + 2) % length - 1;
    }

    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }
}
