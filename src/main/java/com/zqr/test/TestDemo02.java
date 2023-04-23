package com.zqr.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Kendric
 * @className TestDemo2
 * @description
 * @createTime 2023/2/2 14:56
 */

public class TestDemo02 {
    public static void main(String[] args) {
//        String a = "914889844688158720,1067038157582630912,1067038775537827840,1067039108339073024,1067039859215958016,1067040410859208704,1067040836937580544";
//        String b = "914889844688158720";
//        List<String> defaultSmsUserList = Arrays.asList(b.split(","));
//        System.out.println(defaultSmsUserList);
//        System.out.println(defaultSmsUserList.contains("1067038157582630912"));
//        BigDecimal amount = new BigDecimal(1023);
//        BigDecimal sum = new BigDecimal(0.00);
//        BigDecimal divide = amount.divide(new BigDecimal(4000), 2, BigDecimal.ROUND_HALF_UP);
//        sum = sum.add(divide);
//        System.out.println(divide);
//        System.out.println(sum);

//            List<String> list= new ArrayList<>();
//            list.add("22");
//            list.add("33");
//        String s = list.stream().filter(
//                user -> Objects.equals(user, "33")).findFirst().get();
//        System.out.println(s);
//        List<String> strings = SmsTemplateEnum.smsTypeList();
//        System.out.println(strings);
//
//        SmsTemplateEnum value = SmsTemplateEnum.getByKey("resetRandomPassword" + "LANG_EN");
//        System.out.println(value.templateName);

//        String trueId = Long.parseLong("1082625401647267840") + 1 + "";
//        System.out.println(trueId);
        People people = new People();
        people.setName("Kendric");
        Object obj = people;
        // 获取Object的Class对象
        Class<?> objClass = obj.getClass();

        // 获取属性值
        Object propertyValue = null;
        try {
            // 获取属性名称为"propertyName"的属性对象
            Field field = objClass.getDeclaredField("name");
            // 设置访问权限
            field.setAccessible(true);
            // 获取属性值
            propertyValue = field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

// 使用获取到的属性值
        System.out.println("属性值为：" + propertyValue);


    }

    /* 根据属性名获取属性值
     * */
    private static Object getFieldValueByName(String fieldName, Object o) {
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
}
