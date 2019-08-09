package com.zhuhaoman.ioc.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * @ClassName MyInstantiationAwareBeanPostProcessor
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/8 18:06
 **/
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    //实例化bean前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation()");
        }
        return null;
    }
    //实例化bean后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation()");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessProperties()");
        }
        return super.postProcessProperties(pvs, bean, beanName);
    }
}
