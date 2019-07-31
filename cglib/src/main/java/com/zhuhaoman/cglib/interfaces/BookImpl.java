package com.zhuhaoman.cglib.interfaces;

/**
 * @ClassName BookImpl
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/31 19:01
 **/
public class BookImpl implements BookInterface {
    @Override
    public void addBook() {
        System.out.println("add book");
    }

    @Override
    public void intercept() {
        System.out.println("intercept");
    }
}
