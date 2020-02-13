import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Marcatge extends RestapiResource {}

@Injectable()
export class MarcatgesService extends BngRestapiService<Marcatge> {

    constructor( injector: Injector ) {
        super( Marcatge, 'marcatge', injector, 'marc' );
    }

}