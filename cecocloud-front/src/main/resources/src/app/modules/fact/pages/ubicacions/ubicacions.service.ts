import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Ubicacio extends Resource {}

@Injectable()
export class UbicacionsService extends BngRestapiService<Ubicacio> {

    constructor( injector: Injector ) {
        super( Ubicacio, 'ubicacio', injector, 'fact' );
    }

}