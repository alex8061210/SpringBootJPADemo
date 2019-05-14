package com.chtti.demo.SpringBootJPADemo;

import com.chtti.demo.SpringBootJPADemo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT x FROM Customer x ORDER BY x.lastName, x.firstName")
    List<Customer> findAllOrderByName();
    @Query("SELECT x FROM Customer x ORDER BY x.firstName, x.lastName")
    List<Customer> findAllOrderByFirstName();
    @Query("SELECT x FROM Customer x ORDER BY x.lastName, x.firstName")
    List<Customer> findAllOrderByName(Pageable pageable);

}
