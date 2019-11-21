import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class RegimIva extends Resource {}

@Injectable()
export class RegimsIvaService extends BngRestapiService<RegimIva> {

    constructor( injector: Injector ) {
        super( RegimIva, 'regimIva', injector, 'fact' );
    }

}