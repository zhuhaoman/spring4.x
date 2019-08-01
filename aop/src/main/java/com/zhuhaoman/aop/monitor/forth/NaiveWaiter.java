package com.zhuhaoman.aop.monitor.forth;

/**
 * @ClassName NaiveWaiter
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 15:42
 **/
public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to " + name + "...");
    }
}
