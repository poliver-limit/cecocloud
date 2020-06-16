import { Injectable, Injector } from '@angular/core';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class MagatzemArticle extends RestapiResource {}

@Injectable()
export class MagatzemsArticleService extends BngRestapiService<MagatzemArticle> {

    constructor( injector: Injector ) {
        super( MagatzemArticle, 'magatzemArticle', injector, 'ecom' );
    }

}