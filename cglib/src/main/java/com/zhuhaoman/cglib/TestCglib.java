package com.zhuhaoman.cglib;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

/**
 * @ClassName TestCglib
 * @Description
 * @Author zhuhaoman
 * @Date 2019/7/30 12:00
 **/
public class TestCglib {
    public static void main(String[] args) {
        //Enhancer：字节码增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());

        TargetObject targetObject = (TargetObject) enhancer.create();
        System.out.println(targetObject);
        System.out.println(targetObject.method1("mmm1"));
        System.out.println(targetObject.method2(100));
        System.out.println(targetObject.method3(200));

        CallbackFilter filter = new TargetMethodCallbackFilter();

        Callback noopCb = NoOp.INSTANCE;
        Callback callback1 = new TargetInterceptor();
        Callback fixedValue = new TargetResultFixed();
        Callback[] cbarray = new Callback[]{callback1,noopCb,fixedValue};
        enhancer.setCallbacks(cbarray);
        enhancer.setCallbackFilter(filter);

    }
}
