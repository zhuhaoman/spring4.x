package com.zhuhaoman.spel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/5 17:45
 **/
@Setter
@Getter
public class User {
    private String userName;
    private Integer credits;

    public String getUserName() {
        return userName;
    }

    private List<Address> addresses;

}
