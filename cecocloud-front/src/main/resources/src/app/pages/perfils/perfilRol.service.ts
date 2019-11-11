import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class PerfilRol extends Resource {}

@Injectable()
export class PerfilRolService extends BngRestapiService<PerfilRol> {

    constructor( injector: Injector ) {
        super( PerfilRol, 'perfilRol', injector );
    }

}