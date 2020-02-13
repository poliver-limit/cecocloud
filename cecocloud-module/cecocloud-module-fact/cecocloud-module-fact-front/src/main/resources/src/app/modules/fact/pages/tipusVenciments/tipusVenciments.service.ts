import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class TipusVenciment extends RestapiResource {}

@Injectable()
export class TipusVencimentsService extends BngRestapiService<TipusVenciment> {

    constructor( injector: Injector ) {
        super( TipusVenciment, 'tipusVenciment', injector, 'fact' );
    }

}