package com.example.computer.services;

import java.util.ArrayList;
import java.util.List;

import com.example.computer.models.Computer;
import com.example.computer.models.Cuber;
import com.example.computer.models.Doubler;
import com.example.computer.models.Squarer;

public class ComputerProcessor {

    // private List <Object>  computers = new ArrayList<Object>();

    // public ComputerProcessor addComputer(Object o){
    //     computers.add(o);
    //     return ComputerProcessor.this ;
    // }

    private List <Computer>  computers = new ArrayList<Computer>();

    public ComputerProcessor addComputer(Computer o){
        computers.add(o);
        return ComputerProcessor.this ;
    }

    public void computeAll(long value){
        for (Computer o : computers){
            // long computerValue = -1 ;

            // if( o instanceof Doubler){
            //     computerValue = ((Doubler) o).computeDouble(value); 
            // }else if(o instanceof Squarer){
            //     computerValue = ((Squarer) o).computeSquare(value);
            // }else if(o instanceof Cuber){
            //     computerValue = ((Cuber) o).computeCube(value);
            // }

            long computerValue = o.compute(value);

            String name = o.getClass().getSimpleName();
            System.out.println("Computer: " + name + ", value:  "+ value +
            " computed value: " + computerValue);

        }
    }
    
}
