import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class RegimIva extends RestapiResource {}

@Injectable()
export class RegimsIvaService extends BngRestapiService<RegimIva> {

    constructor( injector: Injector ) {
        super( RegimIva, 'regimIva', injector, 'fact' );
    }

}