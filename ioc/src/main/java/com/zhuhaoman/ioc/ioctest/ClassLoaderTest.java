package com.zhuhaoman.ioc.ioctest;

/**
 * @ClassName ClassLoaderTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/7 11:15
 **/
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
