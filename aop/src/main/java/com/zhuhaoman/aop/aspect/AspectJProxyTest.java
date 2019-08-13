package com.zhuhaoman.aop.aspect;

import com.zhuhaoman.aop.monitor.forth.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AspectJProxyTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 10:32
 **/
public class AspectJProxyTest {
    public static void main(String[] args) {
        String configPath = "aspectj.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("1111");
        //可进行类型强转
        Seller seller = (Seller) waiter;
        seller.sell("kkkk");
    }

}
