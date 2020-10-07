import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class EstudiProjecte extends RestapiResource {}

@Injectable()
export class EstudisProjecteService extends BngRestapiService<EstudiProjecte> {

    constructor( injector: Injector ) {
        super( EstudiProjecte, 'estudiProjecte', injector, 'fact' );
    }

}