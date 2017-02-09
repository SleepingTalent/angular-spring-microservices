package com.noveria.cukes.helper;

import com.babcock.model.customer.Customer;
import com.babcock.model.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataHelper {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
