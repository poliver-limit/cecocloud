import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiService } from '../../shared/restapi/restapi.service';

export class GenericResource extends Resource {}

@Injectable()
export class RestapiGenericService extends RestapiService<GenericResource> {

    constructor( injector: Injector ) {
        super( GenericResource, undefined, injector );
    }

}