import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class OficinaBancaria extends Resource {}

@Injectable()
export class OficinesBancariesService extends BngRestapiService<OficinaBancaria> {

    constructor( injector: Injector ) {
        super( OficinaBancaria, 'oficinaBancaria', injector, 'fact' );
    }

}