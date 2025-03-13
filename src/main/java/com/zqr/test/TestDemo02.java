package com.zqr.test;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.zqr.leetcode.day07.ListNode;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Kendric
 * @className TestDemo2
 * @description
 * @createTime 2023/2/2 14:56
 */

public class TestDemo02 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
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
//            List<String> list = Arrays.asList("a","c","d");
//        List<String> c = list.stream().parallel().filter(s -> s.equals("b")).collect(Collectors.toList());
//        System.out.println();

//        List<People> peopleList = new ArrayList<>();
//        People people = new People("a","a");
//        people.setSex("c");
//        peopleList.add(people);
//        people = new People("b","b");
//        people.setSex("c");
//        peopleList.add(people);
//
//        peopleList.stream().forEach(item->{
//            System.out.println(item);
//        });
//        List<String> list = Arrays.asList("a","c","d");
//        String collect = list.stream().map(s -> "'" + s + "'").collect(Collectors.joining(","));
//        System.out.println(collect);
//        LocalDate startDate = LocalDate.of(2023,10,12);
//        LocalDate endDate = LocalDate.of(2023,12,29);
//        long until = startDate.until(endDate, ChronoUnit.MONTHS);
//        System.out.println(until);

//        DecimalFormat df =new DecimalFormat("#.00");
//        double v = 561.92 / 120000.00;
//        String s = df.format(v);
//        System.out.println(s);

        String str = "/wEPDwUKLTY2MjA2NzM3Mw9kFgICAw9kFgICAQ9kFgYCDw8WAh4JaW5uZXJodG1sZWQCFQ8PFgIeB0VuYWJsZWRnZGQCFw88KwALAQAPFggeCERhdGFLZXlzFgAeC18hSXRlbUNvdW50AgEeCVBhZ2VDb3VudAIBHhVfIURhdGFTb3VyY2VJdGVtQ291bnQCAWQWAmYPZBYCAgEPZBYYZg8PFgIeBFRleHQFBDM3MTVkZAIBDw8WAh8GBQbnqbrov5BkZAICDw8WAh8GBQbov5vlj6NkZAIDDw8WAh8GBQYmbmJzcDtkZAIEDw8WAh8GBQ5NRjgxMi8yMDI1MDMxM2RkAgUPDxYCHwYFCzczMTk3ODEwMzcwZGQCBg8PFgIfBgURMjAyNS8zLzEzIDA6MDA6MDBkZAIHDw8WAh8GBQEzZGQCCA8PFgIfBgUGMTA2LjUwZGQCCQ8PFgIfBgUM56Gu5oql5Yqo5oCBZGQCCg8PFgIfBgUM5q2j5bi455CG6LSnZGQCCw8PFgIfBgUJ5pyq6L+Q5oq1ZGRkZLeyDrul5X54msfAGBEiTQAAAAA=";
//        String base64 = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
//        System.out.println(base64);
        byte[] decode = Base64.getDecoder().decode(str);
        System.out.println("Decoded Bytes (Hex):");
        for (byte b : decode) {
            System.out.printf("%02X ", b);
        }
//        System.out.println(new String(decode));
//        byte[] imageBytes = Base64.getDecoder().decode("");
//        LocalDate startDt = LocalDate.parse("2023-09-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate matuDt = LocalDate.parse("2023-11-15", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        long month = startDt.until(matuDt, ChronoUnit.MONTHS);
//        System.out.println(month);

//        LocalDateTime birth = LocalDateTime.now();
//        System.out.println(birth);

//        System.out.println(isNumeric("HQ UAT VTM02"));
//        People peopleA = new People();
//        peopleA.setSex("Man");
//        List<People> peoples = new ArrayList<>();
//        List<String> list = Arrays.asList("1", "2", "3");
//        People people;
//
//        for(String a : list){
//            people = new People();
//            BeanUtils.copyProperties(people,peopleA);
//            people.setName(a);
//            peoples.add(people);
//        }
//        System.out.println(peoples);
//        System.out.println("XXX XXX "+"000111222".substring("000111222".length() - 3));
//        System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
//        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()));

//        mergeTwoLists();
//        String term = "M12";
//
//        String result = Integer.parseInt(term.substring(1,3))+term.substring(0,1);
//        System.out.println(result);
//        Tpp test = new Tpp();
//        System.out.println(JSON.toJSONString(test));
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        try {
//            Date effvInrsDate = format.parse("2024-05-28");
//            Date expiDate = format.parse("2024-06-10");
//            int days = expiDate.compareTo(effvInrsDate);
//            System.out.println(days);
//        } catch (Exception e) {
//        }
//        String a = null;
//        System.out.println(Boolean.TRUE.booleanValue());
//        String testStr = "\uD866\uDCD1";
//
//        String regex = "^[\\u2E80-\\u2EFF\\u2F00-\\u2FDF\\u31C0-\\u31EF\\u3200-\\u32FF\\u3300-\\u33FF\\u3400-\\u4DBF\\u4DC0-\\u4DFF\\u4E00-\\u9FBF\\uF900-\\uFAFF\\uFE30-\\uFE4F\\uff10-\\uff19a-zA-Z0-9/?:().'$()\\,&+\\-\\s]+$"; // 匹配一个或多个数字
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(testStr);
//        System.out.println(matcher.matches());
//        System.out.println(testStr);

    }



    private static void setVaule(StringBuilder number){
        number.append("11");
    }


    public static String addSpaces(String input) {
        // 使用正则表达式在每三位数字之间插入一个空格
        String formattedString = input.replaceAll("(\\d{3})", "$1 ");

        // 删除字符串末尾的空格（如果有的话）
        formattedString = formattedString.trim();

        return formattedString;
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return str.chars().allMatch(Character::isDigit);
    }

//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode newhead = new ListNode(-1);
//        ListNode listNode = newhead;
//        while (l1 != null && l2 != null) {
////            if(l1.val)
//        }
//
//    }




}

class Tpp {
    private BigDecimal rate;

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
