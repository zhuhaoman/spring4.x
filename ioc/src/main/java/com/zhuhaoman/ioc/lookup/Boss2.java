package com.zhuhaoman.ioc.lookup;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @ClassName Boss2
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/14 18:01
 **/
public class Boss2 implements MethodReplacer {
    //MethodReplacer：使用某个Bean的方法替换另外一个Bean的方法
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        Car car = new Car();
        car.setBrand("QQ");
        return car;
    }
}
