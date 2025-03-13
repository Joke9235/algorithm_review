package com.zqr.study;


import com.zqr.entity.People;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @author Kendric
 * @className TestDemo3
 * @description
 * @createTime 2023/4/23 14:09
 */

public class ObjectGetValueByName {
    public static void main(String[] args) {
        People people = new People();
        people.setName("Kendric");
        Object obj = people;

        // 使用获取到的属性值
        Object name = getFieldValueByName1("name", obj);
        System.out.println("方式1取得属性值为：" + name);


        Object name1 = getFieldValueByName2("name", obj);
        System.out.println("方式2取得属性值为：" + name1);
    }

    /* 根据属性名获取属性值
     * */
    private static Object getFieldValueByName1(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /* 根据属性名获取属性值
     * */
    private static Object getFieldValueByName2(String fieldName, Object o) {
        // 获取Object的Class对象
        Class<?> objClass = o.getClass();

        // 获取属性值
        Object propertyValue = null;
        try {
            // 获取属性名称为"propertyName"的属性对象
            Field field = objClass.getDeclaredField(fieldName);
            // 设置访问权限
            field.setAccessible(true);
            // 获取属性值
            propertyValue = field.get(o);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return propertyValue;
    }
}
