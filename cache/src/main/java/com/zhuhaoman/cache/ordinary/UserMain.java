package com.zhuhaoman.cache.ordinary;

/**
 * @ClassName UserMain
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/9/24 14:52
 **/
public class UserMain {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.getUserById("001001");
        userService.getUserById("001001");

        userService.reload();

        System.out.println("after reload...");

        userService.getUserById("001001");
        userService.getUserById("001001");
    }
}
