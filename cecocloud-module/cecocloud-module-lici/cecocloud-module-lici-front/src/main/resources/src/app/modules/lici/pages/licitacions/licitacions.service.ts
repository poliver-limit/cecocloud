import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Licitacio extends Resource {}

@Injectable()
export class LicitacionsService extends BngRestapiService<Licitacio> {

    constructor( injector: Injector ) {
        super( Licitacio, 'licitacio', injector, 'lici' );
    }

}