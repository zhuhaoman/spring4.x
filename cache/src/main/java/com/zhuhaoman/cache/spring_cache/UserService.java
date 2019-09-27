package com.zhuhaoman.cache.spring_cache;

import com.zhuhaoman.cache.ordinary.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/9/24 14:58
 **/
@Service(value = "userService")
public class UserService {
    private Map<Integer, User> users = new HashMap<>();

    {
        users.put(1,new User("1","a1"));
        users.put(2,new User("2","a2"));
    }

    private CacheManager cacheManager;

    @Autowired
    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @PostConstruct
    public void setUp() {
        Cache usersCaches = cacheManager.getCache("users");
        for (Integer key : users.keySet()) {
            usersCaches.put(key,users.get(key));
        }
    }

    @Cacheable(value = "users")
    public User getUser(int id) {
        System.out.println("User with id " + id + " requested.");
        return users.get(id);
    }

    @UserSaveCache
    public void save(User user) {

    }
}
