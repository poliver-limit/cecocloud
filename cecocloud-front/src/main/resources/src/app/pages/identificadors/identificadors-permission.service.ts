import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiPermissionService } from 'base-angular';

export class Permission extends RestapiResource { }

@Injectable()
export class IdentificadorsPermissionService extends BngRestapiPermissionService {

    constructor(injector: Injector) {
        super('identificador', injector);
    }

}