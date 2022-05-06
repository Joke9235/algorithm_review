package com.zqr.encrypt;

/**
 * @author Kendric
 * @className CaesarDemo
 * @description 凯撒密码
 * @createTime 2021/12/14 14:26
 */
public class CaesarDemo {
    public static void main(String[] args) {
        //明文：原始信息
        String clearText = "kendric";
        //加密规则：将字母按字母表向右移动3位
        int key = 3;
        //密文：通过加密算法将明文混淆之后的信息
        String cipher = encrypt(clearText, key);
        System.out.println(cipher);
        //解密：将字母按字母表想左移动3位
        String rawText = decrypt(cipher, key);
        System.out.println(rawText);

    }

    private static String encrypt(String clearText, int key) {
        char[] chars = clearText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //取出每一个字母，向右移动3位
            //ASCII码表：a(97) b(98)
            //将移动后的字母替换原来的字母
            chars[i] += key;
        }
        return new String(chars);
    }

    private static String decrypt(String clearText, int key) {
        char[] chars = clearText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //取出每一个字母，向右移动3位
            //ASCII码表：a(97) b(98)
            //将移动后的字母替换原来的字母
            chars[i] -= key;
        }
        return new String(chars);
    }
}
