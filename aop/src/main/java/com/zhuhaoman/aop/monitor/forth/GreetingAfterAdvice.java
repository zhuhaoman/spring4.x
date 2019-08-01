package com.zhuhaoman.aop.monitor.forth;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingAfterAdvice
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 16:42
 **/
public class GreetingAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("please enjoy yourself!");
    }
}
