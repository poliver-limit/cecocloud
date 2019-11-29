import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TarifaDescompte extends Resource {}

@Injectable()
export class TarifesDescompteService extends BngRestapiService<TarifaDescompte> {

    constructor( injector: Injector ) {
        super( TarifaDescompte, 'tarifaDescompte', injector, 'fact' );
    }

}