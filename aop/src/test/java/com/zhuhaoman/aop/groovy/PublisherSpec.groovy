package com.zhuhaoman.aop.groovy

import com.zhuhaoman.aop.service.Publisher
import com.zhuhaoman.aop.service.Subscriber
import spock.lang.Specification

class PublisherSpec extends Specification{
    Publisher publisher = new Publisher()

    Subscriber subscriber = Mock()
    Subscriber subscriber2 = Mock()

    def setup() {
        publisher.subscribers << subscriber //<< is a Groovy shorthand for List.add()
        publisher.subscribers << subscriber2
    }


    def "should send messages to all subscribers"() {
        when:
            publisher.send("hello")
        then:
            1 * subscriber.receive("hello")
            (1.._) * subscriber2.receive("hello")
    }
}
