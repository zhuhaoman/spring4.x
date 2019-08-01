package com.zhuhaoman.aop.monitor.second;

import com.zhuhaoman.aop.monitor.frist.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName PerformanceHandler
 * @Description 处理横切代码
 * @Author zhuhaoman
 * @Date 2019/8/1 14:24
 **/
public class PerformanceHandler implements InvocationHandler {
    private Object target;

    public PerformanceHandler(Object target) {
        //通过Target传入希望被代理的目标对象
        this.target = target;
    }

    /**
     *
     * @param proxy 最终生成的代理实例，一般不怎么用到
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target,args);
        PerformanceMonitor.end();
        return obj;
    }
}
