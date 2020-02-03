import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Parametre extends Resource {}

@Injectable()
export class ParametresService extends BngRestapiService<Parametre> {

    constructor( injector: Injector ) {
        super( Parametre, 'parametre', injector, 'rrhh' );
    }

}