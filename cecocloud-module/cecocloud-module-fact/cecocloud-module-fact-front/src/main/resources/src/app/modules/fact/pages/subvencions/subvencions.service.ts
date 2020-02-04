import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Subvencio extends Resource {}

@Injectable()
export class SubvencionsService extends BngRestapiService<Subvencio> {

    constructor( injector: Injector ) {
        super( Subvencio, 'subvencio', injector, 'fact' );
    }

}