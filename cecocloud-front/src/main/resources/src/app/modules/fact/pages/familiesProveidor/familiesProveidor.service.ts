import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class FamiliaProveidor extends Resource {}

@Injectable()
export class FamiliesProveidorService extends BngRestapiService<FamiliaProveidor> {

    constructor( injector: Injector ) {
        super( FamiliaProveidor, 'familiaProveidor', injector, 'fact' );
    }

}