import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Capitol extends RestapiResource {}

@Injectable()
export class CapitolsService extends BngRestapiService<Capitol> {

    constructor( injector: Injector ) {
        super( Capitol, 'capitol', injector, 'fact' );
    }

}