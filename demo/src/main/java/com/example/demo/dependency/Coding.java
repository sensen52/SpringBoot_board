package com.example.demo.dependency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component //스프링 관리대상으로 지정
@RequiredArgsConstructor // final 혹은 @NonNull이 붙은 필드만 초기화한다.
//@NoArgsConstructor :  기본 생성자
//@AllArgsConstructor : 전체 필드 초기화

public class Coding {

    // 1.필드주입----------------------------------------------
    // 필드주입은 순환참조(무한루프)시 오류가 발생하지 않아서 StackOverFlow가 발생할 수 있다.
    // 필드주입은 객체가 생성된 이후에 초기화가 되기때문에 final키워드를 사용할 수 없다.(다른곳에서 변형가능)

    //@Autowired
    //private Computer computer;


    // 2.생성자주입---------------------------------------------
    // 외부에서 받아오는거라서 Autowired없어도 관리한다.(생략가능)
    // final키워드 사용가능, 의존성 주입이 되지 않으면 객체가 생성되지 않음으로 NPE방어
    // 순환참조 시 컴파일러 인지가능, 오류발생
    // 필드주입이 int data; data=10;이라면, 생성자주입은 int data =10;느낌
    // 필드를 메모리에 올리면서 동시에 주입된다.(그래서 만들어지지도 않으니까 순환참조시 StackOverFlow 생기기 전 Exception 발생)

    private final Computer computer;

    //RequiredArgsConstructor 어노테이션을 통해 직접 초기화코드 생략함.
//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}
