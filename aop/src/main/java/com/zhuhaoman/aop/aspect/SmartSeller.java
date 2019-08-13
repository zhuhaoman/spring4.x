package com.zhuhaoman.aop.aspect;

/**
 * @ClassName SmartSeller
 * @Author zhuhaoman
 * @Date 2019/8/5 10:58
 **/
public class SmartSeller implements Seller {
    @Override
    public void sell(String goods) {
        System.out.println("sell goods:" + goods);
    }
}
