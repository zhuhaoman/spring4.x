package com.zhuhaoman.aop.groovy

class Script {
    static void main(String[] args) {
        getClassLoader()
    }
    def getClassLoader() {
        def cl = this.class.classLoader
        while (cl) {
            println(cl)
            cl = cl.parent
        }
    }

}
