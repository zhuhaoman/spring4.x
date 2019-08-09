package com.zhuhaoman.ioc.ioctest;

import com.zhuhaoman.ioc.domain.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import java.beans.Beans;

/**
 * @ClassName AnnotationApplicationContextTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/7 18:15
 **/
public class AnnotationApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car",Car.class);
        Assert.notNull(car,"car is null");
    }
}
