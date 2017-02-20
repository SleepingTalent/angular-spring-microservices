import {Injectable, EventEmitter} from "@angular/core";

@Injectable()
export class SearchEventService {

  searchEvent: EventEmitter<string>;

  constructor() {
    console.log('creating Search Event');
    this.searchEvent = new EventEmitter();
  }

  sendLastNameSearchEvent(lastName :string){
    console.log('sending LastName Search Event');
    this.searchEvent.emit(lastName);
  }

  getSearchLastNameEvent() {
    console.log('getting Search LastName Event');
    return this.searchEvent;
  }
}
