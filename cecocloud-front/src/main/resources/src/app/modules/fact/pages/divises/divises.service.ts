import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Divisa extends Resource {}

@Injectable()
export class DivisesService extends BngRestapiService<Divisa> {

    constructor( injector: Injector ) {
        super( Divisa, 'divisa', injector, 'fact' );
    }

}