import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Licitacio extends RestapiResource {}

@Injectable()
export class LicitacionsService extends BngRestapiService<Licitacio> {

    constructor( injector: Injector ) {
        super( Licitacio, 'licitacio', injector, 'lici' );
    }

}