package com.zhuhaoman.aop.monitor.eighth;

/**
 * @ClassName Waiter
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 16:39
 **/
public class Waiter implements BeanSelfProxyAware{
    private Waiter waiter;

    public void serverTo(String name) {
        System.out.println("waiting serving " + name + " ...");
        greetTo(name);
    }

    public void greetTo(String name) {
        System.out.println("greeting " + name + " ...");
    }

    @Override
    public void setSelfProxy(Object object) {
        this.waiter = (Waiter) object;
    }
}
