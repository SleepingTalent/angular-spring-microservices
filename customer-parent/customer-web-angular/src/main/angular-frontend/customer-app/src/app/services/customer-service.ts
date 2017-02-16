import { Injectable } from '@angular/core'
import { Http, Headers, Response } from "@angular/http";
import {Observable} from "rxjs";

export class Customer {
    constructor(
        public id: number,
        public firstName: string,
        public lastName: string) {}
}

@Injectable()
export class CustomerService {
  private findAllUrl = 'http://localhost:3333/customer-service/customer/findAll';

  constructor(private http:Http) {}

    // getCustomers(): Array<Customer> {
    //     return customers.map(p => new Customer(p.id, p.firstName, p.lastName));
    // }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

  getCustomers() : Observable<Customer[]>{
    return this.http.get(this.findAllUrl).map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

}

var customers = [
    {
        "id": 0,
        "firstName": "FirstName0",
        "lastName": "LastName0"
    },
    {
        "id": 1,
        "firstName": "FirstName1",
        "lastName": "LastName1"
    },
    {
        "id": 2,
        "firstName": "FirstName2",
        "lastName": "LastName2"
    },
    {
        "id": 3,
        "firstName": "FirstName3",
        "lastName": "LastName3"
    },
    {
        "id": 4,
        "firstName": "FirstName4",
        "lastName": "LastName4"
    },
    {
        "id": 5,
        "firstName": "FirstName5",
        "lastName": "LastName5"
    }
];
