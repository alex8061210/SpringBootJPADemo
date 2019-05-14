package com.chtti.demo.SpringBootJPADemo;

import com.chtti.demo.SpringBootJPADemo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService {
    @Autowired
    CustomerSimpleRepository repository;

    public List<Customer> findAll(){
        List<Customer> returnObj = new ArrayList<>();
        repository.findAll().forEach(returnObj::add);
        return returnObj;
    }

    public Customer findOne(Integer id){
        return repository.findById(id).get();
    }

    public Customer create(Customer customer){
        return repository.save(customer);
    }

    public Customer update(Customer customer){
        return repository.save(customer);
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
