package com.lizxing.aop.demo.controller;

import com.lizxing.aop.demo.annotation.WritingLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopTestController {
    @WritingLog
    @RequestMapping("test")
    public String test(){
        System.out.println("处理业务");
        return "完成";
    }
}
