package com.zhuhaoman.ioc.ioctest;

import com.zhuhaoman.ioc.domain.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @ClassName BeanFactoryTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/7 17:29
 **/
public class BeanFactoryTest {
    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource resource = resolver.getResource("classpath:beans.xml");
            System.out.println(resource.getURL());

            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            //XmlBeanDefinitionReader通过Resource装载Spring配置信息并启动IoC容器
            XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
            reader.loadBeanDefinitions(resource);

            System.out.println("init Factory");
            Car car = factory.getBean("car", Car.class);
            System.out.println("car bean is ready for use!");
            car.introduce();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
