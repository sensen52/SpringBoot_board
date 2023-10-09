package com.example.demo.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j // lombok라이브러리인 Slf4j 통해 log를 사용할 수 있게 지정
public class ComputerTests {
    // 단위테스트에서는 필드주입만 가능하다.
    @Autowired
    Coding coding; //메소드 안에서(전역변수에서는 Autowired를 사용할 수 없다), 전역변수로 지정
    @Test //단위테스트다는 것을 알려줌(이 메소드를 Junit환경에서 돌린다)
    public void computerTest(){
    log.info(coding.getComputer().toString());

 }
}
