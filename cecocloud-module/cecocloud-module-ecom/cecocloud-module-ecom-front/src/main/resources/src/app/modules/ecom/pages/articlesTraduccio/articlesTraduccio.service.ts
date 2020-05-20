import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ArticleTraduccio extends RestapiResource {}

@Injectable()
export class ArticlesTraduccioService extends BngRestapiService<ArticleTraduccio> {

    constructor( injector: Injector ) {
        super( ArticleTraduccio, 'articleTraduccio', injector, 'ecom' );
    }

}