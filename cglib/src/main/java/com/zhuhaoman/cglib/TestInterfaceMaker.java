package com.zhuhaoman.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InterfaceMaker;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName TestInterfaceMaker
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/31 18:40
 **/
public class TestInterfaceMaker {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        InterfaceMaker interfaceMaker = new InterfaceMaker();
        //抽取某个类的方法生成接口方法
        interfaceMaker.add(TargetObject.class);

        Class<?> targetInterface = interfaceMaker.create();
        for (Method method : targetInterface.getMethods()) {
            System.out.println(method.getName());
        }

        Object object = Enhancer.create(Object.class, new Class[]{targetInterface}, (MethodInterceptor) (o, method, objects, methodProxy) -> {
            if(method.getName().equals("method1")){
                System.out.println("filter method1 ");
                return "mmmmmmmmm";
            }
            if(method.getName().equals("method2")){
                System.out.println("filter method2 ");
                return 1111111;
            }
            if(method.getName().equals("method3")){
                System.out.println("filter method3 ");
                return 3333;
            }
            return "default";
        });

        Method targetMethod1=object.getClass().getMethod("method3",new Class[]{int.class});
        int i=(int)targetMethod1.invoke(object, new Object[]{33});
        Method targetMethod=object.getClass().getMethod("method1",new Class[]{String.class});
        System.out.println(targetMethod.invoke(object, new Object[]{"sdfs"}));
    }
}
