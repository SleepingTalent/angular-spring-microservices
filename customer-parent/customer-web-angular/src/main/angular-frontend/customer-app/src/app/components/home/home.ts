import {Component} from '@angular/core';
import {CustomerService, Customer} from "../../services/customer-service";

@Component({
  selector: 'auction-home-page',
  styleUrls: ['home.css'],
  templateUrl: 'home.html'
})
export default class HomeComponent {
  customers: Array<Customer> = [];

  constructor(private customerService: CustomerService) {
    this.customerService.getCustomers().subscribe(data => this.customers = data);
  }
}
