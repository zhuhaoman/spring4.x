package com.zhuhaoman.aop.spring

class GreeterServiceImpl implements GreeterService{
    @Override
    String getGreeting() {
        return 'hello world'
    }
}
