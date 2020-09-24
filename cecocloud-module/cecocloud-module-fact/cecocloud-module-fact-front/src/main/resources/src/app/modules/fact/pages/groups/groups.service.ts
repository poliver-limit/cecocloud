import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Group extends RestapiResource {}

@Injectable()
export class GroupsService extends BngRestapiService<Group> {

    constructor( injector: Injector ) {
        super( Group, 'group', injector, 'fact' );
    }

}