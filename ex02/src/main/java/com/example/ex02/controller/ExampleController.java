package com.example.ex02.controller;
import com.example.ex02.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public void ex01(){
        log.info("==================ex01==================");
    }

    @GetMapping("ex02")
    public void ex02(HttpServletRequest request){
        log.info(request.getParameter("name"));
    }

    @GetMapping("ex03")
    public void ex03(String name){
        log.info(name);
    }

    @GetMapping("ex04")
    //파라미터명과 필드명이 일치해야한다.
    public void ex04(MemberVO memberVO){
        log.info("member: " + memberVO.toString());
    }

    @GetMapping("ex05")
    //키 값이 다를경우
    public void ex05(@RequestParam("id") String name, int age) {
        log.info("name:" + name);
        log.info("age:" + age);
    }

    @GetMapping("ex06")
    //객체와 일반변수(파라미터)를 전달받을 경우
    public void ex06(MemberVO memberVO, String id) {
        log.info("member name: " + memberVO.getName());
        log.info("age: " + memberVO.getAge());
        log.info("name: " + id);
    }

    @GetMapping("ex07")
    public void ex07(){;}

    @GetMapping("ex08")
    public String ex08(){
        return "ex/ex08/ex08";
    }

    @GetMapping("ex09")
    public String ex09(String name, Model model/*, HttpServletRequest request*/){
//        request.setAttribute("name", name);
        model.addAttribute("name", name);
        return "ex/ex09";
    }

    @GetMapping("ex10")
    public String ex10(MemberVO memberVO){
        return "ex10";
    }
    //model전달자를 사용하지 않고 객체를 사용하면 객체의 앞글자를 소문자로 바꾼게 키 값이 된다
    //그래서 타임리프에서 ${memberVO.age} 이런식으로 키와 값으로 값을 추출할 수 있는것이다.


    @GetMapping("ex11")
    public void ex11(MemberVO memberVO, @ModelAttribute("gender") String gender){

    }

    //하나 보낼때는 model전달자가 아니라 @ModelAttribute 어노테이션으로 사용한다.

    @GetMapping("ex12")
    public void ex12(@RequestParam("data") List<String> datas) {
        log.info("=================================");
        datas.forEach(log::info);
    }
    //라디오 같은 값을 가져올때 사용한다
}








