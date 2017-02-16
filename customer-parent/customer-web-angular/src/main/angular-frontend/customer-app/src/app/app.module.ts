import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AlertModule } from 'ng2-bootstrap/ng2-bootstrap';
import ApplicationComponent from './components/application/application';
import CustomerItemComponent from "./components/customer-item/customer-item";
import NavbarComponent from "./components/navbar/navbar";
import {CustomerService} from "./services/customer-service";
import FooterComponent from "./components/footer/footer";
import SearchComponent from "./components/search/search";
import CarouselComponent from "./components/carousel/carousel";

@NgModule({
    imports:        [ AlertModule.forRoot(), BrowserModule ],
    declarations:   [ ApplicationComponent, CustomerItemComponent,
                        NavbarComponent, FooterComponent,
                        SearchComponent, CarouselComponent],
    providers:      [ CustomerService],
    bootstrap:      [ ApplicationComponent ]
})
export class AppModule { }
