package com.zhuhaoman.cglib;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @ClassName LazyBean
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/31 17:28
 **/
@Setter
@Getter
public class LazyBean {
    private String name;

    private int age;

    private PropertyBean propertyBean;

    private PropertyBean propertyBeanDispatcher;

    public LazyBean(String name, int age) {
        this.name = name;
        this.age = age;
        this.propertyBean = createPropertyBean();
        this.propertyBeanDispatcher = createPropertyBeanDispatcher();
    }

    /**
     * 只第一次懒加载
     * @return
     */
    private PropertyBean createPropertyBean() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PropertyBean.class);
        PropertyBean pb = (PropertyBean) enhancer.create(PropertyBean.class,new ConcreteClassLazyLoader());
        return pb;
    }

    /**
     * 每次都懒加载
     * @return
     */
    private PropertyBean createPropertyBeanDispatcher() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PropertyBean.class);
        PropertyBean pb = (PropertyBean) enhancer.create(PropertyBean.class,new ConcreteClassDispatcher());
        return pb;
    }

}
