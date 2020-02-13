import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Calendari extends RestapiResource {}

@Injectable()
export class CalendarisService extends BngRestapiService<Calendari> {

    constructor( injector: Injector ) {
        super( Calendari, 'calendari', injector, 'rrhh' );
    }

}