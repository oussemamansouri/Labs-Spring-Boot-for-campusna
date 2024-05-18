package com.example.computer.models;

import org.springframework.stereotype.Component;

@Component
public class Doubler implements Computer {
    
    @Override
    public long compute(long value){
        return value * 2 ;
    }
    
}
