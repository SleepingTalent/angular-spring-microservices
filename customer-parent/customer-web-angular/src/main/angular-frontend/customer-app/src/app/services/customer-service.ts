import {Injectable, EventEmitter, Output} from '@angular/core'
import { Http, Response } from "@angular/http";
import {Observable} from "rxjs";

export class Customer {
    constructor(
        public id?: number,
        public title?: string,
        public firstName?: string,
        public lastName?: string,
        public dateOfBirth?: string,
        public description?: string) {}
}

@Injectable()
export class CustomerService {
  private findByIdUrl = 'http://localhost:3333/customer-service/customer/id';
  private findByLastnameUrl = 'http://localhost:3333/customer-service/customer/lastname';
  private findAllUrl = 'http://localhost:3333/customer-service/customer/findAll';

  constructor(private http:Http) {}

  getCustomers() : Observable<Customer[]>{
    console.log('getCustomers');

    return this.http.get(this.findAllUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getCustomerById(customerId: number) : Observable<Customer>{
    console.log('getCustomers by Id:'+customerId);

    return this.http.get(this.findByIdUrl+'/'+customerId)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getCustomersByLastName(lastname: string) : Observable<Customer[]>{
    console.log('getCustomers by Lastname:'+lastname)

    return this.http.get(this.findByLastnameUrl+'/'+lastname)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
}

