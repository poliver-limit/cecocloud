import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class TipusVenciment extends Resource {}

@Injectable()
export class TipusVencimentsService extends BngRestapiService<TipusVenciment> {

    constructor( injector: Injector ) {
        super( TipusVenciment, 'tipusVenciment', injector, 'fact' );
    }

}