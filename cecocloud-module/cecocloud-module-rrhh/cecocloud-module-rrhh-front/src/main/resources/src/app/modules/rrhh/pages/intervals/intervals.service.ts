import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Interval extends RestapiResource {}

@Injectable()
export class IntervalsService extends BngRestapiService<Interval> {

    constructor( injector: Injector ) {
        super( Interval, 'interval', injector, 'rrhh' );
    }

}