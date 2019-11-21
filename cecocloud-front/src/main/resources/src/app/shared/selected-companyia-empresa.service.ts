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
			let companyia = session.companyia ? {id: session.companyia} : undefined;
			let empresa = session.empresa ? {id: session.empresa} : undefined;
			this.selectedCompanyiaEmpresa = {
				companyia: companyia ? {id: session.companyia}: undefined,
    			empresa: empresa ? {id: session.empresa}: undefined
			}
		}
	}

}
