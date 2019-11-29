import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Article extends Resource {}

@Injectable()
export class ArticlesService extends BngRestapiService<Article> {

    constructor( injector: Injector ) {
        super( Article, 'article', injector, 'fact' );
    }

}