import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Empresa extends RestapiResource {}

@Injectable()
export class EmpresesService extends BngRestapiService<Empresa> {

    constructor( injector: Injector ) {
        super( Empresa, 'empresa', injector );
    }

}