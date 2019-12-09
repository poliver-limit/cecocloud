import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusDia extends Resource {}

@Injectable()
export class TipusDiesService extends BngRestapiService<TipusDia> {

    constructor( injector: Injector ) {
        super( TipusDia, 'tipusDia', injector, 'rrhh' );
    }

}