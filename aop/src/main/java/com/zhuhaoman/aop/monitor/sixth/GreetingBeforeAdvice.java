package com.zhuhaoman.aop.monitor.sixth;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingBeforeAdvice
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 10:54
 **/
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + "." + method.getName());
        String clientName = (String) args[0];
        System.out.println("hey " + clientName + " !");
    }
}
