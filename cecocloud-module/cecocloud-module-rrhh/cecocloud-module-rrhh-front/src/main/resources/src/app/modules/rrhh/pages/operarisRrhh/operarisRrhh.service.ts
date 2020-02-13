import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class OperariRrhh extends RestapiResource {}

@Injectable()
export class OperarisRrhhService extends BngRestapiService<OperariRrhh> {

    constructor( injector: Injector ) {
        super( OperariRrhh, 'operari', injector, 'rrhh' );
    }

}