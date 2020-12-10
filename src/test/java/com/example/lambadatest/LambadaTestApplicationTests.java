package com.example.lambadatest;

import com.example.lambadatest.pojo.User;
import com.example.lambadatest.util.CronUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class LambadaTestApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hahhah");
        List<Integer> list = Arrays.asList(7,1, 2, 3, 4, 5, 6);
        //循环
        list.forEach(num->{
            System.out.println(num);
        });
        //排序
        Collections.sort(list,(o1,o2)->
            o1.compareTo(o2)
        );
        list.forEach(System.out::println);
        ArrayList<User> list1 = new ArrayList<>();
        list1.add(new User("tom",10));
        list1.add(new User("jerry",9));
        list1.stream().filter(u->u.getUsername()=="tom")
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
    @Test
    public void test2(){
        String body = "{\n" +
                "  \"DATA_REGION\": \""+"ocId"+"\",\n" +
                "  \"fields\": [\n" +
                "    \"WELL_ID\",\n" +
                "    \"WELL_COMMON_NAME\",\n" +
                "    \"ZONE_NAME\",\n" +
                "    \"ZONE_ID\",\n" +
                "    \"TOP_TVD\",\n" +
                "    \"TVD_BASE\"\n" +
                "  ],\n" +
                "  \"filter\": {\n" +
                "    \"logic\": \"AND\",\n" +
                "    \"subFilter\": [\n" +
                "      {\n" +
                "        \"logic\": \"AND\",\n" +
                "        \"key\": \"ZONE_NAME\",\n" +
                "        \"symbol\": \"LIKE\",\n" +
                "        \"singleValue\": \"%"+"zoneName"+"%\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";
        System.out.println("结果为"+body);
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
    }
    @Test
    public void test3(){
        try {
            String s = CronUtil.GetCronToDate("2018-08-11 12:11:00");
            System.out.println("转换后的cron表达式为"+s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



}
