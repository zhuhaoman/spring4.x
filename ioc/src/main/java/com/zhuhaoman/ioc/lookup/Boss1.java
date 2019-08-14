package com.zhuhaoman.ioc.lookup;

/**
 * @ClassName Boss1
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/14 18:00
 **/
public class Boss1 {
    public Car getCar() {
        Car car = new Car();
        car.setBrand("奥迪");
        car.setPrice(10000);
        return car;
    }
}
