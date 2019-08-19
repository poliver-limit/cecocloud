import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiService } from '../../shared/restapi/restapi.service';

export class Marcatge extends Resource {}

@Injectable()
export class MarcatgesService extends RestapiService<Marcatge> {

    constructor( injector: Injector ) {
        super( Marcatge, 'marcatge', injector );
    }

}