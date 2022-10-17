package com.zqr.entity;

import com.alibaba.fastjson.JSON;

/**
 * @author Kendric
 * @className Other
 * @description
 * @createTime 2022/9/26 14:15
 */

public class OtherPeople extends People{
    private int maxCount;

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public String toString() {
        return "OtherPeople" + JSON.toJSONString(this);
    }
}
