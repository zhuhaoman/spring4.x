package com.zhuhaoman.aop.service

class Publisher {
    List<Subscriber> subscribers = []
    int messageCount = 0

    void send(String message) {
        subscribers*.receive(message)
        messageCount++
    }
}
