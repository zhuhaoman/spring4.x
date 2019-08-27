package com.zhuhaoman.aop


import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite.class)
@Suite.SuiteClasses(value = [ StopWatchTest.class, TimeZoneTest.class])
class SuitTest {
    def "test"() {
        println "hello"
    }
}
