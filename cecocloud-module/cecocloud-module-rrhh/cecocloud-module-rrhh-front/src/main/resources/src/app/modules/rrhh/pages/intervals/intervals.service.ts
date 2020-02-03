import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Interval extends Resource {}

@Injectable()
export class IntervalsService extends BngRestapiService<Interval> {

    constructor( injector: Injector ) {
        super( Interval, 'interval', injector, 'rrhh' );
    }

}