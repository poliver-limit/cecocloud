import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Funcionalitat extends Resource {}

@Injectable()
export class FuncionalitatsService extends BngRestapiService<Funcionalitat> {

    constructor( injector: Injector ) {
        super( Funcionalitat, 'funcionalitat', injector );
    }

}