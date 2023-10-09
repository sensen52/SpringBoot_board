package com.example.demo.dependency;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component //스프링 관리대상으로 지정
public class Coding {
    //필드주입
    //필드주입은 순환참조(무한루프)시 오류가 발생하지 않아서 StackOverFlow가 발생할 수 있다.
    @Autowired
    private Computer computer;
}
