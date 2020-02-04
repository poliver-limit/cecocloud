import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class DocumentPagamentCobrament extends Resource {}

@Injectable()
export class DocumentsPagamentCobramentService extends BngRestapiService<DocumentPagamentCobrament> {

    constructor( injector: Injector ) {
        super( DocumentPagamentCobrament, 'documentPagamentCobrament', injector, 'fact' );
    }

}