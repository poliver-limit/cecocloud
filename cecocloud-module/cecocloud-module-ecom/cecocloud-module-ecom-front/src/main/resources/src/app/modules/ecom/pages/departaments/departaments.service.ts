import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Departament extends RestapiResource {}

@Injectable()
export class DepartamentsService extends BngRestapiService<Departament> {

    constructor( injector: Injector ) {
        super( Departament, 'departament', injector, 'ecom' );
    }

}