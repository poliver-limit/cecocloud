import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class NaturalesaPagamentCobrament extends RestapiResource {}

@Injectable()
export class NaturalesesPagamentCobramentService extends BngRestapiService<NaturalesaPagamentCobrament> {

    constructor( injector: Injector ) {
        super( NaturalesaPagamentCobrament, 'naturalesaPagamentCobrament', injector, 'fact' );
    }

}