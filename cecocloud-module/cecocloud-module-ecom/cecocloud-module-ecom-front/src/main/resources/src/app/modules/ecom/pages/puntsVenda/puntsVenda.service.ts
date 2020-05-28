import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class PuntVenda extends RestapiResource {}

@Injectable()
export class PuntsVendaService extends BngRestapiService<PuntVenda> {

    constructor( injector: Injector ) {
        super( PuntVenda, 'puntVenda', injector, 'ecom' );
    }

}