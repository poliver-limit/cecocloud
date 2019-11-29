import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class SituacioComercial extends Resource {}

@Injectable()
export class SituacionsComercialService extends BngRestapiService<SituacioComercial> {

    constructor( injector: Injector ) {
        super( SituacioComercial, 'situacioComercial', injector, 'fact' );
    }

}