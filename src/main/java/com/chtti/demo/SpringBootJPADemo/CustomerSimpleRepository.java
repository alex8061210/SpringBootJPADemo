package com.chtti.demo.SpringBootJPADemo;

import com.chtti.demo.SpringBootJPADemo.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerSimpleRepository  extends CrudRepository<Customer, Integer> {
}
