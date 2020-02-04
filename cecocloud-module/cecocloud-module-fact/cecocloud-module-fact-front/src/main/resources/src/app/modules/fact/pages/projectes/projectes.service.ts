import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Projectes extends Resource {}

@Injectable()
export class ProjectesService extends BngRestapiService<Projectes> {

    constructor( injector: Injector ) {
        super( Projectes, 'projecte', injector, 'fact' );
    }

}