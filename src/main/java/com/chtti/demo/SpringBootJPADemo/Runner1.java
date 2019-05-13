package com.chtti.demo.SpringBootJPADemo;

import com.chtti.demo.SpringBootJPADemo.model.Beverage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Runner1 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner1.class);
    @Autowired
    MyCRUDRepository repository;

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Runner1 start to run.");
        repository.deleteAll();
        LOGGER.info("clear finish, will try to add something");
        addSampleData();
    }

    //@Scheduled(fixedRate = 3000)
    public void detect() {
        LOGGER.info("will check new data");
    }

    private void addSampleData(){
        repository.save(new Beverage("Americano","black coffee"));
        repository.save(new Beverage("Earl Gray Tea","Hot breakfast tea"));
        repository.save(new Beverage("Latte","coffee with triple hot milk"));
        repository.save(new Beverage("Green tea","macha"));


    }
}
