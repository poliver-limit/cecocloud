import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Aplicador extends Resource {}

@Injectable()
export class AplicadorsService extends BngRestapiService<Aplicador> {

    constructor( injector: Injector ) {
        super( Aplicador, 'aplicador', injector, 'fact' );
    }

}