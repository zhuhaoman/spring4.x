package com.zhuhaoman.aop.aspect;

import java.lang.annotation.*;

/**
 * @ClassName NeedTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 9:21
 **/
@Retention(RetentionPolicy.RUNTIME) //声明注解的保留期限
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})  //声明可以使用该注解的目标类型
@Repeatable(value = Test.class)
public @interface NeedTest { //@interface 定义注解类
    //若注解只有一个成员，必须取名为value()
    boolean value() default true;
}
