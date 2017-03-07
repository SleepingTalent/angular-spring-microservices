import {Component} from "@angular/core";
import {CustomerService, Customer} from "../../services/customer-service";
import "rxjs/add/operator/debounceTime";

@Component({
  selector: 'customer-carousel',
  templateUrl: 'carousel.html'
})
export default class CarouselComponent {
  customers: Customer[];
  errorMessage: string;

  constructor(private customerService: CustomerService) {
    this.customerService.getCustomers().subscribe(
      customers => this.customers = customers,
      error => this.errorMessage = <any>error
    );

  }
}
