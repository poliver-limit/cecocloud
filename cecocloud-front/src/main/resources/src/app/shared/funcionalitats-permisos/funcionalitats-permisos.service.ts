import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource, HalParam } from 'angular4-hal';

import { BngRestapiConfigService } from '@programari-limit/base-angular';

export class Recurs extends Resource { }

@Injectable({
	providedIn: 'root'
})
export class FuncionalitatsPermisosService {

	// public getFuncionalitatsAll(perfilId: number): Observable<any> {
	// 	return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatIdentificadors');
	// }

	// public getFuncionalitatsByModul(modul: string): Observable<any> {
	// 	let requestParams: HalParam[] = [];
	// 	requestParams.push({
	// 		key: 'query',
	// 		value: 'funcionalitat.modul==' + modul
	// 	});
	// 	return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatIdentificadors' + codi);
	// }

	public getFuncionalitatsByPerfil(perfilId: number): Observable<any> {
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatPerfils/perfil/' + perfilId);
	}

	public getFuncionalitatsByPerfils(perfilsId: number[]): Observable<any> {
		let params = new HttpParams();
		perfilsId.forEach((perfilId: number) => {
			params = params.append(`perfilsId[]`, perfilId.toString());
		})
		let perfilIdparams = perfilsId.join(', ');
		//console.log("Params: ", params.toString());
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/funcionalitatPerfils/perfils/' + perfilIdparams); //, { params: params });
	}

	public saveFuncionalitat(perfilId: number, funcionalitatInfo: any) {
		return this.restapiConfigService.getHttp().post(this.restapiConfigService.getContextPath() + '/funcionalitatPerfils/perfil/' + perfilId + '/permission/save', funcionalitatInfo);
	}

	constructor(
		private restapiConfigService: BngRestapiConfigService,
		private httpClient: HttpClient) {
	}

}
