import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class OficinaBancaria extends RestapiResource {}

@Injectable()
export class OficinesBancariesService extends BngRestapiService<OficinaBancaria> {

    constructor( injector: Injector ) {
        super( OficinaBancaria, 'oficinaBancaria', injector, 'fact' );
    }

}