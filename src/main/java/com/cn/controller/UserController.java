package com.cn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description:
 * @Author huangjian
 * @Date 2024/4/27
 **/
@RequestMapping("/user")
@RestController
public class UserController {

    @GetMapping("/get")
    public String hello(){
        return "这是一个容器部署的测试例子-author:my";
    };
}
