package com.zhuhaoman.aop.monitor.seventh;

import com.zhuhaoman.aop.monitor.forth.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestDefaultFlow
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 13:50
 **/
public class TestDefaultFlow {
    public static void main(String[] args) {
        String configPath = "default-advisor.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);

        Waiter waiter = (Waiter) ctx.getBean("waiter3");
        WaiterDelegate waiterDelegate = new WaiterDelegate();
        waiterDelegate.setWaiter(waiter);
        waiter.greetTo("aaaaaa");
        waiter.serveTo("bbbbbb");
        //流程切点由该方法直接或间接发起其他方法的调用
        waiterDelegate.service("kkkkk");
    }
}
