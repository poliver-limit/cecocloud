import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ArticleGamma extends RestapiResource {}

@Injectable()
export class ArticlesGammaService extends BngRestapiService<ArticleGamma> {

    constructor( injector: Injector ) {
        super( ArticleGamma, 'articleGamma', injector, 'fact' );
    }

}