package com.zhuhaoman.aop.aspect;

import com.zhuhaoman.aop.monitor.forth.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName PointcutFucTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 11:31
 **/
public class PointcutFucTest {
    public static void main(String[] args) {
        String configPath = "aspectj.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = (Waiter) ctx.getBean("waiter");
        Waiter naWaiter = (Waiter) ctx.getBean("naughtyWaiter");

        waiter.greetTo("aaaa");
        naWaiter.greetTo("bbbb");
    }
}
