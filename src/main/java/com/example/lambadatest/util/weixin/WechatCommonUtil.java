package com.example.lambadatest.util.weixin;

/**
 * 获取微信调用高级接口的凭证（access_token）
 * @Author ChenXingNan
 * @Date 2020/12/10 17:30
 **/

import com.alibaba.fastjson.JSONObject;
import com.example.lambadatest.weixin.core.WechatConstants;
import com.example.lambadatest.weixin.pojo.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class WechatCommonUtil {
    Logger logger = LoggerFactory.getLogger(WechatCommonUtil.class);

    /**
     * 获取access_token接口
     */
    private static String token_url = WechatConstants.ACCESS_TOKEN_URL;
    @Autowired
    private HttpRequestUtil httpRequestUtil;

    public AccessToken getAccessToken(String appid, String appsecret){
        //将公众号的appid和appsecret替换进url
        String url = token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
        AccessToken accessToken = new AccessToken();
        //发起get请求获取凭证
        JSONObject jsonObject = httpRequestUtil.httpsRequest(url,"GET",null);
        logger.info("获取到的json格式的Token为:"+jsonObject);
        if (jsonObject!=null) {
            try {
                accessToken.setAccess_token(jsonObject.getString("access_token"));
                accessToken.setExpires_in(jsonObject.getInteger("expires_in"));
            } catch (Exception e) {
                accessToken = null;
                //获取token失败
                logger.error("获取token失败 errcode:{} errmsg:{}",
                        jsonObject.getInteger("errcode"),
                        jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }
}
