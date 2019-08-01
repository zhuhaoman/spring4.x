package com.zhuhaoman.aop.monitor.third;

import com.zhuhaoman.aop.monitor.second.ForumServiceImpl;

/**
 * @ClassName TestForumService
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 15:02
 **/
public class TestForumService {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        //通过动态生成子类的方式创建代理类
        ForumServiceImpl forumService = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
