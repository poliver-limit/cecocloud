import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Funcionalitat extends RestapiResource {}

@Injectable()
export class FuncionalitatsService extends BngRestapiService<Funcionalitat> {

    constructor( injector: Injector ) {
        super( Funcionalitat, 'funcionalitat', injector );
    }

}