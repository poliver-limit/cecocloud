import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class FestiuGrup extends RestapiResource {}

@Injectable()
export class FestiusGrupService extends BngRestapiService<FestiuGrup> {

    constructor( injector: Injector ) {
        super( FestiuGrup, 'festiuGrup', injector, 'cita' );
    }

}