import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Rol extends RestapiResource {}

@Injectable()
export class RolsService extends BngRestapiService<Rol> {

    constructor( injector: Injector ) {
        super( Rol, 'rol', injector );
    }

}