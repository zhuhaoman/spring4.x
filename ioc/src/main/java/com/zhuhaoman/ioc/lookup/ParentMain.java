package com.zhuhaoman.ioc.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName ParentMain
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/14 18:31
 **/
public class ParentMain {
    public static void main(String[] args) {
        String configPath = "parent.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Car car3 = (Car) ctx.getBean("car3");
        System.out.println(car3.getPrice());
        Car car4 = (Car) ctx.getBean("car4");
        System.out.println(car4.getPrice());
    }
}
