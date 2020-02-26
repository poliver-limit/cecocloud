import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class RegistreComercial extends RestapiResource {}

@Injectable()
export class RegistresComercialsService extends BngRestapiService<RegistreComercial> {

    constructor( injector: Injector ) {
        super( RegistreComercial, 'registreComercial', injector, 'fact' );
    }

}