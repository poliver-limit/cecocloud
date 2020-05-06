import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Iva extends RestapiResource {}

@Injectable()
export class IvesService extends BngRestapiService<Iva> {

    constructor( injector: Injector ) {
        super( Iva, 'iva', injector, 'ecom' );
    }

}