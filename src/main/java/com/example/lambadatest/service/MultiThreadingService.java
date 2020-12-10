package com.example.lambadatest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author ChenXingNan
 * @Date 2020/11/20 15:00
 **/
@Service
@Slf4j
public class MultiThreadingService {
    @Async
    public void executeAysncTask1(Integer i){
        log.info("执行异步任务1-->"+i);
    }
    @Async
    public void executeAysncTask2(Integer i){
        log.info("执行异步任务2-->"+i);
    }
}
