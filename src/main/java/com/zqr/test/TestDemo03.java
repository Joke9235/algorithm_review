package com.zqr.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Kendric
 * @className TestDemo03
 * @description JSONObject 的getString(key)不会报空指针
 * @createTime 2022/10/12 20:04
 */

public class TestDemo03 {
    public static void main(String[] args) {
        JSONObject jsonObject = JSONObject.parseObject("{\"loginName\":null,\"userId\":null,\"channel\":\"MBS\",\"body\":{\"custId\":\"8455\",\"custType\":\"P\"}}");
        System.out.println(jsonObject);
        JSONObject body = jsonObject.getJSONObject("body");
        System.out.println(body);
        String userId = body.getString("userId");
        System.out.println(userId);
    }
}
