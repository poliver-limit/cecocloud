import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class UbicacioArticle extends RestapiResource {}

@Injectable()
export class UbicacionsArticleService extends BngRestapiService<UbicacioArticle> {

    constructor( injector: Injector ) {
        super( UbicacioArticle, 'ubicacioArticle', injector, 'fact' );
    }

}