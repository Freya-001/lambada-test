package com.example.lambadatest.weixin.pojo;

/**
 * @Author ChenXingNan
 * @Date 2020/12/10 17:23
 **/
/**
 * @Description: click类型的按钮（有type、name和key3个属性）
 * @Parameters:
 * @Return:
 * @Create Date: 2018年3月10日上午9:35:30
 * @Version: V1.00
 * @author: 来日可期
 */
public class ClickButton extends Button {
    private String type;
    private String key;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
}

