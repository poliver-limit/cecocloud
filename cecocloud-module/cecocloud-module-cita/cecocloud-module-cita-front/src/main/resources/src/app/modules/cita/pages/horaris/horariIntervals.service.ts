import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class HorariInterval extends RestapiResource {}

@Injectable()
export class HorariIntervalsService extends BngRestapiService<HorariInterval> {

    constructor( injector: Injector ) {
        super( HorariInterval, 'horariInterval', injector, 'cita' );
    }

}