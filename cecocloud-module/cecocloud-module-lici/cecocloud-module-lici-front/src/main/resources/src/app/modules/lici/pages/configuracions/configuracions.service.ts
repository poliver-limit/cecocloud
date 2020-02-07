import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Configuracio extends Resource {}

@Injectable()
export class ConfiguracionsService extends BngRestapiService<Configuracio> {

    constructor( injector: Injector ) {
        super( Configuracio, 'configuracio', injector, 'lici' );
    }

}