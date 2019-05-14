package com.chtti.demo.SpringBootJPADemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 4)
public class CustomerRunner4 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner4.class);
    @Autowired
    CustomerRepository repository;
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("***get some custom query***");
        repository.findByFirstName("Kobe").forEach(customer -> LOGGER.info(customer.toString()));
        LOGGER.info("***get some custom query Ignorecase***");
        repository.findByFirstNameIgnoreCase("KOBE").forEach(customer -> LOGGER.info(customer.toString()));
        LOGGER.info("***first name is kobe, count = {}***", repository.countByFirstNameIgnoreCase("Kobe"));
        LOGGER.info("***two condition query***");
        repository.findByFirstNameAndLastName("Kobe", "Bryant").forEach(customer -> LOGGER.info(customer.toString()));
        LOGGER.info("***two condition query Union***");
        repository.findByFirstNameOrLastName("Kobe", "James").forEach(customer -> LOGGER.info(customer.toString()));
        LOGGER.info("***range query***");
        repository.findByAgeBetween(40, 50).forEach(customer -> LOGGER.info(customer.toString()));

    }
}
