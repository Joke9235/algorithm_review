package com.zqr._算法;

/**
 * @author Kendric
 * @className TimeComplexity
 * @description
 * @createTime 2021/9/1 15:08
 */
public class TimeComplexity {
    public static void main(String[] args) {
//        addHundred();
        calculateHundred();
    }

    //求和1加到100
    public static void addHundred() {
        long start = System.currentTimeMillis();
        int n = 100;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println((n + 1) * n / 2);
        long end = System.currentTimeMillis();
        System.out.println(end - start);//这个时间与电脑配置有关，不准确
    }

    //求100个1+100个2+...100个100
    public static void calculateHundred() {
        int sum = 0;
        int n = 100;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

}
