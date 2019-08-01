package com.zhuhaoman.aop.monitor.forth;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName TransactionManager
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 17:27
 **/
public class TransactionManager implements ThrowsAdvice {
    //spring使用反射机制自行判断
    //必须采用签名 afterThrowing(Method method,Object[] args,Object target,Throwable)
    //前三个要么不提供，要么都提供
    public void afterThrowing(Method method,Object[] args,Object target,Exception e) {
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常:" + e.getMessage());
    }
}
