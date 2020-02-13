import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Subvencio extends RestapiResource {}

@Injectable()
export class SubvencionsService extends BngRestapiService<Subvencio> {

    constructor( injector: Injector ) {
        super( Subvencio, 'subvencio', injector, 'fact' );
    }

}