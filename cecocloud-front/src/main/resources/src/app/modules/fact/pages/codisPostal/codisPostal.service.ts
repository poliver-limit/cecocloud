import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class CodiPostal extends Resource {}

@Injectable()
export class CodisPostalService extends BngRestapiService<CodiPostal> {

    constructor( injector: Injector ) {
        super( CodiPostal, 'codiPostal', injector, 'fact' );
    }

}