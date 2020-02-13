import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { RestapiResource, BngRestapiConfigService } from '@programari-limit/base-angular';

export class Recurs extends RestapiResource { }

@Injectable({
	providedIn: 'root'
})
export class FuncionalitatsPermisosService {

	public getFuncionalitatsByPerfil(perfilId: number): Observable<any> {
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatIdentificadorPerfils/perfil/' + perfilId);
	}

	public getFuncionalitatsByPerfils(perfilsId: number[]): Observable<any> {
		let params = new HttpParams();
		perfilsId.forEach((perfilId: number) => {
			params = params.append(`perfilsId[]`, perfilId.toString());
		})
		let perfilIdparams = perfilsId.join(', ');
		//console.log("Params: ", params.toString());
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatIdentificadorPerfils/perfils/' + perfilIdparams); //, { params: params });
	}

	public saveFuncionalitat(perfilId: number, funcionalitatInfo: any) {
		return this.restapiConfigService.getHttp().post(this.restapiConfigService.getContextPath() + '/funcionalitatIdentificadorPerfils/perfil/' + perfilId + '/permission/save', funcionalitatInfo);
	}

	public getAllowedFuncionalitatsByModul(modul: string): Observable<any> {
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatIdentificadorPerfils/usuari/' + modul);
	}

	public refreshPermisosPerfil(perfilId: number) {
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatIdentificadorPerfils/perfil/' + perfilId + '/permission/refresh');
	}

	constructor(
		private restapiConfigService: BngRestapiConfigService,
		private httpClient: HttpClient) {
	}

}
