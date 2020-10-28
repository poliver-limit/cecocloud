import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Expedient extends RestapiResource {}

@Injectable()
export class ExpedientsService extends BngRestapiService<Expedient> {

    constructor( injector: Injector ) {
        super( Expedient, 'expedient', injector, 'fact' );
    }

}