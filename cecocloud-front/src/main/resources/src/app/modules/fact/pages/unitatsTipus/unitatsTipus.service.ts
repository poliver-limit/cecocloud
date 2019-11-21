import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class UnitatTipus extends Resource {}

@Injectable()
export class UnitatsTipusService extends BngRestapiService<UnitatTipus> {

    constructor( injector: Injector ) {
        super( UnitatTipus, 'unitatTipus', injector, 'fact' );
    }

}