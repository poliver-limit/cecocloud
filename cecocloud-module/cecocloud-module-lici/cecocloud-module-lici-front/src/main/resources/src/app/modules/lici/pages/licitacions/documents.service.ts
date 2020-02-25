import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Document extends RestapiResource { }

@Injectable({
    providedIn: 'root'
})
export class DocumentsService extends BngRestapiService<Document> {

    constructor(injector: Injector) {
        super(Document, 'document', injector, 'lici');
    }

}