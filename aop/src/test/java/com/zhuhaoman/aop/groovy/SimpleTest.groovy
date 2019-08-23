package com.zhuhaoman.aop.groovy

import com.zhuhaoman.aop.service.BaseService
import com.zhuhaoman.aop.service.Family
import com.zhuhaoman.aop.service.Person
import com.zhuhaoman.aop.service.TranslationService
import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor

class SimpleTest extends GroovyTestCase{

    void test1() {
        def str1 = "aaa"
        def str2 = "aaa"
        assertEquals(str1,str2)
    }

    void test2() {
        def x = 1
        assert x == 2
    }

    void test3() {
        def service = [convert: {String key -> 'some text'}] as TranslationService

        assert "some text" == service.convert('key.text')
    }

    void test4() {
        def service = {String key -> "some text"} as TranslationService

        assert "some text" == service.convert("key.text")
    }

    void test5() {
        def add = {a,b -> 3} as TranslationService

        assert 3 == add.add(1,2)
    }

    void test6() {
        BaseService service = { -> println("do something")}
        service.doSomething()
    }

    void test7() {
        def mock = new MockFor(Person)
        mock.demand.getFirst{"dummy"}
        mock.demand.getLast{"name"}

        mock.use {
            def mary = new Person(first: 'Mary',last: 'Smith')
            def f = new Family(mother: mary)
            assert f.nameOfMother() == 'dummy name'
        }

        mock.expect.verify()
    }

    void test8() {
        def stub = new StubFor(Person)
        stub.demand.with {
            getFirst{'dummy'}
            getLast{'name'}
        }

        stub.use {
            def john = new Person(first: 'john',last: 'Smith')
            def f = new Family(father: john)
            assert f.father.first == 'dummy'
            assert f.father.last == 'name'
        }
        stub.expect.verify()
    }

    void test9() {
        def numbers = [1,2,3,4]
        shouldFail {
            numbers.get(4)
        }
    }

    void test10() {
        def numbers = [1,2,3,4]
        shouldFail IndexOutOfBoundsException, {
            numbers.get(4)
        }
    }

    void test11() {
        def numbers = [1,2,3,4]
        def msg = shouldFail IndexOutOfBoundsException,{
            numbers.get(4)
        }

        assert msg.contains('Index: 4, Size: 4') ||
                msg.contains('Index 4 out-of-bounds for length 4') ||
                msg.contains('Index 4 out of bounds for length 4')
    }

}
