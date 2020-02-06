import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class FamiliaClient extends Resource {}

@Injectable()
export class FamiliesClientService extends BngRestapiService<FamiliaClient> {

    constructor( injector: Injector ) {
        super( FamiliaClient, 'familiaClient', injector, 'fact' );
    }

}