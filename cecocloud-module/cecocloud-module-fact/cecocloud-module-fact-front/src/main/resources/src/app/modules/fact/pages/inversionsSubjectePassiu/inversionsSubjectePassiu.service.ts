import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class InversioSubjectePassiu extends RestapiResource {}

@Injectable()
export class InversionsSubjectePassiuService extends BngRestapiService<InversioSubjectePassiu> {

    constructor( injector: Injector ) {
        super( InversioSubjectePassiu, 'inversioSubjectePassiu', injector, 'fact' );
    }

}