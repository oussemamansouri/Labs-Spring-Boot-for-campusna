package com.example.computer.models;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cuber implements Computer{
    @Override
    public long compute(long value){
        return value * value * value ;
    }
    
}
