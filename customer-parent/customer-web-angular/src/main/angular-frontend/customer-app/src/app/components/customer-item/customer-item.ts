import {Component, Input} from '@angular/core';
import {Customer} from '../../services/customer-service';

@Component({
  selector: 'customer-item',
  styleUrls: ['customer-item.css'],
  templateUrl: 'customer-item.html'
})
export default class CustomerItemComponent {
  @Input() customer: Customer;
}
