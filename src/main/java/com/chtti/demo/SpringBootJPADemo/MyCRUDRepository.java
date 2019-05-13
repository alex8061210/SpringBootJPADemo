package com.chtti.demo.SpringBootJPADemo;

import com.chtti.demo.SpringBootJPADemo.model.Beverage;
import org.springframework.data.repository.CrudRepository;

public interface MyCRUDRepository  extends CrudRepository<Beverage, Long> {
}
