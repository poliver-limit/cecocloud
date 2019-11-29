import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Empresa extends Resource {}

@Injectable()
export class EmpresesService extends BngRestapiService<Empresa> {

    constructor( injector: Injector ) {
        super( Empresa, 'empresa', injector, 'fact' );
    }

}