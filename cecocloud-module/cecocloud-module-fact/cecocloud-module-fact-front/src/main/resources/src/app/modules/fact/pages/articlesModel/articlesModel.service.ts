import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ArticleModel extends RestapiResource {}

@Injectable()
export class ArticlesModelService extends BngRestapiService<ArticleModel> {

    constructor( injector: Injector ) {
        super( ArticleModel, 'articleModel', injector, 'fact' );
    }

}