package com.zqr.leetcode.day02;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author Kendric
 * @className Question02
 * @description
 * @createTime 2021/10/27 11:21
 */
public class Question02 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
//        merge01(nums1, 3, nums2, 3);
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    //合并后排序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

    }

    public static void merge01(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
