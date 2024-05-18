package com.example.loggers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
        copyLogFile();
        
        try{
             int x = 3 / 0 ;
        }catch(Exception e){
           LOGGER.error("Errur occurred: "+ e.getMessage());
        }
        LOGGER.info("Application finished");
    }

    public void copyLogFile(){
        File sourceFile = new File("logs/mylog.log");
        File destinationFile = new File("logs/old/mylogs.log");

        try{
            if (!sourceFile.exists()){
                sourceFile.getParentFile().mkdirs();
                sourceFile.createNewFile();
            }

            if (!destinationFile.exists()){
                destinationFile.getParentFile().mkdirs();
                destinationFile.createNewFile();
            }

            Files.copy(sourceFile.toPath(), destinationFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            LOGGER.info("Log file has been successfully copied to " + destinationFile.getAbsolutePath());

        }catch(IOException e){

            LOGGER.error("Errur copying log file"+ e.getMessage());

        }
    }

}
