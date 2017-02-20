package com.noveria.cukes.helper;

import com.noveria.model.customer.Customer;
import com.noveria.model.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataHelper {

    @Autowired
    CustomerRepository customerRepository;

    public Customer createCustomer(String title, String firstName, String lastName, String dateOfBirth, String description) {
        Customer customer = new Customer(title, firstName, lastName, dateOfBirth, description);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findOne(id);
    }
}
