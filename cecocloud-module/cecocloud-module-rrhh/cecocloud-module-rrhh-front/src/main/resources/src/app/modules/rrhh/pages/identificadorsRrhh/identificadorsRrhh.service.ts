import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class IdentificadorRrhh extends RestapiResource {}

@Injectable()
export class IdentificadorsRrhhService extends BngRestapiService<IdentificadorRrhh> {

    constructor( injector: Injector ) {
        super( IdentificadorRrhh, 'identificadorRrhh', injector, 'rrhh' );
    }

}