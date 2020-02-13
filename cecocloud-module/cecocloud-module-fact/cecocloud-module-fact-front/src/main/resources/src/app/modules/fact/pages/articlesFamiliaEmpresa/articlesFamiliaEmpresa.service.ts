import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class ArticleFamiliaEmpresa extends RestapiResource {}

@Injectable()
export class ArticlesFamiliaEmpresaService extends BngRestapiService<ArticleFamiliaEmpresa> {

    constructor( injector: Injector ) {
        super( ArticleFamiliaEmpresa, 'articleFamiliaEmpresa', injector, 'fact' );
    }

}