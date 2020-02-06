import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ArticleFamilia extends Resource {}

@Injectable()
export class ArticlesFamiliaService extends BngRestapiService<ArticleFamilia> {

    constructor( injector: Injector ) {
        super( ArticleFamilia, 'articleFamilia', injector, 'fact' );
    }

}