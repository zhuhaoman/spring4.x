package com.zhuhaoman.ioc.ioctest;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @ClassName PatternResolverTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/7 16:26
 **/
public class PatternResolverTest {
    public static void main(String[] args) {
        ResourcePatternResolver resource = new PathMatchingResourcePatternResolver();

        try {
            Resource[] resources = resource.getResources("classpath*:com.zhuhaoman/**/*.xml");
            for (Resource r: resources) {
                System.out.println(r.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
