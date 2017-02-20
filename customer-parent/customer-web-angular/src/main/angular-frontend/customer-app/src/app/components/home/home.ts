import {Component} from '@angular/core';
import {FormControl} from "@angular/forms";
import {CustomerService, Customer} from '../../services/customer-service';
import {FilterPipe} from '../pipes/filter-pipe'
import 'rxjs/add/operator/debounceTime';
import {Observable} from "rxjs";
import {SearchEventService} from "../../services/search-event-service";

@Component({
  selector: 'auction-home-page',
  styleUrls: ['home.css'],
  templateUrl: 'home.html'
})
export default class HomeComponent {
  customers: Observable<Customer[]>;
  //lastNameFilter: FormControl = new FormControl();
  //filterCriteria: string;

  constructor(private customerService: CustomerService, private searchEventService: SearchEventService) {

    this.customers = this.customerService.getCustomers();

    // this.lastNameFilter.valueChanges.debounceTime(100).subscribe(
    //   value => this.filterCriteria = value,
    //   error => console.error(error)
    // )

    this.searchEventService.getSearchLastNameEvent()
      .subscribe(
        params => this.customers = this.customerService.getCustomersByLastName(params),
        err =>  console.log("Can't get customer by lastname. Error code: %s, URL: %s "),
        () => console.log('DONE')
      );
  }
}
