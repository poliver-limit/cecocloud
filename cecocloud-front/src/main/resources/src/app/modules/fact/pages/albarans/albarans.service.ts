import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Albara extends Resource {}

@Injectable()
export class AlbaransService extends BngRestapiService<Albara> {

    constructor( injector: Injector ) {
        super( Albara, 'albara', injector, 'fact' );
    }

}