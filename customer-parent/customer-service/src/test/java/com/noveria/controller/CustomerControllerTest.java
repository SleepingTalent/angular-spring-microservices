package com.noveria.controller;

import com.noveria.exception.CustomerNotFoundException;
import com.noveria.model.customer.Customer;
import com.noveria.model.customer.CustomerRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.eq;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    CustomerController customerController;

    @MockBean
    CustomerRepository customerRepository;

    Customer customer;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        customer = new Customer("Mr", "first", "last", "16/06/1982", "testDesc");
    }

    @Test
    public void findById_returns_expectedCustomer() throws Exception {
        given(customerRepository.findOne(eq(1234l))).willReturn(customer);

        Customer customer = customerController.findById(1234l);

        assertCustomer(customer);
    }

    @Test
    public void findById_throws_customerNotFoundException_whenCustomerNotFound() throws Exception {
        expectedException.expect(CustomerNotFoundException.class);
        expectedException.expectMessage("No customer found with id: 1234");

        given(customerRepository.findOne(eq(1234l))).willReturn(null);

        customerController.findById(1234l);

    }

    @Test
    public void findByLastName_returns_expectedCustomer() throws Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        given(customerRepository.findByLastName(eq("last"))).willReturn(customers);

        List<Customer> result = customerController.findByLastName("last");

        assertEquals(1, result.size());
        assertCustomer(result.get(0));
    }

    @Test
    public void findByLastName_throws_customerNotFoundException_whenCustomerNotFound() throws Exception {
        expectedException.expect(CustomerNotFoundException.class);
        expectedException.expectMessage("No customers found with lastname: last");

        given(customerRepository.findByLastName(eq("last"))).willReturn(new ArrayList<>());

        customerController.findByLastName("last");

    }

    private void assertCustomer(Customer actual) {
        assertEquals(customer.getTitle(),actual.getTitle());
        assertEquals(customer.getFirstName(),actual.getFirstName());
        assertEquals(customer.getLastName(),actual.getLastName());
        assertEquals(customer.getDateOfBirth(),actual.getDateOfBirth());
        assertEquals(customer.getDescription(),actual.getDescription());
    }
}