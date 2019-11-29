import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusComisio extends Resource {}

@Injectable()
export class TipusComisionsService extends BngRestapiService<TipusComisio> {

    constructor( injector: Injector ) {
        super( TipusComisio, 'tipusComisio', injector, 'fact' );
    }

}