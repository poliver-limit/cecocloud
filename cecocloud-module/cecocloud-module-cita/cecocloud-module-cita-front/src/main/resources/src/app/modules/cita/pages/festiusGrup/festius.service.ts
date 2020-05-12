import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Festiu extends RestapiResource {}

@Injectable()
export class FestiusService extends BngRestapiService<Festiu> {

    constructor( injector: Injector ) {
        super( Festiu, 'festiu', injector, 'cita' );
    }

}