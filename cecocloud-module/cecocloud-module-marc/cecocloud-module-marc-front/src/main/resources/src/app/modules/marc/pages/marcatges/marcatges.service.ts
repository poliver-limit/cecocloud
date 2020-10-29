import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Marcatge extends RestapiResource {}

@Injectable()
export class MarcatgesService extends BngRestapiService<Marcatge> {

	validate(id: any): Observable<Object> {
		return this.getHttpClient().patch(
			this.getApiBaseUrl('/' + id),
			[{ op: 'replace', path: '/validat', value: true }]);
	}

    constructor( injector: Injector ) {
        super( Marcatge, 'marcatge', injector, 'marc' );
    }

}