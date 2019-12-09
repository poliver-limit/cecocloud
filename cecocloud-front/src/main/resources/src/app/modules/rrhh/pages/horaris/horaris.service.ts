import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Horari extends Resource {}

@Injectable()
export class HorarisService extends BngRestapiService<Horari> {

    constructor( injector: Injector ) {
        super( Horari, 'horari', injector, 'rrhh' );
    }

}