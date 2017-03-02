import {Component, Input} from "@angular/core";
import {Customer} from "../../services/customer-service";

@Component({
  selector: 'customer-carousel',
  templateUrl: 'carousel.html'
})
export default class CarouselComponent {
  @Input() carouselCustomers: Customer;

}
