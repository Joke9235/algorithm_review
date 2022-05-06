package com.zqr.leetcode.day01;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Kendric
 * @className Question01
 * @description 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * @createTime 2021/10/18 10:25
 */
public class Question01 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
//        System.out.println(containsDuplicate1(nums));
        System.out.println(containsDuplicate2(nums));
    }

    public static boolean containsDuplicate1(int[] nums) {
        //数组排序，判断相邻两个元素
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        //哈希表,插入数据已存在说明重复数据
        HashSet<Integer> set = new HashSet();
        for (int x:nums){
            if(!set.add(x))return true;
        }
        return false;
    }


}
