import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiPermissionService } from 'base-angular';

export class Permission extends Resource { }

@Injectable()
export class IdentificadorsPermissionService extends BngRestapiPermissionService {

    constructor(injector: Injector) {
        super('identificador', injector);
    }

}