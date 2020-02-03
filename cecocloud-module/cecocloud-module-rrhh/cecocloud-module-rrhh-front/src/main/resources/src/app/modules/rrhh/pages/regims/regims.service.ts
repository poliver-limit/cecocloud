import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Regim extends Resource {}

@Injectable()
export class RegimsService extends BngRestapiService<Regim> {

    constructor( injector: Injector ) {
        super( Regim, 'regim', injector, 'rrhh' );
    }

}