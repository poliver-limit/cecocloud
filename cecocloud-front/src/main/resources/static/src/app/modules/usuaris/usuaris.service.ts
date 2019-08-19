import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiService } from '../../shared/restapi/restapi.service';

export class Usuari extends Resource {}

@Injectable()
export class UsuarisService extends RestapiService<Usuari> {

    constructor( injector: Injector ) {
        super( Usuari, 'usuari', injector );
    }

}