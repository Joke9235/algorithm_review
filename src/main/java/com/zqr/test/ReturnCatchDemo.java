package com.zqr.test;

/**
 * @author Kendric
 * @className return_catch_test
 * @description return后面不接语句，try_catch也不例外，finally有return， try_catch的return不会执行
 * @createTime 2021/10/25 14:22
 */
public class ReturnCatchDemo {
    public static void main(String[] args) {
        System.out.println("out->"+get());
    }

    private static int get(){
        int i = 0;
        try {
//            return i;
//            System.out.println(i);
            throw new  Exception("test error");
        }catch (Exception e){
            return i;
//            i++;
//            System.out.println(i+"->catch");
        }finally {
            i++;
            return i;
//            System.out.println("finally->"+i);
        }
    }
}
