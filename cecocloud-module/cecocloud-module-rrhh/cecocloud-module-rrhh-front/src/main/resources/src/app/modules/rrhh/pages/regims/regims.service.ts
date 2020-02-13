import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Regim extends RestapiResource {}

@Injectable()
export class RegimsService extends BngRestapiService<Regim> {

    constructor( injector: Injector ) {
        super( Regim, 'regim', injector, 'rrhh' );
    }

}