package com.zhuhaoman.cache;

import com.zhuhaoman.cache.ordinary.UserService;

/**
 * @ClassName UserMain
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/26 13:46
 **/
public class UserMain {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.getUserById("011111");
        userService.getUserById("011111");


        userService.reload();

        System.out.println("after reload...");

        userService.getUserById("011111");
        userService.getUserById("011111");
    }
}
