import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class ArticleFamiliaEmpresa extends Resource {}

@Injectable()
export class ArticlesFamiliaEmpresaService extends BngRestapiService<ArticleFamiliaEmpresa> {

    constructor( injector: Injector ) {
        super( ArticleFamiliaEmpresa, 'articleFamiliaEmpresa', injector, 'fact' );
    }

}