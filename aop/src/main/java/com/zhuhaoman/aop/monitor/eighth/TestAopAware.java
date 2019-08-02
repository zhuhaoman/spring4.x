package com.zhuhaoman.aop.monitor.eighth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestAopAware
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 15:26
 **/
public class TestAopAware {
    public static void main(String[] args) {
        String configPath = "beans-aware.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.serverTo("qqqqq");
    }
}
