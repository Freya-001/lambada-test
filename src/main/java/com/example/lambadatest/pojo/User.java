package com.example.lambadatest.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author ChenXingNan
 * @Date 2020/11/16 18:09
 **/
@Data
@EqualsAndHashCode
@ApiModel(value = "user对象",description = "")
public class User {
    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    private static final long serialVersionUID=1L;
//    @ApiModelProperty(value = "id")
//    private String id;
    @ApiModelProperty(value = "username")
    private String username;
//    @ApiModelProperty(value = "password")
//    private String password;
//    @ApiModelProperty(value = "registerTime")
//    private String registerTime;
//    @ApiModelProperty(value = "phone")
//    private String phone;
//    @ApiModelProperty(value = "name")
//    private String name;
//    @ApiModelProperty(value = "sex")
//    private String sex;
    @ApiModelProperty(value = "age")
    private Integer age;


}
