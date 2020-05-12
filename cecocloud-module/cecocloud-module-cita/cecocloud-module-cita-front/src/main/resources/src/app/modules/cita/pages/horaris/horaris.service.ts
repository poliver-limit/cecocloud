import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Horari extends RestapiResource {}

@Injectable()
export class HorarisService extends BngRestapiService<Horari> {

    constructor( injector: Injector ) {
        super( Horari, 'horari', injector, 'cita' );
    }

}