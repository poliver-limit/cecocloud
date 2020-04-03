import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class AgrupacioFuncionalitat extends RestapiResource {}

@Injectable()
export class AgrupacionsFuncionalitatsService extends BngRestapiService<AgrupacioFuncionalitat> {

    constructor( injector: Injector ) {
        super( AgrupacioFuncionalitat, 'agrupacioFuncionalitat', injector );
    }

}