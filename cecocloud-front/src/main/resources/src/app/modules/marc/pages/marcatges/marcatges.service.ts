import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Marcatge extends Resource {}

@Injectable()
export class MarcatgesService extends BngRestapiService<Marcatge> {

    constructor( injector: Injector ) {
        super( Marcatge, 'marcatge', injector, 'marc' );
    }

}