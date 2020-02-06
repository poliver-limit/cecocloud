import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Tarifa extends Resource {}

@Injectable()
export class TarifesService extends BngRestapiService<Tarifa> {

    constructor( injector: Injector ) {
        super( Tarifa, 'tarifa', injector, 'fact' );
    }

}