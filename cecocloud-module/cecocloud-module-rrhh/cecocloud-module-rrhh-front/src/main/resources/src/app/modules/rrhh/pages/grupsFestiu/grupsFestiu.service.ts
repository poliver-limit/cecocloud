import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class GrupFestiu extends Resource {}

@Injectable()
export class GrupsFestiuService extends BngRestapiService<GrupFestiu> {

    constructor( injector: Injector ) {
        super( GrupFestiu, 'grupFestiu', injector, 'rrhh' );
    }

}