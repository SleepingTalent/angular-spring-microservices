package com.noveria.controller;

import com.noveria.exception.CustomerNotFoundException;
import com.noveria.model.customer.Customer;
import com.noveria.model.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

    protected Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer findById(@PathVariable("id") Long id) {

        logger.info("customer-service findById() invoked: " + id);

        Customer customer = customerRepository.findOne(id);

        if (customer == null)
            throw new CustomerNotFoundException("No customer found with id: " + id);
        else {
            logger.info("customer-service findById() found: " + customer);
            return customer;
        }
    }

    @RequestMapping(value = "/lastname/{lastname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findByLastName(@PathVariable("lastname") String lastname) {

        logger.info("customer-service findByLastName() invoked: " + lastname);

        List<Customer> customers = customerRepository.findByLastName(lastname);

        if (customers.isEmpty())
            throw new CustomerNotFoundException("No customers found with lastname: " + lastname);
        else {
            logger.info("customer-service findByLastName() found: " + customers);
            return customers;
        }
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> findAll() {

        logger.info("customer-service findAll() invoked: ");

        List<Customer> customers = customerRepository.findAll();

        if (customers.isEmpty())
            throw new CustomerNotFoundException("No customers found");
        else {
            logger.info("customer-service findAll() found: " + customers);
            return customers;
        }
    }
}
