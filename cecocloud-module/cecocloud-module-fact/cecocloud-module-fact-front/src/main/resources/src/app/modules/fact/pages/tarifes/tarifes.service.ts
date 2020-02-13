import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Tarifa extends RestapiResource {}

@Injectable()
export class TarifesService extends BngRestapiService<Tarifa> {

    constructor( injector: Injector ) {
        super( Tarifa, 'tarifa', injector, 'fact' );
    }

}