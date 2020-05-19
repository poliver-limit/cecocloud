import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Divisa extends RestapiResource {}

@Injectable()
export class DivisesService extends BngRestapiService<Divisa> {

    constructor( injector: Injector ) {
        super( Divisa, 'divisa', injector, 'ecom' );
    }

}