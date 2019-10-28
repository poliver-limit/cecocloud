import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from '@programari-limit/bang';

export class Usuari extends Resource {}

@Injectable()
export class UsuarisService extends BngRestapiService<Usuari> {

    constructor( injector: Injector ) {
        super( Usuari, 'usuari', injector );
    }

}