package com.zhuhaoman.aop.spring


import org.springframework.beans.factory.annotation.Qualifier
import spock.lang.Specification

import javax.annotation.Resource

class Test extends Specification {

    @Resource
    @Qualifier('serviceMock')
    GreeterService serviceMock

    @Resource
    @Qualifier('serviceStub')
    GreeterService serviceStub

    @Resource
    @Qualifier('serviceSpy')
    GreeterService serviceSpy

    @Resource
    @Qualifier('alternativeMock')
    GreeterService alternativeMock

    def "mock service"() {
        when:
        def result = serviceMock.greeting

        then:
        result == 'mock me'
        1 * serviceMock.getGreeting() >> 'mock me'
    }

}
