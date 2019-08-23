package com.zhuhaoman.aop.spring;

import com.sun.deploy.config.Config;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.CoreMatchers.containsString;

/**
 * @ClassName OutputCaptureTest
 * @Description
 * @Author zhuhaoman
 * @Date 2019/8/23 11:11
 **/
@ContextConfiguration(classes = Config.class,initializers = ConfigFileApplicationContextInitializer.class)
public class OutputCaptureTest {
    //OutputCapture用于捕获System.out和System.err输出
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testName() {
        System.out.println("hello world");
        Assert.assertThat(outputCapture.toString(),containsString("world"));
    }

    @Test
    public void testProperties() {

    }

    @Test
    public void testEnvironment() {
    }
}
