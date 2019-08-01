package com.zhuhaoman.aop.monitor.fifth;

import com.zhuhaoman.aop.monitor.frist.ForumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestIntroduction
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 18:33
 **/
public class TestIntroduction {
    public static void main(String[] args) {
        String configPath = "monitor.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        //默认情况下未开启性能监控
//        forumService.removeTopic(10);
//        forumService.removeForum(1024);
        //开启性能监视
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);
        forumService.removeForum(1111);
        forumService.removeTopic(1111111);
    }
}
