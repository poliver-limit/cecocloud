import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Provincia extends Resource {}

@Injectable()
export class ProvinciesService extends BngRestapiService<Provincia> {

    constructor( injector: Injector ) {
        super( Provincia, 'provincia', injector, 'fact' );
    }

}