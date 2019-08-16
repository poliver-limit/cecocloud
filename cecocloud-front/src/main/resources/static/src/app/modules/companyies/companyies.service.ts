import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiService } from '../../shared/restapi/restapi.service';

export class Companyia extends Resource {}

@Injectable()
export class CompanyiesService extends RestapiService<Companyia> {

    constructor( injector: Injector ) {
        super( Companyia, 'companyia', injector );
    }

}