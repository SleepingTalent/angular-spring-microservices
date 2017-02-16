import {Component, ViewEncapsulation} from '@angular/core';
import {Customer, CustomerService} from '../../services/customer-service';

@Component({
    selector: 'customer-application', // <1>
    templateUrl: 'application.html',
    styleUrls: ['application.css'],
    encapsulation:ViewEncapsulation.None
})

export default class ApplicationComponent {
    customers: Array<Customer> = [];

    constructor(private customerService: CustomerService) {
        this.customers = this.customerService.getCustomers();
    }
}
