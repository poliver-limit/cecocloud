import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Transportista extends RestapiResource {}

@Injectable()
export class TransportistesService extends BngRestapiService<Transportista> {

    constructor( injector: Injector ) {
        super( Transportista, 'transportista', injector, 'ecom' );
    }

}