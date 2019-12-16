import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ZonaFact extends Resource {}

@Injectable()
export class ZonesFactService extends BngRestapiService<ZonaFact> {

    constructor( injector: Injector ) {
        super( ZonaFact, 'zonaFact', injector, 'fact' );
    }

}