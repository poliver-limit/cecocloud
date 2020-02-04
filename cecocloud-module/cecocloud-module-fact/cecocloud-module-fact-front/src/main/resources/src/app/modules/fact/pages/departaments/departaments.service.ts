import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Departament extends Resource {}

@Injectable()
export class DepartamentsService extends BngRestapiService<Departament> {

    constructor( injector: Injector ) {
        super( Departament, 'departament', injector, 'fact' );
    }

}