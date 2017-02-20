import {Component, Output, EventEmitter} from '@angular/core';
import {CustomerService} from "../../services/customer-service";
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {SearchEventService} from "../../services/search-event-service";

@Component({
  selector: 'customer-search',
  providers: [CustomerService],
  templateUrl: 'search.html'
})
export default class SearchComponent {
  formGroup: FormGroup;

  constructor(private searchEventService : SearchEventService) {
    const formBuilder = new FormBuilder();

    this.formGroup = formBuilder.group({
      lastName: [null, Validators.minLength(3)]
    })
  }

  onSearch() {
    if (this.formGroup.valid) {
      console.log(this.formGroup.get('lastName').value);
      this.searchEventService.sendLastNameSearchEvent(this.formGroup.get('lastName').value);
    }
  }
}
