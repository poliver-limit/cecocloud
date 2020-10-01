import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class CategoriaTraduccio extends RestapiResource {}

@Injectable()
export class CategoriesTraduccioService extends BngRestapiService<CategoriaTraduccio> {

    constructor( injector: Injector ) {
        super( CategoriaTraduccio, 'categoriaTraduccio', injector, 'ecom' );
    }

}