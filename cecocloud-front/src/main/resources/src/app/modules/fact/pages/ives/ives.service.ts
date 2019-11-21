import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Iva extends Resource {}

@Injectable()
export class IvesService extends BngRestapiService<Iva> {

    constructor( injector: Injector ) {
        super( Iva, 'iva', injector, 'fact' );
    }

}