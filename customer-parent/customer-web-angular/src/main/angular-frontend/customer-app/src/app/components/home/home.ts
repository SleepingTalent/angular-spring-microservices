import {Component} from '@angular/core';
import {FormControl} from "@angular/forms";
import {CustomerService, Customer} from '../../services/customer-service';
import {FilterPipe} from '../pipes/filter-pipe'
import 'rxjs/add/operator/debounceTime';

@Component({
  selector: 'auction-home-page',
  styleUrls: ['home.css'],
  templateUrl: 'home.html'
})
export default class HomeComponent {
  customers: Array<Customer> = [];
  lastNameFilter: FormControl = new FormControl();
  filterCriteria: string;

  constructor(private customerService: CustomerService) {
    this.customerService.getCustomers().subscribe(data => this.customers = data);
    this.lastNameFilter.valueChanges.debounceTime(100).subscribe(
      value => this.filterCriteria = value,
      error => console.error(error)
    )
  }
}
