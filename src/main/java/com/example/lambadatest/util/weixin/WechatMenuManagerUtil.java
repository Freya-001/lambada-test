package com.example.lambadatest.util.weixin;

/**
 * 菜单管理器类
 *
 * @Author ChenXingNan
 * @Date 2020/12/10 17:25
 **/


import com.example.lambadatest.weixin.pojo.Button;
import com.example.lambadatest.weixin.pojo.ClickButton;
import com.example.lambadatest.weixin.pojo.Menu;
import com.example.lambadatest.weixin.pojo.ViewButton;

public class WechatMenuManagerUtil {
    /**
     * @Description: 定义菜单结构
     */
    public Menu getMenu() {
        ClickButton firstClickButton = new ClickButton();
        firstClickButton.setName("功能图文");
        firstClickButton.setKey("function");
        firstClickButton.setType("click");

        ViewButton firstViewButton = new ViewButton();
        firstViewButton.setName("联系我们");
        firstViewButton.setType("view");
        firstViewButton.setUrl("");

        Menu menu = new Menu();
        Button[] boButtons = {firstClickButton, firstViewButton};
        menu.setButton(boButtons);

        return menu;
    }
}
