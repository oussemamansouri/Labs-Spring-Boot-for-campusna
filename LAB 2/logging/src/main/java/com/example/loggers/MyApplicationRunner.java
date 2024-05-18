package com.example.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyApplicationRunner.class) ;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Application started");

        try{
             int x = 3 / 0 ;
        }catch(Exception e){
           LOGGER.error("Errur occurred: "+ e.getMessage());
        }
        LOGGER.info("Application finished");
    }

}
