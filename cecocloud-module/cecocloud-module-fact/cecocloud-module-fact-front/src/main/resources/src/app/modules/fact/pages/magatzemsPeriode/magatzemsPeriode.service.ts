import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class MagatzemPeriode extends Resource {}

@Injectable()
export class MagatzemsPeriodeService extends BngRestapiService<MagatzemPeriode> {

    constructor( injector: Injector ) {
        super( MagatzemPeriode, 'magatzemPeriode', injector, 'fact' );
    }

}