import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class IdentificadorRrhh extends Resource {}

@Injectable()
export class IdentificadorsRrhhService extends BngRestapiService<IdentificadorRrhh> {

    constructor( injector: Injector ) {
        super( IdentificadorRrhh, 'identificadorRrhh', injector, 'rrhh' );
    }

}