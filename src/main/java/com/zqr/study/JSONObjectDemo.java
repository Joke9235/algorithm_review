package com.zqr.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zqr.entity.People;

/**
 * @author Kendric
 * @className JSONObjectDemo
 * @description JSONObject 的getString(key)不会报空指针
 *              JSON.parseObject() 只要是json格式有字段没有值不会报错
 * @createTime 2022/10/12 20:04
 */

public class JSONObjectDemo {
    public static void main(String[] args) {
        // 如果字符串不是json格式, 会报错
        String s = "{\"loginName\":null,\"userId\":null,\"channel\":\"MBS\",\"body\":{\"age\":\"21\"}}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println("jsonObject --> " + jsonObject);
        JSONObject body = jsonObject.getJSONObject("body"); //如果没有body, 会报错
        System.out.println("jsonObject.getJSONObject(\"body\") --> " + body);
        String userId = body.getString("userId");//没有userId字段, 但不会报错, 如果用.get(key), 则会报错
        System.out.println("body.getString(\"userId\") --> " + userId);

        // 用JSON.parseObject，如果json字符串里面没有部分字段，并不会报错，只是这些字段的值为null
        String json = "{\"name\":\"ss\"}";
        People people = JSON.parseObject(json, People.class);
        System.out.println("people.getAge() == null --> " + (people.getAge() == null)); // json里面没有age, 结果生成的Object里面的age为null
        System.out.println(people);
    }
}
