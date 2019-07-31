package com.zhuhaoman.cglib.interfaces;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName BookProxy
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/31 19:02
 **/
public class BookProxy implements InvocationHandler {
    //委托类
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before Advice");
        if ("intercept".equals(method.getName())) {
            System.out.println("intercept method is intercepted");

            return null;
        }
        Object result = method.invoke(target, args);
        System.out.println("After Advice");
        return result;
    }
}
