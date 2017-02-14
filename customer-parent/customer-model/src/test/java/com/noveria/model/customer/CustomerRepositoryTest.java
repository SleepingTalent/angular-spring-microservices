package com.noveria.model.customer;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Customer.class)
public class CustomerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customers;

    Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("first", "last");
        entityManager.persist(customer);
    }

    @After
    public void tearDown() {
        entityManager.remove(customer);
    }

    @Test
    public void findByLastName_returns_expectedCustomer() {
        List<Customer> results = customers.findByLastName(customer.getLastName());

        assertEquals(1, results.size());
        Customer actual = results.get(0);

        assertCustomer(actual);
    }

    @Test
    public void findByLastName_returns_emptyList_whenCustomerNotFound() {
        List<Customer> results = customers.findByLastName("notFound");
        assertTrue("Expected result list to be empty!", results.isEmpty());
    }

    @Test
    public void findOne_returns_expectedCustomer() {
        Customer actual = customers.findOne(customer.getId());
        assertCustomer(actual);
    }

    @Test
    public void findOne_returns_null_whenCustomerNotFound() {
        Customer actual = customers.findOne(9999L);
        assertNull("Expected Customer to be null", actual);
    }

    private void assertCustomer(Customer actual) {
        assertEquals(customer.getId(), actual.getId());
        assertEquals(customer.getFirstName(), actual.getFirstName());
        assertEquals(customer.getLastName(), actual.getLastName());
    }
}
