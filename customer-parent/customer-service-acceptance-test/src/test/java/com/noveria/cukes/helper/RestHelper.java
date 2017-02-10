package com.noveria.cukes.helper;

import com.noveria.cukes.runtime.RuntimeState;
import com.noveria.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class RestHelper {

    @Autowired
    RuntimeState runtimeState;

    @Autowired
    protected TestRestTemplate restTemplate;

    private String getCustomerUrl() {
        return "http://"+runtimeState.getHost() + "/customer";
    }

    private String buildFindByIdUrl(Long id) {
        return getCustomerUrl()+"/id/"+id;
    }

    private String buildFindByLastNameUrl(String lastName) {
        return getCustomerUrl()+"/lastname/"+lastName;
    }

    public Customer findById(Long id) {
        ResponseEntity<Customer> response = restTemplate.getForEntity(buildFindByIdUrl(id), Customer.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        return response.getBody();
    }

    public List<Customer> findByLastName(String lastName) {
        ResponseEntity<Customer[]> response = restTemplate.getForEntity(buildFindByLastNameUrl(lastName), Customer[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        return Arrays.asList(response.getBody());
    }
}
