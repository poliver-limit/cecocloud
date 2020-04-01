import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Torn extends RestapiResource {}

@Injectable()
export class TornsService extends BngRestapiService<Torn> {

    constructor( injector: Injector ) {
        super( Torn, 'torn', injector, 'rrhh' );
    }

}