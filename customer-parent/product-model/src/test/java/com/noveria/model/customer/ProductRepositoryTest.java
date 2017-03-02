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
@SpringBootTest(classes = Product.class)
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    Product product;

    @Before
    public void setUp() {
        product = new Product();
        product.setName("testProduct");
        product.setDescription("testDesc");

        entityManager.persist(product);
    }

    @After
    public void tearDown() {
        entityManager.remove(product);
    }

    @Test
    public void findByLastName_returns_expectedProduct() {
        List<Product> results = productRepository.findByName(product.getName());

        assertEquals(1, results.size());
        Product actual = results.get(0);

        assertProduct(actual);
    }

    @Test
    public void findByLastName_returns_emptyList_whenProductNotFound() {
        List<Product> results = productRepository.findByName("notFound");
        assertTrue("Expected result list to be empty!", results.isEmpty());
    }

    @Test
    public void findOne_returns_expectedProduct() {
        Product actual = productRepository.findOne(product.getId());
        assertProduct(actual);
    }

    @Test
    public void findOne_returns_null_whenProductNotFound() {
        Product actual = productRepository.findOne(9999L);
        assertNull("Expected Product to be null", actual);
    }

    private void assertProduct(Product actual) {
        assertEquals(product.getId(), actual.getId());
        assertEquals(product.getName(), actual.getName());
        assertEquals(product.getDescription(), actual.getDescription());
    }
}
