import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Banc extends RestapiResource {}

@Injectable()
export class BancsService extends BngRestapiService<Banc> {

    constructor( injector: Injector ) {
        super( Banc, 'banc', injector, 'fact' );
    }

}