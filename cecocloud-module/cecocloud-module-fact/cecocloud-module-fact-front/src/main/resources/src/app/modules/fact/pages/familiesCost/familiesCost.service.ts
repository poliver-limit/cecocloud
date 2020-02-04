import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class FamiliaCost extends Resource {}

@Injectable()
export class FamiliesCostService extends BngRestapiService<FamiliaCost> {

    constructor( injector: Injector ) {
        super( FamiliaCost, 'familiaCost', injector, 'fact' );
    }

}