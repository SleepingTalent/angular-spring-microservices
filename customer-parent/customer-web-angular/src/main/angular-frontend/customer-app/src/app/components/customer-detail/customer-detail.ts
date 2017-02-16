import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'customer-detail-page',
  templateUrl: 'customer-detail.html'
})
export default class CustomerDetailComponent {
  customerId: string;

  constructor(route: ActivatedRoute){
    this.customerId = route.snapshot.params['id'];
  }
}
