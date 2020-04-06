import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ProjecteTarifaProveidor extends RestapiResource {}

@Injectable()
export class ProjectesTarifaProveidorService extends BngRestapiService<ProjecteTarifaProveidor> {

    constructor( injector: Injector ) {
        super( ProjecteTarifaProveidor, 'projecteTarifaProveidor', injector, 'fact' );
    }

}