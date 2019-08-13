package com.zhuhaoman.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @ClassName TestAnnotation
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 11:19
 **/
@Aspect
public class TestAnnotation {

    //@annotation表示标注了某个注解的所有方法
    @AfterReturning("@annotation(com.zhuhaoman.aop.aspect.NeedTest)")
    public void needTestFuc() {
        System.out.println("need test function excuted!");
    }
}
