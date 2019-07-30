package com.zhuhaoman.cglib;

import org.springframework.cglib.proxy.FixedValue;

/**
 * @ClassName TargetResultFixed
 * @Description   FixedValue:表示锁定方法返回值，无论被代理类的方法返回什么值，回调方法都返回固定值。
 * @Author zhuhaoman
 * @Date 2019/7/30 12:12
 **/
public class TargetResultFixed implements FixedValue {
    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object loadObject() throws Exception {
        System.out.println("锁定结果");
        Object obj = 999;

        return obj;
    }
}
