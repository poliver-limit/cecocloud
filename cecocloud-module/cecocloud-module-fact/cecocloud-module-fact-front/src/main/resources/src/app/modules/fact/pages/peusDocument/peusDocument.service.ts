import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class PeuDocument extends Resource {}

@Injectable()
export class PeusDocumentService extends BngRestapiService<PeuDocument> {

    constructor( injector: Injector ) {
        super( PeuDocument, 'peuDocument', injector, 'fact' );
    }

}