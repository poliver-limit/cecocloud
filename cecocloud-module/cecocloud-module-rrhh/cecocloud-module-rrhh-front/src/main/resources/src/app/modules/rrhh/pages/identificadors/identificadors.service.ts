import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Identificador extends RestapiResource { }

@Injectable({
    providedIn: 'root'
})
export class IdentificadorsService extends BngRestapiService<Identificador> {

    constructor(injector: Injector) {
        super(Identificador, 'identificador', injector, 'rrhh');
    }

}