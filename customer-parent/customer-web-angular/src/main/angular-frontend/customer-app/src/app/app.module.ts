import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {RouterModule, Routes} from '@angular/router';
import {LocationStrategy, HashLocationStrategy} from '@angular/common';
import { AlertModule } from 'ng2-bootstrap/ng2-bootstrap';
import { HttpModule }     from '@angular/http';
import ApplicationComponent from './components/application/application';
import CustomerItemComponent from "./components/customer-item/customer-item";
import NavbarComponent from "./components/navbar/navbar";
import {CustomerService} from "./services/customer-service";
import FooterComponent from "./components/footer/footer";
import SearchComponent from "./components/search/search";
import CarouselComponent from "./components/carousel/carousel";
import HomeComponent from "./components/home/home";
import CustomerDetailComponent from "./components/customer-detail/customer-detail";

const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'customer/:id', component: CustomerDetailComponent}
  ];

@NgModule({
    imports:        [ AlertModule.forRoot(), BrowserModule, HttpModule, RouterModule.forRoot(routes)],
    declarations:   [ ApplicationComponent, CustomerItemComponent,
                        NavbarComponent, FooterComponent,
                        SearchComponent, CarouselComponent,
                        HomeComponent, CustomerDetailComponent],
    providers:      [ CustomerService, {provide: LocationStrategy, useClass: HashLocationStrategy}],
    bootstrap:      [ ApplicationComponent ]
})
export class AppModule { }
