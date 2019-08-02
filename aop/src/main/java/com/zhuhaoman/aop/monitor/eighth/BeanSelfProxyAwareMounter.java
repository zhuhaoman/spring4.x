package com.zhuhaoman.aop.monitor.eighth;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName BeanSelfProxyAwareMounter
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 16:59
 **/
@Component
public class BeanSelfProxyAwareMounter implements ApplicationContextAware,SystemBootAddon {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onReady(){
        //从容器中获取所有注入的自动代理bean
        Map<String,BeanSelfProxyAware> proxyAwareMap = applicationContext.getBeansOfType(BeanSelfProxyAware.class);

        if (proxyAwareMap != null) {
            for (BeanSelfProxyAware bean : proxyAwareMap.values()) {
                bean.setSelfProxy(bean);
            }
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
