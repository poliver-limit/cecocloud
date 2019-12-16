import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resource, HalParam } from 'angular4-hal';

import { BngRestapiConfigService } from '@programari-limit/base-angular';

export class Recurs extends Resource { }

@Injectable({
	providedIn: 'root'
})
export class RecursosService {

	public getRecursosAll(): Observable<any> {
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/recursos/allowed');
	}

	public getRecursosByModul(codi: string): Observable<any> {
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/recursos/modul/' + codi);
	}

	public getRecursosByRol(rolId: number): Observable<any> {
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/recursos/rol/' + rolId);
	}

	public getRecursosByRols(rolsId: number[]): Observable<any> {
		let params = new HttpParams();
		rolsId.forEach((rolId: number) => {
			params = params.append(`rolsID[]`, rolId.toString());
		})
		let rolIdparams = rolsId.join(', ');
		console.log("Params: ", params.toString());
		return this.restapiConfigService.getHttp().get(this.restapiConfigService.getContextPath() + '/recursos/rols/' + rolIdparams); //, { params: params });
	}

	public saveRecurs(resourceInfo: any) {
		return this.restapiConfigService.getHttp().post(this.restapiConfigService.getContextPath() + '/recursos/permissions/save', resourceInfo);
	}

	constructor(
		private restapiConfigService: BngRestapiConfigService,
		private httpClient: HttpClient) {
	}

}
