package com.noveria.cukes.steps;

import com.noveria.cukes.helper.TestDataHelper;
import com.noveria.cukes.helper.RestHelper;
import com.noveria.cukes.runtime.RuntimeState;
import com.noveria.model.customer.Customer;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
       Customer customer = testDataHelper.createCustomer("Dollie","Schnidt");
       runtimeState.setCustomerTestData(customer);
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
        assertThat(runtimeState.getCustomer().getFirstName()).isEqualTo(runtimeState.getCustomerTestData().getFirstName());
        assertThat(runtimeState.getCustomer().getLastName()).isEqualTo(runtimeState.getCustomerTestData().getLastName());
    }

    @When("^the user accesses the customer API with a valid lastname$")
    public void theUserAccessesTheCustomerAPIWithAValidLastname() throws Throwable {
        Customer customerTestData = runtimeState.getCustomerTestData();

        List<Customer> customers = restHelper.findByLastName(customerTestData.getLastName());
        assertThat(customers.size()).isEqualTo(1);

        runtimeState.setCustomer(customers.get(0));
    }
}
