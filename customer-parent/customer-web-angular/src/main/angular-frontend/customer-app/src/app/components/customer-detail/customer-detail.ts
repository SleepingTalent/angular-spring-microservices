import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Customer, CustomerService} from "../../services/customer-service";

@Component({
  selector: 'customer-detail-page',
  templateUrl: 'customer-detail.html'
})
export default class CustomerDetailComponent {
  customer: Customer;

  constructor(route: ActivatedRoute, customerService: CustomerService){
    this.customer = new Customer();
    let customerId: number = route.snapshot.params['id'];
    customerService.getCustomerById(customerId).subscribe(data => this.customer = data);
  }
}
