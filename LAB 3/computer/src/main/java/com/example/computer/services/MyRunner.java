package com.example.computer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.computer.models.Computer;
import com.example.computer.models.Cuber;
import com.example.computer.models.Doubler;
import com.example.computer.models.Squarer;

@Component
public class MyRunner implements CommandLineRunner {

  

    @Autowired
    @Qualifier("doubler")
    Computer c1 ;

    @Autowired
    @Qualifier("squarer")
    Computer c2 ;

    @Autowired
    @Qualifier("cuber")
    Computer c3 ;


    @Override
    public void run(String... args) throws Exception {

        // new ComputerProcessor()
        // .addComputer(new Doubler())
        // .addComputer(new Squarer())
        // .addComputer(new Cuber())
        // .computeAll(8);

         new ComputerProcessor()
        .addComputer(c1)
        .addComputer(c2)
        .addComputer(c3)
        .computeAll(8);


       
    }
    
}
