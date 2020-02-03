import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class AreaNegoci extends Resource {}

@Injectable()
export class AreaNegocisService extends BngRestapiService<AreaNegoci> {

    constructor( injector: Injector ) {
        super( AreaNegoci, 'areaNegoci', injector, 'fact' );
    }

}