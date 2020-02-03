import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Calendari extends Resource {}

@Injectable()
export class CalendarisService extends BngRestapiService<Calendari> {

    constructor( injector: Injector ) {
        super( Calendari, 'calendari', injector, 'rrhh' );
    }

}