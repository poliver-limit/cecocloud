import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Venciment extends RestapiResource {}

@Injectable()
export class VencimentsService extends BngRestapiService<Venciment> {

    constructor( injector: Injector ) {
        super( Venciment, 'venciment', injector, 'ecom' );
    }

}