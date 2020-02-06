import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Banc extends Resource {}

@Injectable()
export class BancsService extends BngRestapiService<Banc> {

    constructor( injector: Injector ) {
        super( Banc, 'banc', injector, 'fact' );
    }

}