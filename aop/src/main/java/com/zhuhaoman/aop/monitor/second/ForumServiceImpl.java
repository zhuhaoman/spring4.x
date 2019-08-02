package com.zhuhaoman.aop.monitor.second;

import com.zhuhaoman.aop.monitor.frist.ForumService;

/**
 * @ClassName ForumServiceImpl
 * @Author zhuhaoman
 * @Date 2019/8/1 14:09
 **/
public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeForum(int rorumId) {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
