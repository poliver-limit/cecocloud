import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class SituacioInicial extends Resource {}

@Injectable()
export class SituacionsInicialService extends BngRestapiService<SituacioInicial> {

    constructor( injector: Injector ) {
        super( SituacioInicial, 'situacioInicial', injector, 'fact' );
    }

}