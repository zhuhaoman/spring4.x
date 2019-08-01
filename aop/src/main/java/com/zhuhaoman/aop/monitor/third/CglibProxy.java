package com.zhuhaoman.aop.monitor.third;

import com.zhuhaoman.aop.monitor.frist.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxy
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 14:44
 **/
public class CglibProxy implements MethodInterceptor {
    Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        //设置需要创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //创建子类实例
        return enhancer.create();
    }

    /**
     *
     * @param obj 目标类实例
     * @param method 目标类方法的反射对象
     * @param args 方法的动态入参
     * @param proxy 代理类实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());
        //通过代理类调用父类中的方法
        Object result = proxy.invokeSuper(obj,args);
        PerformanceMonitor.end();
        return result;
    }
}
