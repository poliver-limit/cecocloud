import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Rappel extends RestapiResource {}

@Injectable()
export class RappelsService extends BngRestapiService<Rappel> {

    constructor( injector: Injector ) {
        super( Rappel, 'rappel', injector, 'fact' );
    }

}