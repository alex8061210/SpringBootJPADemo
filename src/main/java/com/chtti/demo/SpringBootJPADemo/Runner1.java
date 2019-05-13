package com.chtti.demo.SpringBootJPADemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Runner1 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner1.class);
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Runner1 start to run.");
    }

    @Scheduled(fixedRate = 3000)
    public void detect(){
        LOGGER.info("will check new data");
    }
}
