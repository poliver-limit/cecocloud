import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Producte extends RestapiResource {}

@Injectable()
export class ProductesService extends BngRestapiService<Producte> {

    constructor( injector: Injector ) {
        super( Producte, 'producte', injector, 'fact' );
    }

}