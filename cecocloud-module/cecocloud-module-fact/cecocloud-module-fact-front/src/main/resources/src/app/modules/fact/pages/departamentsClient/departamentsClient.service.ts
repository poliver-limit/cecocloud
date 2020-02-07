import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class DepartamentClient extends Resource {}

@Injectable()
export class DepartamentsClientService extends BngRestapiService<DepartamentClient> {

    constructor( injector: Injector ) {
        super( DepartamentClient, 'departamentClient', injector, 'fact' );
    }

}