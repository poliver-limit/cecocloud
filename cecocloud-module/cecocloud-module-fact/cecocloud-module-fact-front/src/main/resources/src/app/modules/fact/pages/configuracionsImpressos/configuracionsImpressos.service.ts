import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ConfiguracioImpressos extends RestapiResource {}

@Injectable()
export class ConfiguracionsImpressosService extends BngRestapiService<ConfiguracioImpressos> {

    constructor( injector: Injector ) {
        super( ConfiguracioImpressos, 'configuracioImpressos', injector, 'fact' );
    }

}