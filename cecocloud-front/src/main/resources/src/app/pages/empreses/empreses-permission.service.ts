import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiPermissionService } from 'base-angular';

export class Permission extends Resource {}

@Injectable()
export class EmpresesPermissionService extends BngRestapiPermissionService {

    constructor( injector: Injector ) {
        super( 'empresa', injector );
    }

}