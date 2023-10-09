package com.example.demo.dependency.Quailyfier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component @Qualifier("desktop") @Primary
public class Desktop implements Computer{
    @Override
    public int getScreenWidth() {
        return 2180;
    }
}
