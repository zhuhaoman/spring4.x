package com.zhuhaoman.cache.spring_cache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Caching(put = {
        @CachePut(cacheNames = "user",key = "#user.id"),
        @CachePut(cacheNames = "user",key = "#user.username"),
        @CachePut(cacheNames = "user",key = "#user.email")
})
public @interface UserSaveCache {
}
