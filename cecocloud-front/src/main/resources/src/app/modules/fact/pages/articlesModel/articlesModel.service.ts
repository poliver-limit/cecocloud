import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ArticleModel extends Resource {}

@Injectable()
export class ArticlesModelService extends BngRestapiService<ArticleModel> {

    constructor( injector: Injector ) {
        super( ArticleModel, 'articleModel', injector, 'fact' );
    }

}