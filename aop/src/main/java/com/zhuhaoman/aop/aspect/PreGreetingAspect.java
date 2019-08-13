package com.zhuhaoman.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @ClassName PreGreetingAspect
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 10:24
 **/
@Aspect
public class PreGreetingAspect {
    @Before("execution(* greetTo(..))")
    public void beforeGreeting() {
        System.out.println("how are you!");
    }
}
