import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { RestapiResource, BngRestapiService } from 'base-angular';

export class Cita extends RestapiResource {}

@Injectable()
export class CitesService extends BngRestapiService<Cita> {

	cancel(id: any): Observable<Object> {
		return this.getHttpClient().patch(
			this.getApiBaseUrl('/' + id),
			[{ op: 'replace', path: '/anulada', value: true }]);
	}

    constructor( injector: Injector ) {
        super( Cita, 'cita', injector, 'cita' );
    }

}