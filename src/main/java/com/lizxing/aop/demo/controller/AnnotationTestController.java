package com.lizxing.aop.demo.controller;

import com.lizxing.aop.demo.annotation.LoginRequired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnnotationTestController {
    @RequestMapping("sourceA")
    public String sourceA(){
        return "访问资源A";
    }

    @LoginRequired
    @RequestMapping("sourceB")
    public String sourceB(){
        return "访问资源B";
    }
}
