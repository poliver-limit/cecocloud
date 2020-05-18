import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class PeuDocument extends RestapiResource {}

@Injectable()
export class PeusDocumentService extends BngRestapiService<PeuDocument> {

    constructor( injector: Injector ) {
        super( PeuDocument, 'peuDocument', injector, 'ecom' );
    }

}