package com.zhuhaoman.bytebuddy.buddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.NamingStrategy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static net.bytebuddy.matcher.ElementMatchers.*;
import static org.junit.Assert.assertEquals;

/**
 * @ClassName ByteBuddyTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/9/2 16:04
 **/
public class ByteBuddyTest {
    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        DynamicType.Unloaded unloaded = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.isToString())
                .intercept(FixedValue.value("hello world ByteBuddy!"))
                .make();

        Class<?> dynamicType = unloaded.load(getClass().getClassLoader()).getLoaded();
        assertEquals(dynamicType.newInstance().toString(),"hello world ByteBuddy!");
    }

    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        String s = new ByteBuddy()
                .subclass(Foo.class)
                .method(named("sayHelloFoo")
                        .and(isDeclaredBy(Foo.class))
                        .and(returns(String.class)))
                .intercept(MethodDelegation.to(Bar.class))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded()
                .newInstance()
                .sayHelloFoo();

        assertEquals(s,Bar.sayHelloBar());

    }

    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class<?> type = new ByteBuddy()
                .subclass(Object.class)
                .name("ProposalVO")
                .defineMethod("getProposalNo",String.class, Modifier.PUBLIC)
                .intercept(MethodDelegation.to(Bar.class))
                .defineField("proposalNo",String.class,Modifier.PRIVATE)
                .make()
                .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded();

        Method m = type.getDeclaredMethod("getProposalNo",null);
        System.out.println(m.invoke(type.newInstance(),null));
        System.out.println(type.getDeclaredField("proposalNo"));
    }

    @Test
    public void test4() {
        ByteBuddyAgent.install();

        new ByteBuddy()
                .redefine(Foo.class)
                .method(named("sayHelloFoo"))
                .intercept(FixedValue.value("Hello Foo Redefined"))
                .make()
                .load(Foo.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());

        Foo f = new Foo();
        System.out.println(f.sayHelloFoo());

    }

    @Test
    public void test5() {
        DynamicType.Builder dynamicBuilder = new ByteBuddy()
                .with(new NamingStrategy.SuffixingRandom("com.zhuhaoman.bytebuddy.dto.ProposalVO"))
                .subclass(Object.class)
                .defineProperty("name", String.class)
                .defineProperty("age", Integer.class);

        DynamicType.Unloaded<?> dynamicType = dynamicBuilder.make();
        saveAndLoad(dynamicType);
    }

    private Class<?> saveAndLoad(DynamicType.Unloaded<?> dynamicType) {
        //写入到本地目录
        try {
            dynamicType.saveIn(new File("byte-buddy/target/classes"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dynamicType.load(Thread.currentThread().getContextClassLoader(),
                ClassLoadingStrategy.Default.INJECTION).getLoaded();
    }
}
