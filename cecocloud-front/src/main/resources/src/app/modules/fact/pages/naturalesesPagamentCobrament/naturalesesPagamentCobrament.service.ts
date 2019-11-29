import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class NaturalesaPagamentCobrament extends Resource {}

@Injectable()
export class NaturalesesPagamentCobramentService extends BngRestapiService<NaturalesaPagamentCobrament> {

    constructor( injector: Injector ) {
        super( NaturalesaPagamentCobrament, 'naturalesaPagamentCobrament', injector, 'fact' );
    }

}