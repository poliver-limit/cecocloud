import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ArticleFamilia extends RestapiResource {}

@Injectable()
export class ArticlesFamiliaService extends BngRestapiService<ArticleFamilia> {

    constructor( injector: Injector ) {
        super( ArticleFamilia, 'articleFamilia', injector, 'fact' );
    }

}