import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Operari extends RestapiResource {}

@Injectable()
export class OperarisService extends BngRestapiService<Operari> {

    constructor( injector: Injector ) {
        super( Operari, 'operari', injector, 'marc' );
    }

}