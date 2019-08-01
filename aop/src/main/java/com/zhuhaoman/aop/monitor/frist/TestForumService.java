package com.zhuhaoman.aop.monitor.frist;

/**
 * @ClassName TestForumService
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 14:07
 **/
public class TestForumService {
    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }
}
