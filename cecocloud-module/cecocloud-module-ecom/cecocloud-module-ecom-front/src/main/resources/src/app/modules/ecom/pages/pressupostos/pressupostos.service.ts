import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Pressupost extends RestapiResource {}

@Injectable()
export class PressupostosService extends BngRestapiService<Pressupost> {

    constructor( injector: Injector ) {
        super( Pressupost, 'pressupost', injector, 'ecom' );
    }

}