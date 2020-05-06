import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Article extends RestapiResource {}

@Injectable()
export class ArticlesService extends BngRestapiService<Article> {

    constructor( injector: Injector ) {
        super( Article, 'article', injector, 'ecom' );
    }

}