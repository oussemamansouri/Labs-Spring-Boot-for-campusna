package com.example.computer.models;

import org.springframework.stereotype.Component;

@Component
public class Squarer  implements Computer{
    @Override
    public long compute(long value){
        return value * value ;
    }
    
}
