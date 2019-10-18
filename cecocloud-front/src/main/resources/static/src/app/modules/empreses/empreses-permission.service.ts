import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiPermissionService } from '../../shared/restapi/restapi-permission.service';

export class Permission extends Resource {}

@Injectable()
export class EmpresesPermissionService extends RestapiPermissionService {

    constructor( injector: Injector ) {
        super( 'empresa', injector );
    }

}