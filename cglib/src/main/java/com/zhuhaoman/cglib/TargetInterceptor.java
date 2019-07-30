package com.zhuhaoman.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName TargetInterceptor
 * @Description 目标对象拦截器，实现MethodInterceptor
 * @Author zhuhaoman
 * @Date 2019/7/30 11:55
 **/
public class TargetInterceptor implements MethodInterceptor {

/**
 * 重写方法拦截在方法前和方法后加入业务
 * Object为由CGLib动态生成的代理类实例
 * Method method为目标方法
 * Object[] params 为参数，
 * MethodProxy proxy CGlib方法代理对象
 */
 @Override
    public Object intercept(Object obj, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object result = methodProxy.invokeSuper(obj,params);
        System.out.println("调用后"+result);
        return result;
    }
}
