import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class DocumentPagamentCobrament extends RestapiResource {}

@Injectable()
export class DocumentsPagamentCobramentService extends BngRestapiService<DocumentPagamentCobrament> {

    constructor( injector: Injector ) {
        super( DocumentPagamentCobrament, 'documentPagamentCobrament', injector, 'ecom' );
    }

}