"use strict";
var Customer = (function () {
    function Customer(id, firstname, lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    return Customer;
}());
exports.Customer = Customer;
var CustomerService = (function () {
    function CustomerService() {
    }
    CustomerService.prototype.getCustomers = function () {
        return customers.map(function (p) { return new Customer(p.id, p.firstname, p.lastname); });
    };
    return CustomerService;
}());
exports.CustomerService = CustomerService;
var customers = [
    {
        "id": 0,
        "firstname": "FirstName0",
        "lastname": "LastName0"
    },
    {
        "id": 1,
        "firstname": "FirstName1",
        "lastname": "LastName1"
    },
    {
        "id": 2,
        "firstname": "FirstName2",
        "lastname": "LastName2"
    },
    {
        "id": 3,
        "firstname": "FirstName3",
        "lastname": "LastName3"
    },
    {
        "id": 4,
        "firstname": "FirstName4",
        "lastname": "LastName4"
    },
    {
        "id": 5,
        "firstname": "FirstName5",
        "lastname": "LastName5"
    }
];
//# sourceMappingURL=customer-service.js.map