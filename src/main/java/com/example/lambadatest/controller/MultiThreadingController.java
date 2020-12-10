package com.example.lambadatest.controller;

import com.example.lambadatest.service.MultiThreadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenXingNan
 * @Date 2020/11/20 15:08
 **/
@RestController
@RequestMapping("/multiThreading")
public class MultiThreadingController {
    @Autowired
    private MultiThreadingService multiThreadingService;
    @GetMapping("/doTask")
    public String doTask(){
        for (int i = 0; i < 10; i++) {
            multiThreadingService.executeAysncTask1(i);
            multiThreadingService.executeAysncTask2(i);
        }
        return "success";
    }
}
