Feature: Customer API Features

  Scenario: A User can retrieve a customer by Id
    Given a customer exists
    When the user accesses the customer API with a valid id
    Then the expected customer is returned

  Scenario: A User can retrieve a customer by Lastname
    Given a customer exists
    When the user accesses the customer API with a valid lastname
    Then the expected customer is returned