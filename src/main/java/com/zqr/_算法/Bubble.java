package com.zqr._算法;

import java.util.Arrays;

/**
 * @author Kendric
 * @className Bubble
 * @description
 * @createTime 2021/9/1 15:58
 */
public class Bubble {
    public static void main(String[] args) {
        Integer [] arr = {5,4,3,6,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for(int j = 0;j<i;j++){
                if(greater(a[j],a[j+1])){
                    exch(a,i,j);
                }
            }
        }

    }

    /**
     * @Description 比较v是否大于w
     **/
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * @Description
     **/
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

