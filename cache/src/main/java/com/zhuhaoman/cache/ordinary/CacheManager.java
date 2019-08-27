package com.zhuhaoman.cache.ordinary;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName CacheManager
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/26 13:01
 **/
public class CacheManager<T> {

    private Map<String,T> cache = new ConcurrentHashMap<>();

    public T getValue(String key) {
        return cache.get(key);
    }

    public void addOrUpdateCache(String key, T value) {
        cache.put(key,value);
    }

    public void evictCache(String key) {
        cache.remove(key);
    }

    public void evictCache() {
        cache.clear();
    }
}
