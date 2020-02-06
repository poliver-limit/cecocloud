import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ArticleMarca extends Resource {}

@Injectable()
export class ArticlesMarcaService extends BngRestapiService<ArticleMarca> {

    constructor( injector: Injector ) {
        super( ArticleMarca, 'articleMarca', injector, 'fact' );
    }

}