package com.zhuhaoman.aop.monitor.second;

import com.zhuhaoman.aop.monitor.frist.ForumService;

import java.lang.reflect.Proxy;

/**
 * @ClassName TestForumService
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 14:33
 **/
public class TestForumService {
    public static void main(String[] args) {
        //希望被代理的目标业务类
        ForumService target = new ForumServiceImpl();
        //将目标业务类和横切代码编织到一起
        PerformanceHandler handler = new PerformanceHandler(target);
        //创建代理实例
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);

        //调用代理实例
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
