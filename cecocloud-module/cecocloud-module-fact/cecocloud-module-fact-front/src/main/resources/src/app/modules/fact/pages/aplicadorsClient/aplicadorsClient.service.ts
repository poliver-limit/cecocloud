import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class AplicadorClient extends Resource {}

@Injectable()
export class AplicadorsClientService extends BngRestapiService<AplicadorClient> {

    constructor( injector: Injector ) {
        super( AplicadorClient, 'aplicadorClient', injector, 'fact' );
    }

}