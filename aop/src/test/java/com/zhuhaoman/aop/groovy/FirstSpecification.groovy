package com.zhuhaoman.aop.groovy

import spock.lang.Specification


class FirstSpecification extends Specification{
    //runs once before the first feature method
//    def setupSpec() {}
    //runs before every feature method
//    def setup() {}
    //runs after every feature method
//    def cleanup() {}
    //runs once after the last feature method
//    def cleanupSpec() {}

    def setup() {
        def stack = new Stack()
        assert stack.isEmpty()
    }

    void test1() {
        given:
        def stack = new Stack()
        def elem = "push me"
        when:
            stack.push(elem)
        then:
            !stack.empty
            stack.size() == 1
            stack.peek() == elem
    }
}
