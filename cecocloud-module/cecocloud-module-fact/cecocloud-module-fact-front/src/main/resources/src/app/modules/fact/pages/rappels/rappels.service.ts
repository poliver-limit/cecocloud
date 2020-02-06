import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Rappel extends Resource {}

@Injectable()
export class RappelsService extends BngRestapiService<Rappel> {

    constructor( injector: Injector ) {
        super( Rappel, 'rappel', injector, 'fact' );
    }

}