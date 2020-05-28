import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class AlbaraLinia extends RestapiResource {}

@Injectable()
export class AlbaransLiniaService extends BngRestapiService<AlbaraLinia> {

    constructor( injector: Injector ) {
        super( AlbaraLinia, 'albaraLinia', injector, 'ecom' );
    }

}