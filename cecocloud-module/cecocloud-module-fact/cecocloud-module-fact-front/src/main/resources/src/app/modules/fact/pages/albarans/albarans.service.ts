import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Albara extends RestapiResource {}

@Injectable()
export class AlbaransService extends BngRestapiService<Albara> {

    constructor( injector: Injector ) {
        super( Albara, 'albara', injector, 'fact' );
    }

}