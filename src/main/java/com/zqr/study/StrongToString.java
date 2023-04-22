package com.zqr.study;

import com.zqr.entity.OtherPeople;

/**
 * @author Kendric
 * @Description 继承类的打印
 * @createTime 2022/9/26 14:16
 */

/**
 * OtherPeople类 继承了 People类，但是toString方法打印不了People类的字段
 * 按下面一样重写同toString方法即可👇
 *
 * @Override
 *     public String toString() {
 *         return "OtherPeople" + JSON.toJSONString(this);
 *     }
 *
 **/

public class StrongToString {

    public static void main(String[] args) {
        OtherPeople other = new OtherPeople();
        other.setMaxCount(1);
        other.setId(212433);
        other.setName("Joke");
        other.setAge("18");
        other.setSex("男");
        System.out.println(other);
    }
}
