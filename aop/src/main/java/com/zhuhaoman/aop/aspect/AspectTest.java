package com.zhuhaoman.aop.aspect;

import java.lang.reflect.Method;

/**
 * @ClassName AspectTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 9:57
 **/
public class AspectTest {
    public static void main(String[] args) {
        Class clazz = ForumService.class;

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);

        for (Method method : methods) {
            NeedTest test = method.getAnnotation(NeedTest.class);
            if (test != null) {
                if (test.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
