import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { RestapiResource, BngRestapiService } from 'base-angular';

export class UsuariIdentificadorEmpresa extends RestapiResource { }

@Injectable({
	providedIn: 'root'
})
export class UsuariIdentificadorEmpresaService extends BngRestapiService<UsuariIdentificadorEmpresa> {

	public getSelectionTree(): Observable<any> {
		return this.getHttpClient().get(this.getApiBaseUrl() + '/selectionTree');
	}

	public getAllowedFuncionalitats(modul: string): Observable<any> {
		// let params: any = {parmas: [{key: 'modul', value: modul}]};
		return this.getHttpClient().get(this.getApiBaseUrl() + '/funcionalitats/' + modul);
	}

	constructor(injector: Injector) {
		super(UsuariIdentificadorEmpresa, 'usuariIdentificadorEmpresa', injector);
	}

}