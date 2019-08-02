package com.zhuhaoman.aop.monitor.eighth;

import org.springframework.core.Ordered;

/**
 * @ClassName SystemBootAddon
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 17:01
 **/
public interface SystemBootAddon extends Ordered {
    //系统就绪后调用的方法
    void onReady();
}
