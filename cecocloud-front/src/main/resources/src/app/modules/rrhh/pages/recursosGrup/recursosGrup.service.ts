import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class RecursGrup extends Resource {}

@Injectable()
export class RecursosGrupService extends BngRestapiService<RecursGrup> {

    constructor( injector: Injector ) {
        super( RecursGrup, 'recursGrup', injector, 'rrhh' );
    }

}