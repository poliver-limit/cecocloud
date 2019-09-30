import { Injector } from '@angular/core';
import { Resource } from 'angular4-hal';

import { RestapiService } from './restapi.service';

export class Permission extends Resource {}

export class RestapiPermissionService extends RestapiService<Permission> {

    private permissionResourceId: any;

    protected getProfileUrl( resourceName: string ): string {
        return '/profiles/' + resourceName + '/$$$/permission';
    }

    public setPermissionResourceId( permissionResourceId: any ) {
        this.permissionResourceId = permissionResourceId;
    }
    protected getPermissionResourceId(): any {
        return this.permissionResourceId;
    }

    constructor(
        resourceName: string,
        injector: Injector ) {
        super(Permission, resourceName, injector);
    }

}