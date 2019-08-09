package com.zhuhaoman.ioc.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Car
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/7 17:26
 **/
@Setter
@Getter
@Configuration(value = "car")
public class Car {

    private String color;

    private String brand;

    private int maxSpeed;

    public void introduce() {
        System.out.println("color="+color + " brand=" + brand + " maxSpeed=" + maxSpeed);
    }
}
