package com.example.lambadatest.weixin.pojo;

/**
 * 微信通用接口凭证
 *
 * @Author ChenXingNan
 * @Date 2020/12/10 17:35
 **/
public class AccessToken {
    // 获取到的凭证
    private String access_token;
    // 凭证有效时间，单位：秒
    private int expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}