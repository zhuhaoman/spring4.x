package com.zhuhaoman.aop.monitor.eighth;

/**
 * @ClassName BeanSelfProxyAware
 * @Description 实现自身代理注入
 * @Author zhuhaoman
 * @Date 2019/8/2 16:58
 **/
public interface BeanSelfProxyAware {
    void setSelfProxy(Object object);
}
