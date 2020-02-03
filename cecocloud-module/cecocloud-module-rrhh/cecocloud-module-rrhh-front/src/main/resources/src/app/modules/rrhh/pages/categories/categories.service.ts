import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Categoria extends Resource {}

@Injectable()
export class CategoriesService extends BngRestapiService<Categoria> {

    constructor( injector: Injector ) {
        super( Categoria, 'categoria', injector, 'rrhh' );
    }

}