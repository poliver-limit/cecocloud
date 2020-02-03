import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class OperariRrhh extends Resource {}

@Injectable()
export class OperarisRrhhService extends BngRestapiService<OperariRrhh> {

    constructor( injector: Injector ) {
        super( OperariRrhh, 'operari', injector, 'rrhh' );
    }

}