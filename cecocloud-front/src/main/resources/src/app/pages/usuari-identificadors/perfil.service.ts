import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Perfil extends Resource {}

@Injectable()
export class PerfilService extends BngRestapiService<Perfil> {

    constructor( injector: Injector ) {
        super( Perfil, 'perfil', injector );
    }

}