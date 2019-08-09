package com.zhuhaoman.springmvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @ClassName SmartApplicationInitializer
 * @Description TODO
 * @Author zhuhaoman
 * @Date 2019/8/6 17:19
 **/
public class SmartApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher",new DispatcherServlet());

        registration.setLoadOnStartup(1);
        //配置url匹配规则
        registration.addMapping("*.html*");
    }
}
