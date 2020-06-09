import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Bestreta extends RestapiResource {}

@Injectable()
export class BestretesService extends BngRestapiService<Bestreta> {

    constructor( injector: Injector ) {
        super( Bestreta, 'bestreta', injector, 'ecom' );
    }

}