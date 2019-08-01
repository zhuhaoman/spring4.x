package com.zhuhaoman.aop.monitor.fifth;

import com.zhuhaoman.aop.monitor.frist.PerformanceMonitor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

/**
 * @ClassName ControllablePerformanceMonitor
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 18:14
 **/
public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {

    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<>();

    @Override
    public void setMonitorActive(boolean active) {
        monitorStatusMap.set(active);
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object object;

        if (monitorStatusMap.get() != null && monitorStatusMap.get()) {
            PerformanceMonitor.begin(mi.getClass().getName() + "." + mi.getMethod().getName() + " aaaa");
            object = super.invoke(mi);
            PerformanceMonitor.end();
        } else {
            object = super.invoke(mi);
        }
        return object;
    }
}
