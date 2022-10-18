package com.zqr.study;

import com.zqr.entity.People;
import com.zqr.entity.Worker;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Kendric
 * @className BeanUtilDemo
 * @description Bean工具类
 * @createTime 2022/2/16 16:39
 */

/**
 * BeanUtils.copyProperties: 相同字段copy，其他不处理，null也copy！！！
 **/

public class BeanUtilDemo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        People people = new People();
        people.setId(1);
        people.setName("joke");
        people.setSex("boy");
//        people.setAge("18");

        Worker worker = new Worker();
        worker.setId(2);
        worker.setName("kendric");
        worker.setAge("20");
        worker.setGrade("light");

        BeanUtils.copyProperties(worker,people);// 第一个参数是：目标存储，第二个参数：源数据


        System.out.println(worker);
        System.out.println(people);
        /*结果显示：相同字段copy，其他不处理，null也copy！！！
         Worker{id=1, name='joke', age='null', grade='light'}
         People{id=1, name='joke', sex='boy', age='null'}
         **/

    }
}
