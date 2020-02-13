import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FinalFactura extends RestapiResource {}

@Injectable()
export class FinalFacturesService extends BngRestapiService<FinalFactura> {

    constructor( injector: Injector ) {
        super( FinalFactura, 'finalFactura', injector, 'fact' );
    }

}