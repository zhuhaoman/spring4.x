package com.zhuhaoman.aop.monitor.seventh;

import com.zhuhaoman.aop.monitor.forth.Waiter;
import lombok.Setter;

/**
 * @ClassName WaiterDelegate
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 11:38
 **/
public class WaiterDelegate {
    @Setter
    private Waiter waiter;

    public void service(String clientName) {
        waiter.serveTo(clientName);
        waiter.greetTo(clientName);
    }
}
