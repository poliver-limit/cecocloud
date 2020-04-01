import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class CercadorProjecte extends RestapiResource {}

@Injectable()
export class CercadorProjectesService extends BngRestapiService<CercadorProjecte> {

    constructor( injector: Injector ) {
        super( CercadorProjecte, 'projecte', injector, 'fact' );
    }

}