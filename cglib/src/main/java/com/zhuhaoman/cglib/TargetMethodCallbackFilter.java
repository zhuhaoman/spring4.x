package com.zhuhaoman.cglib;

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * @ClassName TargetMethodCallbackFilter
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/30 12:05
 **/
public class TargetMethodCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if(method.getName().equals("method1")){
            System.out.println("filter method1 ==0");
            //return 值为Callback[]中的索引
            return 0;
        }
        if(method.getName().equals("method2")){
            System.out.println("filter method2 ==1");
            return 1;
        }
        if(method.getName().equals("method3")){
            System.out.println("filter method3 ==2");
            return 2;
        }

        return 0;
    }
}
