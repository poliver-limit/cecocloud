import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Usuari extends RestapiResource {}

@Injectable()
export class UsuariService extends BngRestapiService<Usuari> {

    constructor( injector: Injector ) {
        super( Usuari, 'usuari', injector );
    }

}