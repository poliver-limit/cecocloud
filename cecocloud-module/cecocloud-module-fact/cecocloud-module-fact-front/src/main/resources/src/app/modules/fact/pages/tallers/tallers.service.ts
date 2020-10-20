import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Taller extends RestapiResource {}

@Injectable()
export class TallersService extends BngRestapiService<Taller> {

    constructor( injector: Injector ) {
        super( Taller, 'taller', injector, 'fact' );
    }

}