package com.noveria.cukes.runtime;

import com.noveria.model.customer.Customer;
import cucumber.api.Scenario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RuntimeState {

    private Scenario scenario;
    private Customer customer;
    private Customer customerTestData;
    private String host;
    private List<Customer> allCustomers = new ArrayList<>();
    private List<Customer> allCustomersTestData = new ArrayList<>();

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
        this.allCustomers.add(customer);
    }

    public void setCustomerTestData(Customer customerTestData) {

        this.customerTestData = customerTestData;
    }

    public Customer getCustomerTestData() {
        return customerTestData;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setAllCustomers(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }

    public List<Customer> getAllCustomers() {
        return allCustomers;
    }

    public List<Customer> getAllCustomersTestData() {
        return allCustomersTestData;
    }

    public void setAllCustomersTestData(List<Customer> allCustomersTestData) {
        this.allCustomersTestData = allCustomersTestData;
    }
}
