import { Injectable } from '@angular/core'
import { Http, Headers, Response } from "@angular/http";
import {Observable} from "rxjs";

export class Customer {
    constructor(
        public id?: number,
        public firstName?: string,
        public lastName?: string) {}
}

@Injectable()
export class CustomerService {
  private findByIdUrl = 'http://localhost:3333/customer-service/customer/id';
  private findAllUrl = 'http://localhost:3333/customer-service/customer/findAll';

  constructor(private http:Http) {}

  getCustomers() : Observable<Customer[]>{
    return this.http.get(this.findAllUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getCustomerById(customerId: number) : Observable<Customer>{
    return this.http.get(this.findByIdUrl+'/'+customerId)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
}

