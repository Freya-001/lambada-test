package com.example.lambadatest.controller;

import com.example.lambadatest.util.weixin.WechatCommonUtil;
import com.example.lambadatest.util.weixin.WechatMenuManagerUtil;
import com.example.lambadatest.util.weixin.WechatMenuUtil;
import com.example.lambadatest.weixin.pojo.Menu;
import com.sinsz.wxpn.WxpnBean;
import com.sinsz.wxpn.open.base.BaseService;
import com.sinsz.wxpn.open.base.impl.BaseServiceImpl;
import com.sinsz.wxpn.open.menu.MenuService;
import com.sinsz.wxpn.open.menu.impl.MenuServiceImpl;
import com.sinsz.wxpn.properties.WxpnProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 对订阅号的菜单的操作
 *
 * @Author ChenXingNan
 * @Date 2020/12/10 15:53
 **/
@Api("对订阅号的菜单的操作")
@RequestMapping("/demo/menu")
@RestController
@AllArgsConstructor
public class MenuController {

//    @Autowired
//    private WxpnProperties wxpnProperties;
//
//    @ApiOperation("菜单查询")
//    @GetMapping("/getMenu")
//    public String getMenu(HttpServletResponse httpResponse) {
//        BaseServiceImpl baseService = new BaseServiceImpl(wxpnProperties,httpResponse);
//        MenuServiceImpl menuService = new MenuServiceImpl(wxpnProperties);
//        String menuInfo = "";
//        String token = baseService.fetchToken();
//        if (StringUtils.isNotEmpty(token)) {
//            menuInfo = menuService.fetchMenuInfo(token);
//        }
//        return menuInfo;
//    }

    @ApiOperation("创建菜单")
    @GetMapping("/createMenu")
    public void createMenu() {
        WechatCommonUtil wechatCommonUtil = new WechatCommonUtil();
        WechatMenuUtil wechatMenuUtil = new WechatMenuUtil();
        WechatMenuManagerUtil wechatMenuManagerUtil = new WechatMenuManagerUtil();
        String appid = "wx60b11a703528eb08";
        String appsecret = "266dd4b13c3d1b34a9dd6e34943b8d9f";

        //获取access_token
        String accessToken = wechatCommonUtil.getAccessToken(appid, appsecret).getAccess_token();
        //获取菜单结构
        Menu menu = wechatMenuManagerUtil.getMenu();
        if (accessToken!=null) {
            //生成菜单
            boolean result = wechatMenuUtil.creatMenu(menu, accessToken);
            if (result) {
                System.out.println("菜单创建成功");
            }else {
                System.out.println("菜单创建失败");
            }
        }else {
            System.out.println("token为空");
        }
    }

}
