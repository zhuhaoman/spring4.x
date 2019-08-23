package com.zhuhaoman.aop;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @ClassName StopWatchTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/16 11:15
 **/
public class StopWatchTest {

    @Test
    public void testStopWatch() throws InterruptedException {
        StopWatch watch = new StopWatch();
        watch.start();

        Thread.sleep(1000);
        System.out.println(watch.getTotalTimeMillis());

        Thread.sleep(1000);
    }
}
