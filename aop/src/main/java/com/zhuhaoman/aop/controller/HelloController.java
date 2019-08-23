package com.zhuhaoman.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/19 19:25
 **/
@RestController
public class HelloController {
    @RequestMapping("/test")
    public void test() {
        System.out.println("hello world");
    }
}
