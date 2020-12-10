package com.example.lambadatest.controller;

import com.example.lambadatest.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;


/**
 * @Author ChenXingNan
 * @Date 2020/11/20 13:43
 **/
@Api("MongoDB测试")
@RestController
@RequestMapping("/mongoDb")
public class MongoDBController {
    @Autowired
    private MongoTemplate mongoTemplate;
    @ApiOperation(value = "保存user",notes = "")
    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user){
        mongoTemplate.save(user);
    }
    @DeleteMapping("/deleteUser")
    public void deleteUser(String id){
        mongoTemplate.remove(id);
    }
    @GetMapping("findUser")
    public User findUser(String id){
        Query query=new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query,User.class);

    }
}
