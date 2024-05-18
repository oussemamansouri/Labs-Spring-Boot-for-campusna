package com.example.computer.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.computer.models.Cuber;
import com.example.computer.models.Doubler;
import com.example.computer.models.Squarer;

@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        new ComputerProcessor()
        .addComputer(new Doubler())
        .addComputer(new Squarer())
        .addComputer(new Cuber())
        .computeAll(8);
       
    }
    
}
