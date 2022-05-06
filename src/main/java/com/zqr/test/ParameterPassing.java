package com.zqr.test;

import java.util.ArrayList;

/**
 * @author Kendric
 * @className ParameterPassing
 * @description 共享传递，是指在调用函数时，传递给函数的是实参的地址的拷贝（如果实参在栈中，则直接拷贝该值）
 * @createTime 2021/10/27 13:50
 */
public class ParameterPassing {
    public static void main(String[] args) {
        int a = 10;
       StringBuffer sb = new StringBuffer("main");

        changeInt(a);
        System.out.println("main a => "+a);
        System.out.println("-----------------------");
        changeInteger(sb);
        System.out.println("main s => "+sb);
    }

    //copy了一份值赋给形参
    private static void changeInt(int a){
        a = 20;
        System.out.println("change a => "+a);
    }

    //传递了引用的地址给形参指向
    private static void changeInteger(StringBuffer sb){
        //对指向内存进行修改
//        sb.append("change");
        //修改指向为新new的对象
        sb = new StringBuffer("change");
        System.out.println("change s => "+ sb);
    }
}
