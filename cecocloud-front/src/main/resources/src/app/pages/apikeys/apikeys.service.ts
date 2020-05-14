import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Apikey extends RestapiResource {}

@Injectable()
export class ApikeysService extends BngRestapiService<Apikey> {

    constructor( injector: Injector ) {
        super( Apikey, 'apiKey', injector );
    }

}