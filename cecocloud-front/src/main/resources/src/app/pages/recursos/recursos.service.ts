import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Recurs extends Resource {}

@Injectable()
export class RecursosService extends BngRestapiService<Recurs> {

    constructor( injector: Injector ) {
        super( Recurs, 'recurs', injector );
    }

}