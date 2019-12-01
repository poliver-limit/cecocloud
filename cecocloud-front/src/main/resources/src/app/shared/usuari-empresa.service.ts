import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource } from 'angular4-hal';
import { BngRestapiService } from 'base-angular';

export class UsuariEmpresa extends Resource { }

@Injectable({
	providedIn: 'root'
})
export class UsuariEmpresaService extends BngRestapiService<UsuariEmpresa> {

	public getPerfilTree(): Observable<any> {
		return this.getHttpClient().get(this.getApiBaseUrl() + '/perfilTree');
	}

	constructor(injector: Injector) {
		super(UsuariEmpresa, 'usuariEmpresa', injector);
	}

}