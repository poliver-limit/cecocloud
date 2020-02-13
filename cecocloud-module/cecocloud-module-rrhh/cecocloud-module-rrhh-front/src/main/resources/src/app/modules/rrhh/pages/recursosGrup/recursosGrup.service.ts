import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class RecursGrup extends RestapiResource {}

@Injectable()
export class RecursosGrupService extends BngRestapiService<RecursGrup> {

    constructor( injector: Injector ) {
        super( RecursGrup, 'recursGrup', injector, 'rrhh' );
    }

}