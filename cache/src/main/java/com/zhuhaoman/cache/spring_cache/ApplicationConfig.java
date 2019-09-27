package com.zhuhaoman.cache.spring_cache;

import org.ehcache.core.EhcacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

/**
 * @ClassName ApplicationConfig
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/9/26 10:58
 **/
@Configuration
@ComponentScan(basePackages = {"com.zhuhaoman.cache"})
@EnableCaching
public class ApplicationConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Collections.singletonList(new ConcurrentMapCache("users")));
        return cacheManager;
    }

    @Bean
    public EhcacheManager ehcacheManager() {
        return null;
    }

    @Bean
    public GuavaCacheManager guavaCacheManager() {
        return null;
    }
}
