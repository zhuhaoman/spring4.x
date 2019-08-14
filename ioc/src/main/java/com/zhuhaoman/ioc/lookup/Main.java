package com.zhuhaoman.ioc.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/14 18:04
 **/
public class Main {
    public static void main(String[] args) {
        String configPath = "boss.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Boss1 boss = (Boss1) ctx.getBean("boss1");
        System.out.println(boss.getCar().getBrand());
    }
}
