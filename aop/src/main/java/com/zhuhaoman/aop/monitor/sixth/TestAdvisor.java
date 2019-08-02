package com.zhuhaoman.aop.monitor.sixth;

import com.zhuhaoman.aop.monitor.forth.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestAdvisor
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 11:15
 **/
public class TestAdvisor {
    public static void main(String[] args) {
        String configPath = "static-method-advisor.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Seller seller = (Seller) ctx.getBean("seller");
        waiter.greetTo("zzzz");
        waiter.serveTo("zzzz");
        seller.greetTo("cccc");
    }
}
