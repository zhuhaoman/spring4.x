package com.zhuhaoman.aop.service

class Family {
    Person father,mother
    def nameOfMother() {"$mother.first $mother.last"}
}
