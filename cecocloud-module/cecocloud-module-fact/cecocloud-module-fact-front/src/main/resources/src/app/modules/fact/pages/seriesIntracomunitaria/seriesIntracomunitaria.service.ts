import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class SerieIntracomunitaria extends RestapiResource {}

@Injectable()
export class SeriesIntracomunitariaService extends BngRestapiService<SerieIntracomunitaria> {

    constructor( injector: Injector ) {
        super( SerieIntracomunitaria, 'serieIntracomunitaria', injector, 'fact' );
    }

}