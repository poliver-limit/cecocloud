import { Injectable, Injector } from '@angular/core';
import { RestapiResource, BngRestapiService } from 'base-angular';

export class PerfilUsuariIdentificadorEmpresa extends RestapiResource {}

@Injectable()
export class PerfilUsuariIdentificadorEmpresaService extends BngRestapiService<PerfilUsuariIdentificadorEmpresa> {

	constructor(injector: Injector) {
		super(PerfilUsuariIdentificadorEmpresa, "perfilUsuariIdentificadorEmpresa", injector);
	}

}
