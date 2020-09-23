import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class OperariEmpresaLlocFeina extends RestapiResource {}

@Injectable()
export class OperariEmpresaLlocFeinaService extends BngRestapiService<OperariEmpresaLlocFeina> {

    constructor( injector: Injector ) {
        super( OperariEmpresaLlocFeina, 'operariEmpresaLlocFeina', injector, 'marc' );
    }

}