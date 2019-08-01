package com.zhuhaoman.aop.monitor.forth;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @ClassName TestBeforeAdvice
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 15:48
 **/
public class TestBeforeAdvice {
    public static void main(String[] args) {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        //spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        //指定对接口进行代理
        pf.setInterfaces(target.getClass().getInterfaces());
        //启动优化
        pf.setOptimize(true);

        //设置代理目标
        pf.setTarget(target);
        //为代理目标添加增强
        pf.addAdvice(advice);
        //生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("zzz");
        proxy.serveTo("www");
    }
}
