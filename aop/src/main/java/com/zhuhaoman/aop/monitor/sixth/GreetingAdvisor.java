package com.zhuhaoman.aop.monitor.sixth;

import com.zhuhaoman.aop.monitor.forth.Waiter;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * @ClassName GreetingAdvisor
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/2 10:45
 **/
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    //切点方法匹配规则
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return "greetTo".equals(method.getName());
    }
    //切点类匹配规则
    @Override
    public ClassFilter getClassFilter() {
        return Waiter.class::isAssignableFrom;
    }
}
