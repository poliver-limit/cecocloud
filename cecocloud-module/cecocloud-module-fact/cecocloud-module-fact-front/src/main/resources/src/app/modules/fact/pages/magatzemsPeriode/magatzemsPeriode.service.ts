import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class MagatzemPeriode extends RestapiResource {}

@Injectable()
export class MagatzemsPeriodeService extends BngRestapiService<MagatzemPeriode> {

    constructor( injector: Injector ) {
        super( MagatzemPeriode, 'magatzemPeriode', injector, 'fact' );
    }

}