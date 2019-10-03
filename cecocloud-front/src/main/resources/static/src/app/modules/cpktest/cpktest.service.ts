import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiService } from '../../shared/restapi/restapi.service';

export class Cpktest extends Resource {}

@Injectable()
export class CpktestService extends RestapiService<Cpktest> {

    constructor( injector: Injector ) {
        super( Cpktest, 'compositePkTest', injector );
    }

}