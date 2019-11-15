import { Component, Output, EventEmitter } from '@angular/core';
import { BngAuthService, BngAuthTokenPayload } from 'base-angular';

import { CompanyiesService } from './companyies.service';

@Component({
	selector: 'seleccio-companyia-empresa',
	template: `
<button mat-button *ngIf="selectionTree" [matMenuTriggerFor]="companyiaMenu">{{selectedCompanyia ? selectedCompanyia.nom : '?'}} / {{selectedEmpresa ? selectedEmpresa.nom : '?'}}<mat-icon>arrow_drop_down</mat-icon></button>
<mat-menu #companyiaMenu="matMenu" xPosition="before">
	<ng-container *ngFor="let treeItem of selectionTree; let i = index">
		<mat-divider></mat-divider>
		<button mat-menu-item style="background-color: #ddd">
			<mat-icon>domain</mat-icon>
			<span>{{treeItem.nom}}</span>
		</button>
		<mat-divider></mat-divider>
		<button mat-menu-item *ngFor="let empresa of treeItem.empreses; let j = index" (click)="onEmpresaButtonClick(i, j)">
			<span style="padding-left:1em">{{empresa.nom}}</span>
		</button>
		<button mat-menu-item *ngIf="treeItem.hasAdminPermission" (click)="onAdministrarButtonClick(i)">
			<mat-icon style="padding-left:1em">build</mat-icon>
			<span>Administrar</span>
		</button>
	</ng-container>
</mat-menu>
`
})
export class SeleccioCompanyiaEmpresaComponent {

	@Output() empresaChange: EventEmitter<any> = new EventEmitter();
	@Output() companyiaAdmin: EventEmitter<any> = new EventEmitter();

	tokenPayload: BngAuthTokenPayload;
	selectedCompanyia: any;
	selectedEmpresa: any;
	selectionTree: any[];

	onEmpresaButtonClick(indexCompanyia: number, indexEmpresa: number) {
		this.selectedCompanyia = this.selectionTree[indexCompanyia];
		this.selectedEmpresa = this.selectedCompanyia.empreses[indexEmpresa];
		this.authService.sessionSave({
			companyia: this.selectedCompanyia.id,
			empresa: this.selectedEmpresa.id
		});
		this.empresaChange.emit(this.selectedEmpresa);
	}

	onAdministrarButtonClick(indexCompanyia: number) {
		let selectedCompanyia = this.selectionTree[indexCompanyia];
		if (!this.selectedCompanyia || selectedCompanyia.id !== this.selectedCompanyia.id) {
			this.selectedCompanyia = selectedCompanyia;
			this.selectedEmpresa = undefined;
			this.authService.sessionSave({
				companyia: this.selectedCompanyia.id
			});
		}
		this.companyiaAdmin.emit(this.selectedCompanyia);
	}

	private refreshSelectionTree() {
		let authToken: string = this.authService.getAuthToken();
		if (authToken) {
			this.companyiesService.whenReady().subscribe(() => {
				this.companyiesService.getSelectionTree().subscribe((resposta: any) => {
					this.selectionTree = resposta._embedded.companyiaSelectionTreeItems;
					let session: any = this.authService.getSession();
					if (session && session.companyia) {
						this.selectedCompanyia = this.selectionTree.find((companyia: any) => {return companyia.id === session.companyia});
						if (this.selectedCompanyia && session.empresa && this.selectedCompanyia.empreses) {
							this.selectedEmpresa = this.selectedCompanyia.empreses.find((empresa: any) => {return empresa.id === session.empresa});
						}
					}
				});
			});
		} else {
			this.selectionTree = undefined;
		}
	}

	constructor(
		private authService: BngAuthService,
		private companyiesService: CompanyiesService) {
		this.tokenPayload = authService.getAuthTokenPayload();
		/*authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			if (tokenPayload) {
				// Només refresca l'arbre si l'usuari ha canviat
				if (!this.tokenPayload || this.tokenPayload.sub !== tokenPayload.sub) {
					this.refreshSelectionTree();
				}
			}
			this.tokenPayload = tokenPayload;
		});*/
		this.refreshSelectionTree();
	}

}