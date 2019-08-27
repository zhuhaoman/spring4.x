package com.zhuhaoman.aop.spring


import org.springframework.context.annotation.Bean
import spock.mock.DetachedMockFactory

class DetachedJavaConfig {
    def mockFactory = new DetachedMockFactory()

    @Bean
    GreeterService serviceMock() {
        return mockFactory.Mock(GreeterService)
    }

    @Bean
    GreeterService serviceStub() {
        return mockFactory.Stub(GreeterService)
    }

    @Bean
    GreeterService serviceSpy() {
        return mockFactory.Spy(GreeterServiceImpl)
    }

//    @Bean
//    FactoryBean<GreeterService> alternativeMock() {
//        return new SpockMockFactoryBean(GreeterService)
//    }
}
