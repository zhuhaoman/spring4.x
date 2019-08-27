package com.zhuhaoman.cache.ordinary;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/26 13:07
 **/
public class UserService {
    private CacheManager<User> cacheManager;

    public UserService() {
        this.cacheManager = new CacheManager<>();
    }

    public User getUserById(String userId) {
        User result = cacheManager.getValue(userId);

        if (result != null) {
            System.out.println("get value from cache " + userId);
            return result;
        }

        result = getFromDB(userId);

        if (result != null) {
            cacheManager.addOrUpdateCache(userId,result);
        }
        return result;

    }

    public void reload() {
        cacheManager.evictCache();
    }


    private User getFromDB(String userId) {
        System.out.println("real querying from db " + userId);
        return new User(userId);
    }
}
