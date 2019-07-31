package com.zhuhaoman.cglib;

import org.springframework.cglib.proxy.Dispatcher;

/**
 * @ClassName ConcreteClassDispatcher
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/31 18:29
 **/
public class ConcreteClassDispatcher implements Dispatcher {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("before Dispatcher...");
        PropertyBean propertyBean = new PropertyBean();
        propertyBean.setKey("xxx");
        propertyBean.setValue(new TargetObject());
        System.out.println("after Dispatcher...");
        return propertyBean;
    }
}
