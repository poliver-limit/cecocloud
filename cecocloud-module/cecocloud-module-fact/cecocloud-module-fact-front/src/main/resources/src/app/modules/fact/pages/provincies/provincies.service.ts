import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Provincia extends RestapiResource {}

@Injectable()
export class ProvinciesService extends BngRestapiService<Provincia> {

    constructor( injector: Injector ) {
        super( Provincia, 'provincia', injector, 'fact' );
    }

}