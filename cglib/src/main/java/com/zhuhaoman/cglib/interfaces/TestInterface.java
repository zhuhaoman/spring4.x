package com.zhuhaoman.cglib.interfaces;

/**
 * @ClassName TestInterface
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/7/31 19:01
 **/
public class TestInterface {
    public static void main(String[] args) {
        BookProxy bookProxy = new BookProxy();
        BookInterface impl = (BookInterface) bookProxy.getInstance(new BookImpl());
        impl.intercept();
        impl.addBook();
    }
}
