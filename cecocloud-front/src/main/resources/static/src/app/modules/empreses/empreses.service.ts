import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiService } from '../../shared/restapi/restapi.service';

export class Empresa extends Resource {}

@Injectable()
export class EmpresesService extends RestapiService<Empresa> {

    constructor( injector: Injector ) {
        super( Empresa, 'empresa', injector );
    }

}