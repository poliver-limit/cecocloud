import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ZonaRrhh extends Resource {}

@Injectable()
export class ZonesRrhhService extends BngRestapiService<ZonaRrhh> {

    constructor( injector: Injector ) {
        super( ZonaRrhh, 'zona', injector, 'rrhh' );
    }

}