import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class UbicacioArticle extends Resource {}

@Injectable()
export class UbicacionsArticleService extends BngRestapiService<UbicacioArticle> {

    constructor( injector: Injector ) {
        super( UbicacioArticle, 'ubicacioArticle', injector, 'fact' );
    }

}