import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class Companyia extends Resource {}

@Injectable()
export class CompanyiesService extends BngRestapiService<Companyia> {

	public getSelectionTree(): Observable<any> {
		return this.getHttpClient().get(this.getApiBaseUrl() + '/selectionTree');
	}

    constructor( injector: Injector ) {
        super( Companyia, 'companyia', injector );
    }

}