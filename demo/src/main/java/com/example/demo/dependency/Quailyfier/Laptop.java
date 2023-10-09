package com.example.demo.dependency.Quailyfier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component @Qualifier("lapotop")
public class Laptop implements Computer{


    @Override
    public int getScreenWidth() {
        return 1980;
    }
}
