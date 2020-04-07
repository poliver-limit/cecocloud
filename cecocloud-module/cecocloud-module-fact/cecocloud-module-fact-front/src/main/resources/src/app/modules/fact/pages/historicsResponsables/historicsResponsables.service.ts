import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class HistoricResponsable extends RestapiResource {}

@Injectable()
export class HistoricsResponsablesService extends BngRestapiService<HistoricResponsable> {

    constructor( injector: Injector ) {
        super( HistoricResponsable, 'historicResponsable', injector, 'fact' );
    }

}