import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Agrupacio extends RestapiResource {}

@Injectable()
export class AgrupacionsService extends BngRestapiService<Agrupacio> {

    constructor( injector: Injector ) {
        super( Agrupacio, 'agrupacio', injector );
    }

}