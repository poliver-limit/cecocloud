import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class UsuariIdentificadorEmpresa extends Resource { }

@Injectable({
	providedIn: 'root'
})
export class UsuariIdentificadorEmpresaService extends BngRestapiService<UsuariIdentificadorEmpresa> {

	// public getPerfilTree(): Observable<any> {
	// 	return this.getHttpClient().get(this.getApiBaseUrl() + '/perfilTree');
	// }

	public getSelectionTree(): Observable<any> {
		return this.getHttpClient().get(this.getApiBaseUrl() + '/selectionTree');
	}

	constructor(injector: Injector) {
		super(UsuariIdentificadorEmpresa, 'usuariIdentificadorEmpresa', injector);
	}

}