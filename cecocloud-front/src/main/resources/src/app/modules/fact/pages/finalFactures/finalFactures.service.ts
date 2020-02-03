import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class FinalFactura extends Resource {}

@Injectable()
export class FinalFacturesService extends BngRestapiService<FinalFactura> {

    constructor( injector: Injector ) {
        super( FinalFactura, 'finalFactura', injector, 'fact' );
    }

}