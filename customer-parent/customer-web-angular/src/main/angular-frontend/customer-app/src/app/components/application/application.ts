import {Component, ViewEncapsulation} from '@angular/core';

@Component({
    selector: 'customer-application', // <1>
    templateUrl: 'application.html',
    styleUrls: ['application.css'],
    encapsulation:ViewEncapsulation.None
})

export default class ApplicationComponent {}
