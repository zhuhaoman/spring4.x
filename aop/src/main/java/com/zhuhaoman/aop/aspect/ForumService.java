package com.zhuhaoman.aop.aspect;

/**
 * @ClassName ForumService
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 9:49
 **/
public class ForumService {
    @NeedTest
    public void deleteForum(int forumId) {
        System.out.println("删除forum：" + forumId);
    }

    @NeedTest(value = false)
    public void deleteTopic(int topicId) {
        System.out.println("删除topic: " + topicId);
    }
}
