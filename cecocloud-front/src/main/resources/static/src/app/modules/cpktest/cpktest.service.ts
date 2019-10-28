import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from '@programari-limit/bang';

export class Cpktest extends Resource {}

@Injectable()
export class CpktestService extends BngRestapiService<Cpktest> {

    constructor( injector: Injector ) {
        super( Cpktest, 'compositePkTest', injector );
    }

}