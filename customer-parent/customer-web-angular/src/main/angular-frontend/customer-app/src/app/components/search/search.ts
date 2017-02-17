import {Component} from '@angular/core';
import {CustomerService} from "../../services/customer-service";
import {FormGroup, FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'customer-search',
  providers: [CustomerService],
  templateUrl: 'search.html'
})
export default class SearchComponent {
  formModel: FormGroup;

  constructor(private customerService : CustomerService) {
    const formBuilder = new FormBuilder();

    this.formModel = formBuilder.group({
      'lastName': [null, Validators.minLength(3)]
    })
  }

  onSearch() {
    if (this.formModel.valid) {
      console.log(this.formModel.value);
    }
  }
}
