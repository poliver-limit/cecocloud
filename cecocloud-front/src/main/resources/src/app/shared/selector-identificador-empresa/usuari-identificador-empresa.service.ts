import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { RestapiResource, BngRestapiService } from 'base-angular';

export class UsuariIdentificadorEmpresa extends RestapiResource { }

@Injectable()
export class UsuariIdentificadorEmpresaService extends BngRestapiService<UsuariIdentificadorEmpresa> {

	public getSelectionTree(): Observable<any> {
		return this.getHttpClient().get(this.getApiBaseUrl() + '/selectionTree');
	}

	constructor(injector: Injector) {
		super(UsuariIdentificadorEmpresa, 'usuariIdentificadorEmpresa', injector);
	}

}