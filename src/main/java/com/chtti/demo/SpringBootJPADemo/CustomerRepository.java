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

    List<Customer> findByFirstName(String firstName);
    List<Customer> findByFirstNameIgnoreCase(String firstName);
    List<Customer> findByLastName(String lastName);

    Integer countByFirstNameIgnoreCase(String firstName);
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    List<Customer> findByFirstNameOrLastName(String firstName, String lastName);
    List<Customer> findByAgeBetween (int lower, int higher);

}
