import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ArticleInformacio extends RestapiResource {}

@Injectable()
export class ArticlesInformacioService extends BngRestapiService<ArticleInformacio> {

    constructor( injector: Injector ) {
        super( ArticleInformacio, 'articleInformacio', injector, 'ecom' );
    }

}