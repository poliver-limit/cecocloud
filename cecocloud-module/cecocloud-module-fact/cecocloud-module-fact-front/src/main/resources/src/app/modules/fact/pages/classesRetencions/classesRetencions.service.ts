import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ClasseRetencio extends RestapiResource {}

@Injectable()
export class ClassesRetencionsService extends BngRestapiService<ClasseRetencio> {

    constructor( injector: Injector ) {
        super( ClasseRetencio, 'classeRetencio', injector, 'fact' );
    }

}