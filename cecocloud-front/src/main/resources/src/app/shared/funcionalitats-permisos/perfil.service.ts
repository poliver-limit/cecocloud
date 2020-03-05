import { Injectable, Injector } from "@angular/core";
import { RestapiResource, BngRestapiService } from "base-angular";
import { HttpParams } from '@angular/common/http';

export class Perfil extends RestapiResource { };

@Injectable()
export class PerfilService extends BngRestapiService<Perfil> {

	public getFuncionalitatsByPerfil(id: number) {
		return this.getHttpClient().get(this.getApiBaseUrl() + '/' + id + '/funcionalitatsPermisos');
	}

	public getFuncionalitatsByPerfils(ids: number[]) {
		const id: number = ids[0];
		let params = new HttpParams();

		if (ids.length > 1) {
			ids.shift();
			ids.forEach((id: number) => { params = params.append(`perfilsAddicionalsIds`, id.toString()); });
		}
		return this.getHttpClient().get(this.getApiBaseUrl() + '/' + id + '/funcionalitatsPermisos', { params: params });
	}

	public saveFuncionalitat(id: number, funcionalitatInfo: any) {
		return this.getHttpClient().post(this.getApiBaseUrl() + '/' + id + '/funcionalitatsPermisos', funcionalitatInfo);
	}

	constructor(injector: Injector) {
		super(Perfil, "perfil", injector);
	}

}
