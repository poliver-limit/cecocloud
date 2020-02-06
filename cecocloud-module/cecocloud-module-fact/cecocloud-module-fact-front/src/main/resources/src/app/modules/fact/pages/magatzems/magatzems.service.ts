import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Magatzem extends Resource {}

@Injectable()
export class MagatzemsService extends BngRestapiService<Magatzem> {

    constructor( injector: Injector ) {
        super( Magatzem, 'magatzem', injector, 'fact' );
    }

}