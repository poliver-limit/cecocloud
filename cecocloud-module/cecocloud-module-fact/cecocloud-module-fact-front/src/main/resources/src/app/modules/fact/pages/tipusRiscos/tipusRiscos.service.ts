import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusRisc extends Resource {}

@Injectable()
export class TipusRiscosService extends BngRestapiService<TipusRisc> {

    constructor( injector: Injector ) {
        super( TipusRisc, 'tipusRisc', injector, 'fact' );
    }

}