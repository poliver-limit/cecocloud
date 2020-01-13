import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusComissio extends Resource {}

@Injectable()
export class TipusComissionsService extends BngRestapiService<TipusComissio> {

    constructor( injector: Injector ) {
        super( TipusComissio, 'tipusComissio', injector, 'fact' );
    }

}