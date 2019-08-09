package com.zhuhaoman.ioc.beanlife;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @ClassName Car
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/8 16:40
 **/

/**
 * BeanNameAware:让Bean获取自己在BeanFactory配置中的名字
 * BeanFactoryAware:让Bean获取配置他们的BeanFactory的引用
 * InitializingBean:初始化bean的时候实现该接口中afterPropertiesSet
 *
 * 除了通过实现Aware结尾接口获取spring内置对象，也可以通过@Autowired注解直接注入相关对象
 *
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String brand;
    @Setter
    @Getter
    private String color;
    @Setter
    @Getter
    private int maxSpeed;

    private BeanFactory beanFactory;
    @Getter
    private String beanName;

    public Car() {
        System.out.println("调用Car()构造函数");
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public void introduce() {
        System.out.println("brand:" + brand + " color:" + color + " maxSpeed:" + maxSpeed);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
        System.out.println(this.beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("调用BeanNameAware.setBeanName()");
        this.beanName = name;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()");
    }

    public void myInit() {
        System.out.println("调用init-method所指定的myInit()");
        this.maxSpeed = 240;
    }

    public void myDestory() {
        System.out.println("调用destory-method所指定的myDestory()");
    }
}
