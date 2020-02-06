import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ArticleGamma extends Resource {}

@Injectable()
export class ArticlesGammaService extends BngRestapiService<ArticleGamma> {

    constructor( injector: Injector ) {
        super( ArticleGamma, 'articleGamma', injector, 'fact' );
    }

}