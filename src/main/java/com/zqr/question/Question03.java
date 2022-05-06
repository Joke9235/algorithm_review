package com.zqr.question;

/**
 * @author Kendric
 * @className Question03
 * @description 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * @createTime 2021/9/27 13:58
 */
public class Question03 {
    public static void main(String[] args) {
        System.out.println(CheckPermutation("abca", "cbab"));
    }

    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String[] list2 = s2.split("");
        for (String s : list2) {
            if (!s1.contains(s)) return false;
            s1 = s1.replaceFirst(s,"");
        }
        return true;
    }
}
