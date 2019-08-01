package com.zhuhaoman.aop.monitor.forth;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestXmlBeforeAdvice
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 16:39
 **/
public class TestXmlBeforeAdvice {
    public static void main(String[] args) {
        String xmlPath = "proxy.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("aaaa");
    }
}
