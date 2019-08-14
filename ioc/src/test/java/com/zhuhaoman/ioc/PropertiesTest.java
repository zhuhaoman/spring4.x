package com.zhuhaoman.ioc;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @ClassName PropertiesTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/14 16:53
 **/
public class PropertiesTest {
    private static String basePath = "application.properties";

    @Test
    public void test() throws IOException {
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(basePath));

            Properties properties = new Properties();

            properties.load(in);

            String value = properties.getProperty("spring.application.name");
            System.out.println(value);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
