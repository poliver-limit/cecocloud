import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ProveidorVenciment extends RestapiResource {}

@Injectable()
export class ProveidorsVencimentService extends BngRestapiService<ProveidorVenciment> {

    constructor( injector: Injector ) {
        super( ProveidorVenciment, 'proveidorVenciment', injector, 'fact' );
    }

}