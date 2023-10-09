package com.example.demo.dependency.Qualifier;

import com.example.demo.dependency.Quailyfier.Computer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ComputerTests {
    @Autowired @Qualifier("desktop")
    Computer desktop;

    @Autowired @Qualifier("laptop")
    Computer laptop;

    //primary 어노테이션을 사용했기 때문에 Autowired만 사용가능
    @Autowired
    Computer computer;

    @Test
    public void ComputerTest(){
        log.info(desktop.toString());
        log.info(laptop.toString());
        log.info(computer.toString());
    }
}
