package com.zqr.study;

import java.util.ArrayList;

/**
 * @author Kendric
 * @className ParameterPassingDemo
 * @description 共享传递，是指在调用函数时，传递给函数的是实参的地址的拷贝（如果实参在栈中，则直接拷贝该值）
 * @createTime 2021/10/27 13:50
 */
public class ParameterPassingDemo {
    public static void main(String[] args) {
        int a = 10;
       StringBuffer b = new StringBuffer("main");
       String c = "main";

        changeInt(a);
        System.out.println("main a => "+a);
        System.out.println("-----------------------");
        changeStringBuffer(b);
        System.out.println("main b => "+b);
        System.out.println("-----------------------");
        changeString(c);
        System.out.println("main c => "+c);
    }

    //copy了一份值赋给形参
    private static void changeInt(int a){
        a = 20;
        System.out.println("change a => "+a);
    }

    //传递了引用的地址给形参指向
    private static void changeStringBuffer(StringBuffer b){
        //对指向内存进行修改
        b.append("change");
        //修改指向为新new的对象
//        b = new StringBuffer("change");
        System.out.println("change b => "+ b);
    }

    private static void changeString(String c){
        c = "change";
        System.out.println("change c => "+ c);
    }
}
