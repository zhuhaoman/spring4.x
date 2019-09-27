package com.zhuhaoman.cache.ordinary;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/26 12:57
 **/
@Setter
@Getter
public class User implements Serializable {
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    private static final long serialVersionID = -1L;

    private String userId;

    private String userName;

    private int age;

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
