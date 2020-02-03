import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ProjecteTipus extends Resource {}

@Injectable()
export class ProjectesTipusService extends BngRestapiService<ProjecteTipus> {

    constructor( injector: Injector ) {
        super( ProjecteTipus, 'projecteTipus', injector, 'fact' );
    }

}