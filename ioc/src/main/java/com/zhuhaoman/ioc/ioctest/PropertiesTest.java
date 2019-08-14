package com.zhuhaoman.ioc.ioctest;

import java.io.*;
import java.util.Properties;

/**
 * @ClassName PropertiesTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/14 17:03
 **/
public class PropertiesTest {

    public static void main(String[] args) {
        try {
            String basePath = "D:\\myspace\\spring4.x\\ioc\\src\\main\\resources\\application.properties";
            InputStream in = new BufferedInputStream(new FileInputStream(new File(basePath)));

            Properties properties = new Properties();

            properties.load(in);

            String value = properties.getProperty("spring.application.name");
            System.out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
