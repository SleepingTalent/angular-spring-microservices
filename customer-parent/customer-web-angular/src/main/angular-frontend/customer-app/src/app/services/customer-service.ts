export class Customer {
    constructor(
        public id: number,
        public firstname: string,
        public lastname: string) {}
}

export class CustomerService {
    getCustomers(): Array<Customer> {
        return customers.map(p => new Customer(p.id, p.firstname, p.lastname));
    }
}

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
