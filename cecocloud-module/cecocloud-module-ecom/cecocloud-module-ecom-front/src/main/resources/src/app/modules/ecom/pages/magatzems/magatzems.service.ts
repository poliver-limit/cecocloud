import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Magatzem extends RestapiResource {}

@Injectable()
export class MagatzemsService extends BngRestapiService<Magatzem> {

    constructor( injector: Injector ) {
        super( Magatzem, 'magatzem', injector, 'ecom' );
    }

}