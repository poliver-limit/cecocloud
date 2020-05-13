import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class PuntVendaHorari extends RestapiResource {}

@Injectable()
export class PuntVendaHorarisService extends BngRestapiService<PuntVendaHorari> {

    constructor( injector: Injector ) {
        super( PuntVendaHorari, 'puntVendaHorari', injector, 'cita' );
    }

}