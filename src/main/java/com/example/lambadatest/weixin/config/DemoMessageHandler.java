package com.example.lambadatest.weixin.config;

import com.sinsz.wxpn.Handler;
import org.nutz.json.Json;

/**
 * @Author ChenXingNan
 * @Date 2020/12/10 15:04
 **/
public class DemoMessageHandler implements Handler {
    @Override
    public String handler(String s, String s1, String s2, String s3, String s4) {
        System.out.println(Json.fromJsonAsMap(Object.class, s));
        return "hello world";
    }
}
