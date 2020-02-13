import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Categoria extends RestapiResource {}

@Injectable()
export class CategoriesService extends BngRestapiService<Categoria> {

    constructor( injector: Injector ) {
        super( Categoria, 'categoria', injector, 'rrhh' );
    }

}