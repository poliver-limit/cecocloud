import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Subcategoria extends RestapiResource {}

@Injectable()
export class SubcategoriesService extends BngRestapiService<Subcategoria> {

    constructor( injector: Injector ) {
        super( Subcategoria, 'subcategoria', injector, 'rrhh' );
    }

}