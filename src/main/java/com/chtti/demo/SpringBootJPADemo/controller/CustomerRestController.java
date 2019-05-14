package com.chtti.demo.SpringBootJPADemo.controller;

import com.chtti.demo.SpringBootJPADemo.CustomerService;
import com.chtti.demo.SpringBootJPADemo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
    @Autowired
    CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers(){
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable Integer id){
        return service.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) //201
    Customer postCustomers(@RequestBody Customer customer){
        return service.create(customer);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customer.setId(id);
        return service.update(customer);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    void deleteCustomer(@PathVariable Integer id){
        service.delete(id);
    }
}
