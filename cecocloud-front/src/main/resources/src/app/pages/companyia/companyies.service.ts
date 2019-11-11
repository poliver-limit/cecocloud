import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Companyia extends Resource {}

@Injectable()
export class CompanyiesService extends BngRestapiService<Companyia> {

    constructor( injector: Injector ) {
        super( Companyia, 'companyia', injector );
    }

}