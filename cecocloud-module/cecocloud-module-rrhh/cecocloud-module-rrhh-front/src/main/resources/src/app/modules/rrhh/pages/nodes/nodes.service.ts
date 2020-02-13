import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Node extends RestapiResource {}

@Injectable()
export class NodesService extends BngRestapiService<Node> {

    constructor( injector: Injector ) {
        super( Node, 'node', injector, 'rrhh' );
    }

}