package com.zhuhaoman.ioc.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @ClassName MyBeanFactoryPostProcessor
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/12 9:55
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("car");

        bd.getPropertyValues().addPropertyValue("brand","大众");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory()!");
    }
}
