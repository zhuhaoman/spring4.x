package com.zhuhaoman.aop.monitor.forth;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingBeforeAdvice
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 15:43
 **/
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    //目标类方法调用前执行

    /**
     *
     * @param method 目标类的方法
     * @param args 目标类方法的入参
     * @param obj 目标类实例
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object obj) throws Throwable {
        String clientName = (String) args[0];
        System.out.println("How are you! " + clientName + "!");
    }
}
