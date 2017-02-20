package com.noveria.cukes.steps;

import com.noveria.cukes.helper.RestHelper;
import com.noveria.cukes.helper.TestDataHelper;
import com.noveria.cukes.runtime.RuntimeState;
import com.noveria.model.customer.Customer;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

public class StepDefs extends AbstractStep {

    @Autowired
    RuntimeState runtimeState;

    @Autowired
    TestDataHelper testDataHelper;

    @Autowired
    RestHelper restHelper;

    @Before
    public void setUp(Scenario scenario) {
        runtimeState.setScenario(scenario);
        runtimeState.setHost("localhost:" + port);
    }

    @After
    public void tearDown() {
        Customer customer = runtimeState.getCustomerTestData();

        if(customer != null) {
            testDataHelper.deleteCustomer(customer);
        }
    }

    @Given("^a customer exists$")
    public void aCustomerExists() throws Throwable {
       Customer customer = testDataHelper.createCustomer("Mrs", "Dollie","Schnidt", "01/01/1950", "testDesc");
       runtimeState.setCustomerTestData(customer);
    }


    @Given("^(\\d+) customers exist$")
    public void customersExist(int numberOfCustomers) throws Throwable {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            customers.add(testDataHelper.createCustomer("Mrs", "Dollie_" + i, "Schnidt_" + i, "01/01/1950", "testDesc_" + i));
        }
        runtimeState.setAllCustomersTestData(customers);
    }

    @When("^the user accesses the customer API with a valid id$")
    public void theUserAccessesTheCustomerAPIWithAValidId() throws Throwable {
        Customer customerTestData = runtimeState.getCustomerTestData();

        Customer customer = restHelper.findById(customerTestData.getId());
        runtimeState.setCustomer(customer);
    }

    @Then("^the expected customer is returned$")
    public void theExpectedCustomerIsReturned() throws Throwable {
        assertThat(runtimeState.getCustomer().getId()).isEqualTo(runtimeState.getCustomerTestData().getId());
        assertThat(runtimeState.getCustomer().getTitle()).isEqualTo(runtimeState.getCustomerTestData().getTitle());
        assertThat(runtimeState.getCustomer().getFirstName()).isEqualTo(runtimeState.getCustomerTestData().getFirstName());
        assertThat(runtimeState.getCustomer().getLastName()).isEqualTo(runtimeState.getCustomerTestData().getLastName());
        assertThat(runtimeState.getCustomer().getDateOfBirth()).isEqualTo(runtimeState.getCustomerTestData().getDateOfBirth());
        assertThat(runtimeState.getCustomer().getDescription()).isEqualTo(runtimeState.getCustomerTestData().getDescription());
    }

    @When("^the user accesses the customer API with a valid lastname$")
    public void theUserAccessesTheCustomerAPIWithAValidLastname() throws Throwable {
        Customer customerTestData = runtimeState.getCustomerTestData();

        List<Customer> customers = restHelper.findByLastName(customerTestData.getLastName());
        assertThat(customers.size()).isEqualTo(1);

        runtimeState.setCustomer(customers.get(0));
    }

    @When("^the user accesses the customer API and requests all customers$")
    public void theUserAccessesTheCustomerAPIAndRequestsAllCustomers() throws Throwable {
        List<Customer> customers = restHelper.findAll();
        runtimeState.setAllCustomers(customers);
    }

    @Then("^the expected customers are returned$")
    public void theExpectedCustomersAreReturned() throws Throwable {
        List<Customer> testDataCustomers = runtimeState.getAllCustomersTestData();
        List<Customer> retrievedCustomers = runtimeState.getAllCustomers();

        assertThat(not(retrievedCustomers.isEmpty()));
        assertThat(retrievedCustomers.size()).isEqualTo(4);
        assertThat(retrievedCustomers.get(0).getId()).isEqualTo(testDataCustomers.get(0).getId());
        assertThat(retrievedCustomers.get(0).getTitle()).isEqualTo(testDataCustomers.get(0).getTitle());
        assertThat(retrievedCustomers.get(0).getFirstName()).isEqualTo(testDataCustomers.get(0).getFirstName());
        assertThat(retrievedCustomers.get(0).getLastName()).isEqualTo(testDataCustomers.get(0).getLastName());
        assertThat(retrievedCustomers.get(0).getDateOfBirth()).isEqualTo(testDataCustomers.get(0).getDateOfBirth());
        assertThat(retrievedCustomers.get(0).getDescription()).isEqualTo(testDataCustomers.get(0).getDescription());

        assertThat(retrievedCustomers.get(1).getDescription()).isEqualTo(testDataCustomers.get(1).getDescription());
        assertThat(retrievedCustomers.get(2).getDescription()).isEqualTo(testDataCustomers.get(2).getDescription());
        assertThat(retrievedCustomers.get(3).getDescription()).isEqualTo(testDataCustomers.get(3).getDescription());

        assertThat(retrievedCustomers.get(0).getDescription()).isNotEqualTo(retrievedCustomers.get(1).getDescription());
    }
}
