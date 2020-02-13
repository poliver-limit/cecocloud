import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class GrupFestiu extends RestapiResource {}

@Injectable()
export class GrupsFestiuService extends BngRestapiService<GrupFestiu> {

    constructor( injector: Injector ) {
        super( GrupFestiu, 'grupFestiu', injector, 'rrhh' );
    }

}