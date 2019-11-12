import { Injectable, Injector } from '@angular/core';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class UsuariCompanyia extends Resource {}

@Injectable()
export class CompanyiaUsuarisService extends BngRestapiService<UsuariCompanyia> {

    constructor( injector: Injector ) {
        super( UsuariCompanyia, 'usuariCompanyia', injector );
    }

}