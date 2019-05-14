package com.chtti.demo.SpringBootJPADemo;

import com.chtti.demo.SpringBootJPADemo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class CustomerRunner1 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner1.class);
    @Autowired
    CustomerRepository repository;
    @Override
    public void run(String... args) throws Exception {
        initSampleData();
        LOGGER.info("***print all***");
        repository.findAll().forEach(customer -> LOGGER.info(customer.toString()));
        LOGGER.info("***print all ordered***");
        repository.findAllOrderByName().forEach(customer -> LOGGER.info(customer.toString()));
        LOGGER.info("***print all ordered by firstName***");
        repository.findAllOrderByFirstName().forEach(customer -> LOGGER.info(customer.toString()));
    }

    private void initSampleData(){
        Customer c1 = repository.save(new Customer(null, "Michael", "Jordan",10));
        LOGGER.info("create 1 c1 :{}", c1.toString());
        repository.save(new Customer(null, "Kobe", "Bryant",20));
        repository.save(new Customer(null, "Jason", "Kidd",25));
        repository.save(new Customer(null, "James", "Harden",30));
        repository.save(new Customer(null, "LeBron", "James",35));
        repository.save(new Customer(null, "DeMar", "DeRozen",40));
        repository.save(new Customer(null, "Jeremy", "Lin",45));
        repository.save(new Customer(null, "Kobe", "Steak",50));

    }
}
