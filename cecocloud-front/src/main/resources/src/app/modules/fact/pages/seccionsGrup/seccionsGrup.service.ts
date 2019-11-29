import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class SeccioGrup extends Resource {}

@Injectable()
export class SeccionsGrupService extends BngRestapiService<SeccioGrup> {

    constructor( injector: Injector ) {
        super( SeccioGrup, 'seccioGrup', injector, 'fact' );
    }

}