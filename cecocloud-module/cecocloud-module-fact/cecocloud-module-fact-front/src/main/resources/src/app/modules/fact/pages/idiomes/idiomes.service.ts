import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Idioma extends Resource {}

@Injectable()
export class IdiomesService extends BngRestapiService<Idioma> {

    constructor( injector: Injector ) {
        super( Idioma, 'idioma', injector, 'fact' );
    }

}