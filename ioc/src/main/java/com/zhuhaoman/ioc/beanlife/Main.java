package com.zhuhaoman.ioc.beanlife;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @ClassName Main
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/8 18:25
 **/
public class Main {
    public static void main(String[] args) {
        LifeCycleInBeanFactory();
    }

    private static void LifeCycleInBeanFactory() {
        //装配文件
        Resource res = new ClassPathResource("car.xml");
        //启动容器
        BeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
        reader.loadBeanDefinitions(res);
        //向容器注册MyBeanPostProcessor
        ((DefaultListableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanPostProcessor());
        //向容器注册MyInstantiationAwareBeanPostProcessor
        ((DefaultListableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1 = (Car) beanFactory.getBean("car");
        car1.introduce();
        car1.setColor("red");
        System.out.println(car1.getBeanName());

        Car car2 = (Car) beanFactory.getBean("car");

        System.out.println("car1==car2：" + (car1==car2));
        //关闭容器
        ((DefaultListableBeanFactory) beanFactory).destroySingletons();
    }
}
