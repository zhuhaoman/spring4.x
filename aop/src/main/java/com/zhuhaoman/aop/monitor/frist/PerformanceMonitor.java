package com.zhuhaoman.aop.monitor.frist;

/**
 * @ClassName PerformanceMonitor
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 11:37
 **/
public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<>();

    public static void begin(String method) {
        System.out.println("begin monitor...");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end() {
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
        System.out.println("end monitor...");
    }


}
