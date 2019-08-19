import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiService } from '../../shared/restapi/restapi.service';

export class Operari extends Resource {}

@Injectable()
export class OperarisService extends RestapiService<Operari> {

    constructor( injector: Injector ) {
        super( Operari, 'operari', injector );
    }

}