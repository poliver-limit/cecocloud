import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';

import { RestapiResource, BngRestapiService } from 'base-angular';

export class Perfil extends RestapiResource {}

@Injectable()
export class PerfilsService extends BngRestapiService<Perfil> {

	refresh(id: any): Observable<Object> {
		return this.getHttpClient().post(this.getApiBaseUrl('/' + id + '/funcionalitatsPermisos/refresh'), {});
	}

    constructor( injector: Injector ) {
        super( Perfil, 'perfil', injector );
    }

}