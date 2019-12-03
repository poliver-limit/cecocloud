import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { BngAuthService } from 'base-angular';

export class SelectedCompanyiaEmpresa {
    companyia: any;
    empresa: any;
}

@Injectable( {
    providedIn: 'root',
} )
export class SelectedCompanyiaEmpresaService {

    selectedCompanyiaEmpresa: SelectedCompanyiaEmpresa;

	private selectedCompanyiaEmpresaChangeEvent: Subject<SelectedCompanyiaEmpresa> = new Subject<SelectedCompanyiaEmpresa>();

	public setSelectedCompanyiaEmpresa(selectedCompanyiaEmpresa: SelectedCompanyiaEmpresa) {
		this.selectedCompanyiaEmpresa = selectedCompanyiaEmpresa;
	}

	public getSelectedCompanyiaEmpresa(): SelectedCompanyiaEmpresa {
		return this.selectedCompanyiaEmpresa;
	}

	public getSelectedCompanyiaEmpresaChangeEvent(): Subject<SelectedCompanyiaEmpresa> {
		return this.selectedCompanyiaEmpresaChangeEvent;
	}

	constructor(
		authService: BngAuthService) {
		let session: any = authService.getSession();
		if (session) {
			let companyia = session.c ? {id: session.c} : undefined;
			let empresa = session.e ? {id: session.e} : undefined;
			this.selectedCompanyiaEmpresa = {
				companyia: companyia ? {id: session.c}: undefined,
    			empresa: empresa ? {id: session.e}: undefined
			}
		}
	}

}
