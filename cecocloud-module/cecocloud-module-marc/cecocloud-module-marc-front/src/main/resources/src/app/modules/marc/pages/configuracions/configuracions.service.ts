import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Configuracio extends RestapiResource {}

@Injectable()
export class ConfiguracionsService extends BngRestapiService<Configuracio> {

    constructor( injector: Injector ) {
        super( Configuracio, 'configuracio', injector, 'marc' );
    }

}