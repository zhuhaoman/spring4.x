package com.zhuhaoman.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @ClassName EnableSellerAspect
 * @Author zhuhaoman
 * @Date 2019/8/5 10:58
 **/
@Aspect
public class EnableSellerAspect {
    //为NaiveWaiter添加接口实现
    //defaultImpl:默认的接口实现
    @DeclareParents(value = "com.zhuhaoman.aop.monitor.forth.NaiveWaiter",defaultImpl = SmartSeller.class)
    public Seller seller;
}
