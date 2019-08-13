package com.zhuhaoman.aop.aspect;

import com.zhuhaoman.aop.monitor.forth.Waiter;

/**
 * @ClassName NaughtyWaiter
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 11:28
 **/
public class NaughtyWaiter implements Waiter {
    @NeedTest
    @Override
    public void greetTo(String name) {
        System.out.println("NaughtyWaiter:greet to " +name);
    }

    @Override
    public void serveTo(String name) {

    }
}
