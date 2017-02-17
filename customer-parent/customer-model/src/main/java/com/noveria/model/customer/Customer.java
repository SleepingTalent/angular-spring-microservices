package com.noveria.model.customer;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    @Column(name = "DESCRIPTION")
    private String description;

    protected Customer() {}

    public Customer(String title, String firstName, String lastName, String dateOfBirth, String description) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, title='%s', firstName='%s', lastName='%s', dateOfBirth='%s', desc='%s']",
                id, title, firstName, lastName, dateOfBirth, description);
    }

    public String getTitle() {
        return title;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
