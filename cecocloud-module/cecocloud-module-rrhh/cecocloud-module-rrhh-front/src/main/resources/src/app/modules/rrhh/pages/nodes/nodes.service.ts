import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Node extends Resource {}

@Injectable()
export class NodesService extends BngRestapiService<Node> {

    constructor( injector: Injector ) {
        super( Node, 'node', injector, 'rrhh' );
    }

}