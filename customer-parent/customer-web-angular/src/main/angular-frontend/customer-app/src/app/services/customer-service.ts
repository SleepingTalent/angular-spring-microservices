import {Injectable, EventEmitter, Output} from '@angular/core'
import {Http, Headers, Response, RequestOptions} from "@angular/http";
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

  getHeaders() : Headers {
    let username : string = 'guest';
    let password : string = 'guest123';
    let encodedAuth : string = 'Basic ' + btoa(username + ":" + password);

    let headers = new Headers();
    headers.append("Authorization", encodedAuth);

    console.log('Headers has Authorization Key: ' + headers.has('Authorization'));
    console.log('Headers Authorization Value: ' + headers.get('Authorization'));
    console.log('Headers Json: ' + headers.toJSON());

    return headers;
  }

  getCustomers() : Observable<Customer[]>{
    console.log('getCustomers');
    //let options = new RequestOptions({ headers: this.getHeaders(), withCredentials: true });

     //return this.http.get(this.findAllUrl, options)
    return this.http.get(this.findAllUrl, {headers: this.getHeaders()})
      .map((res:Response) => res.json())
      .catch(this.handleServerError);
  }

  private handleServerError(error : Response) {
    // console.log('Error : ' + error);
    // console.log('Error Status : ' + error.status);
    // console.log('Error StatusText: ' + error.statusText);
    //
    // console.log('Headers: ' + error.headers.values());
    return Observable.throw(error.json().error || 'Server error')
  }

  getCustomerById(customerId: number) : Observable<Customer>{
    console.log('getCustomers by Id:'+customerId);
    let options = new RequestOptions({ headers: this.getHeaders() });

    return this.http.get(this.findByIdUrl+'/'+customerId, options)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getCustomersByLastName(lastname: string) : Observable<Customer[]>{
    console.log('getCustomers by Lastname:'+lastname);
    let options = new RequestOptions({ headers: this.getHeaders() });

    return this.http.get(this.findByLastnameUrl+'/'+lastname, options)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }
}

