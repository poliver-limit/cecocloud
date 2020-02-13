import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Perfil extends RestapiResource {}

@Injectable()
export class PerfilService extends BngRestapiService<Perfil> {

    constructor( injector: Injector ) {
        super( Perfil, 'perfil', injector );
    }

}