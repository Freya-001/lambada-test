package com.example.lambadatest.weixin.pojo;

/**
 * @Author ChenXingNan
 * @Date 2020/12/10 17:24
 **/
/**
 * @Description: 复合类型的按钮（也就是含有子菜单的一级菜单）
 * @Parameters:
 * @Return:
 * @Create Date: 2018年3月10日上午9:43:13
 * @Version: V1.00
 * @author: 来日可期
 */
public class ComplexButton extends Button{
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }

}

