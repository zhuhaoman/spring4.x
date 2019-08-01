package com.zhuhaoman.aop.monitor.frist;


import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName MethodPerformance
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/1 11:37
 **/
@Setter
@Getter
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance() {
        end = System.currentTimeMillis();
        long elaspe = end - begin;
        System.out.println(serviceMethod + " cost " + elaspe + " mills");
    }
}
