import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Ubicacio extends RestapiResource {}

@Injectable()
export class UbicacionsService extends BngRestapiService<Ubicacio> {

    constructor( injector: Injector ) {
        super( Ubicacio, 'ubicacio', injector, 'fact' );
    }

}