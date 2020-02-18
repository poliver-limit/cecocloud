import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Organitzacio extends RestapiResource {}

@Injectable()
export class OrganitzacionsService extends BngRestapiService<Organitzacio> {

    constructor( injector: Injector ) {
        super( Organitzacio, 'organitzacio', injector, 'fact' );
    }

}