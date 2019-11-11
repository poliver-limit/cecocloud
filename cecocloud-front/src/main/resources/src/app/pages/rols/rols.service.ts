import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Rol extends Resource {}

@Injectable()
export class RolsService extends BngRestapiService<Rol> {

    constructor( injector: Injector ) {
        super( Rol, 'rol', injector );
    }

}