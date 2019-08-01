package com.zhuhaoman.aop.monitor.frist;

/**
 * @ClassName ForumServiceImpl
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 14:09
 **/
public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {
        PerformanceMonitor.begin("com.zhuhaoman.aop.monitor.frist.ForumServiceImpl.removeTopic");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int rorumId) {
        PerformanceMonitor.begin("com.zhuhaoman.aop.monitor.frist.ForumServiceImpl.removeForum");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        PerformanceMonitor.end();
    }
}
