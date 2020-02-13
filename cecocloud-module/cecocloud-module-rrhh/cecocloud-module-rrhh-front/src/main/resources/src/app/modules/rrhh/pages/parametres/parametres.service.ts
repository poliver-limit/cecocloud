import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Parametre extends RestapiResource {}

@Injectable()
export class ParametresService extends BngRestapiService<Parametre> {

    constructor( injector: Injector ) {
        super( Parametre, 'parametre', injector, 'rrhh' );
    }

}