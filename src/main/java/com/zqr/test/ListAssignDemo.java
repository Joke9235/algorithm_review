package com.zqr.test;

import com.zqr.entity.Worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kendric
 * @className ListAssignDemo
 * @description 修改List所以对象的某个属性的值
 * @createTime 2022/5/30 13:35
 */

public class ListAssignDemo {
    public static void main(String[] args) {
        Worker worker1 = new Worker(1,"1","1","100");
        Worker worker2 = new Worker(2,"2","2","100");
        Worker worker3 = new Worker(3,"3","3","100");
        Worker worker4 = new Worker(4,"4","4","100");
        List<Worker> list = new ArrayList<>();
        list.add(worker1);
        list.add(worker2);
        list.add(worker3);
        list.add(worker4);
        System.out.println(list.toString());
        list.forEach(e -> {
            e.setGrade("0");
        });
        System.out.println(list.toString());

    }
}
