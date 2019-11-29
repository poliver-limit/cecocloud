import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class SerieIntracomunitaria extends Resource {}

@Injectable()
export class SeriesIntracomunitariaService extends BngRestapiService<SerieIntracomunitaria> {

    constructor( injector: Injector ) {
        super( SerieIntracomunitaria, 'serieIntracomunitaria', injector, 'fact' );
    }

}