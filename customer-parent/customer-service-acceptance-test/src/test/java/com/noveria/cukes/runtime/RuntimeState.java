package com.noveria.cukes.runtime;

import com.babcock.model.customer.Customer;
import cucumber.api.Scenario;
import org.springframework.stereotype.Component;

@Component
public class RuntimeState {

    private Scenario scenario;
    private Customer customer;
    private Customer customerTestData;
    private String host;

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
}
