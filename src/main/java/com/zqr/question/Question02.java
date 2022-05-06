package com.zqr.question;

import com.sun.javafx.applet.ExperimentalExtensions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Kendric
 * @className Question02
 * @description 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * @createTime 2021/9/27 11:19
 */
public class Question02 {
    public static void main(String[] args) {
        System.out.println(isUnique("dabcdc"));
    }

    public static boolean isUnique(String astr) {
        //HashMap
        if (astr.length() > 1) {
            Map<Character, Boolean> words = new HashMap();
            words.put(astr.charAt(0), true);
            for (int i = 1; i < astr.length(); i++) {
                try {
                    boolean result = words.get(astr.charAt(i));
                    if (result)
                        return false;
                } catch (Exception e) {
                    words.put(astr.charAt(i), true);
                }
            }
        }

        //HashSet
//        if (astr.length() > 1) {
//            HashSet<Character> set = new HashSet<>(astr.length());
//            for (char c : astr.toCharArray()) {
//                if (!set.add(c)) {
//                    return false;
//                }
//            }
//        }

        return true;
    }
}
