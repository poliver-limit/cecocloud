import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class UsuariGrup extends RestapiResource {}

@Injectable()
export class UsuarisGrupService extends BngRestapiService<UsuariGrup> {

    constructor( injector: Injector ) {
        super( UsuariGrup, 'usuariGrup', injector, 'fact' );
    }

}