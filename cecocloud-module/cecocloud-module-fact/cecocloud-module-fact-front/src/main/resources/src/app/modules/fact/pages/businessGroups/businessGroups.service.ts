import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class BusinessGroup extends RestapiResource {}

@Injectable()
export class BusinessGroupsService extends BngRestapiService<BusinessGroup> {

    constructor( injector: Injector ) {
        super( BusinessGroup, 'businessGroup', injector, 'fact' );
    }

}