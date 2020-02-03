import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Subcategoria extends Resource {}

@Injectable()
export class SubcategoriesService extends BngRestapiService<Subcategoria> {

    constructor( injector: Injector ) {
        super( Subcategoria, 'subcategoria', injector, 'rrhh' );
    }

}