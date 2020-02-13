import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ArticleMarca extends RestapiResource {}

@Injectable()
export class ArticlesMarcaService extends BngRestapiService<ArticleMarca> {

    constructor( injector: Injector ) {
        super( ArticleMarca, 'articleMarca', injector, 'fact' );
    }

}