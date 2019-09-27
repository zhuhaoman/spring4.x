package com.zhuhaoman.cache.spring_cache;

import com.zhuhaoman.cache.ordinary.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName UserMain
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/9/26 11:02
 **/
@Slf4j
public class UserMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService userService = (UserService) context.getBean("userService");
        User user1 = userService.getUser(1);
        System.out.println(user1.toString());
        User user2 = userService.getUser(2);
        System.out.println(user2.toString());
    }
}
