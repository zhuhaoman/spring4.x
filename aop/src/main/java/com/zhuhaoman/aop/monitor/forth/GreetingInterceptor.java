package com.zhuhaoman.aop.monitor.forth;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @ClassName GreetingInterceptor
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 16:45
 **/
public class GreetingInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String clientName = (String) args[0];
        //目标方法执行前调用
        System.out.println("hey " + clientName);
        //通过反射调用目标方法
        Object obj = invocation.proceed();
        //方法执行后调用
        System.out.println("hahahahaha!");
        return obj;
    }
}
