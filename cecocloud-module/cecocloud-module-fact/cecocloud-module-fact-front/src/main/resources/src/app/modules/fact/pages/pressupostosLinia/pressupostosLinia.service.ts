import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class PressupostLinia extends RestapiResource {}

@Injectable()
export class PressupostosLiniaService extends BngRestapiService<PressupostLinia> {

    constructor( injector: Injector ) {
        super( PressupostLinia, 'pressupostLinia', injector, 'fact' );
    }

}