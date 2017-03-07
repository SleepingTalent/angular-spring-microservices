import {Component} from "@angular/core";
import {CustomerService, Customer} from "../../services/customer-service";
import "rxjs/add/operator/debounceTime";

@Component({
  selector: 'customer-carousel',
  templateUrl: 'carousel.html'
})
export default class CarouselComponent {
  customers: Customer[];

  constructor(private customerService: CustomerService) {
    this.customers = [
      {id: 123, title: 'Mr', firstName: 'Bob', lastName: 'Davro', dateOfBirth: '12/12/2001', description: 'Comedian'},
      {id: 123, title: 'Mrs', firstName: 'Lizzy', lastName: 'Slim', dateOfBirth: '13/10/1969', description: 'Singer'},
      {id: 123, title: 'Mr', firstName: 'Craig', lastName: 'David', dateOfBirth: '14/10/1969', description: 'Comedian'},
      {
        id: 123,
        title: 'Mrs',
        firstName: 'Fran',
        lastName: 'Sisco',
        dateOfBirth: '15/07/1968',
        description: 'Geography Teacher'
      },
      {
        id: 123,
        title: 'Mr',
        firstName: 'Richard',
        lastName: 'Cranium',
        dateOfBirth: '22/09/1968',
        description: 'Comedian'
      },
      {id: 123, title: 'Miss', firstName: 'Daisy', lastName: 'Duke', dateOfBirth: '22/10/1988', description: 'Actress'},
      {id: 123, title: 'Dr', firstName: 'Ludvig', lastName: 'Snuff', dateOfBirth: '14/11/1978', description: 'Welder'},
      {
        id: 123,
        title: 'Sir',
        firstName: 'James',
        lastName: 'Blunt',
        dateOfBirth: '23/02/1968',
        description: 'Comedian'
      },
    ];

    // this.customers = this.customerService.getCustomers();

  }
}
