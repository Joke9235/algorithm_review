package com.zqr.test;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kendric
 * @className TestDemo
 * @description
 * @createTime 2022/3/10 10:31
 */

public class TestDemo {
    public static void main(String[] args) throws Exception {
        People people = new People();
        people.setName("a");
        Man man = new Man();
        BeanUtils.copyProperties(man, people);
        System.out.println(man.getName());
//       dochange();
    }

    private static void dochange() {
        List<People> list = Arrays.asList(new People("a"), new People("b"), new People("c"));
        List<Man> manList = new ArrayList<>();

        list.stream().forEach(e -> {
            try {
                Man man = new Man();
                BeanUtils.copyProperties(man, e);
                manList.add(man);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println(e.getName());
        });
        System.out.println(manList);
    }

}

class People {
    private String name;
    private String sex;

    public People() {
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

class Man {
    private String name;
    private String age;

    public Man() {
    }

    public Man(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

