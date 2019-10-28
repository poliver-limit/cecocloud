import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from '@programari-limit/bang';

export class Operari extends Resource {}

@Injectable()
export class OperarisService extends BngRestapiService<Operari> {

    constructor( injector: Injector ) {
        super( Operari, 'operari', injector );
    }

}