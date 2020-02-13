import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class DepartamentClient extends RestapiResource {}

@Injectable()
export class DepartamentsClientService extends BngRestapiService<DepartamentClient> {

    constructor( injector: Injector ) {
        super( DepartamentClient, 'departamentClient', injector, 'fact' );
    }

}