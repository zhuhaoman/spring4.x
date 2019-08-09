package com.zhuhaoman.ioc.ioctest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName FileResourceTest
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/7 16:00
 **/
public class FileResourceTest {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("test.txt");

        EncodedResource encodedResource = new EncodedResource(resource,"GB2312");
        try {
            String context = FileCopyUtils.copyToString(encodedResource.getReader());
            System.out.println(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InputStream inputStream = resource.getInputStream();

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int i;
            while ((i=inputStream.read())!= -1 ) {
                out.write(i);
            }
            System.out.println(out.toString());

            System.out.println(resource.getFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
