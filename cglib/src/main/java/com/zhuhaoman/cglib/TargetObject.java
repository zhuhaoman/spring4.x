package com.zhuhaoman.cglib;

/**
 * @ClassName TargetObject
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/30 11:52
 **/
public class TargetObject {
    public String method1(String paramName) {
        return paramName;
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []" + getClass();
    }
}
