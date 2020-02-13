import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class SeccioGrup extends RestapiResource {}

@Injectable()
export class SeccionsGrupService extends BngRestapiService<SeccioGrup> {

    constructor( injector: Injector ) {
        super( SeccioGrup, 'seccioGrup', injector, 'rrhh' );
    }

}