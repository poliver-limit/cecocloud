import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Idioma extends RestapiResource {}

@Injectable()
export class IdiomesService extends BngRestapiService<Idioma> {

    constructor( injector: Injector ) {
        super( Idioma, 'idioma', injector, 'fact' );
    }

}