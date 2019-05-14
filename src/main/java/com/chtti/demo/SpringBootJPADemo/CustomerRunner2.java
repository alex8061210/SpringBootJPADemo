package com.chtti.demo.SpringBootJPADemo;

import com.chtti.demo.SpringBootJPADemo.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
@Order(value = 2)
public class CustomerRunner2 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRunner2.class);
    @Autowired
    private CustomerRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Pageable pageable = PageRequest.of(0, 3); // 0:第一頁 , 3:每個page多少元件
        Page<Customer> currentPage = repository.findAll(pageable);
        LOGGER.info("total page = {}", currentPage.getTotalPages());
        LOGGER.info("%%%get page 0 %%%");
        currentPage.get().forEach(customer -> LOGGER.info(customer.toString()));

        Pageable nextPageable = pageable.next();
        Page<Customer> nextPage = repository.findAll(nextPageable);
        LOGGER.info("%%%get page 1 %%%");
        nextPage.get().forEach(customer -> LOGGER.info(customer.toString()));

    }
}
