import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Parameter extends RestapiResource {}

@Injectable()
export class ParametersService extends BngRestapiService<Parameter> {

    constructor( injector: Injector ) {
        super( Parameter, 'parameter', injector, 'fact' );
    }

}