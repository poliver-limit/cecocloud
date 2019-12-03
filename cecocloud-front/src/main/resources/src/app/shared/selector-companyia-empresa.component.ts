import { Component, Output, EventEmitter } from '@angular/core';
import { BngAuthService, BngScreenSizeService, BngScreenSizeChangeEvent } from 'base-angular';

import { CompanyiesService } from './companyies.service';
import { SelectedCompanyiaEmpresaService, SelectedCompanyiaEmpresa } from './selected-companyia-empresa.service';

@Component({
	selector: 'selector-companyia-empresa',
	template: `
<button mat-button *ngIf="selectionTree" [matMenuTriggerFor]="companyiaMenu">
	{{selectedCompanyiaEmpresa?.companyia ? (mobileScreen ? selectedCompanyiaEmpresa?.companyia.codi : selectedCompanyiaEmpresa?.companyia.nom) : '?'}}
	&nbsp;/&nbsp;
	{{selectedCompanyiaEmpresa?.empresa ? (mobileScreen ? selectedCompanyiaEmpresa?.empresa.codi : selectedCompanyiaEmpresa?.empresa.nom) : '?'}}
	<mat-icon>arrow_drop_down</mat-icon>
</button>
<mat-menu #companyiaMenu="matMenu" xPosition="before">
	<ng-container *ngFor="let treeItem of selectionTree; let i = index">
		<mat-divider></mat-divider>
		<button mat-menu-item style="background-color: #ddd; cursor: default;">
			<mat-icon class="iconcom">domain</mat-icon>
			<span class="nomcom">{{treeItem.nom}}</span>
			<button *ngIf="treeItem.hasAdminPermission"
				mat-icon-button color='primary'
				aria-label="Botó d'edició de la companyia"
				(click)="onAdministrarButtonClick(i)"
				class="btn_adm">
				<mat-icon class="icon_adm">build</mat-icon>
			</button>
		</button>
		<mat-divider></mat-divider>
		<button mat-menu-item *ngFor="let empresa of treeItem.empreses; let j = index" (click)="onEmpresaButtonClick(i, j)">
			<span style="padding-left:1em">{{empresa.nom}}</span>
		</button>
		<!--button mat-menu-item *ngIf="treeItem.hasAdminPermission" (click)="onAdministrarButtonClick(i)">
			<mat-icon style="padding-left:1em">build</mat-icon>
			<span>Administrar</span>
		</button-->
	</ng-container>
</mat-menu>
`,
	styles: [`
	.btn_adm {
		float: right;
		margin-left:1em;
		padding: 0;
		width: 30px;
		min-width: 40px;
		height:26px;
		line-height: 32px;
		top: 6px;
	}
	.icon_adm {
		font-size:1.2em;
		margin: 0 !important;
		color: #875A7B;
		/*color: white;*/
	}
	.nomcom {
		width: 154px;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
		display:inline-block;
	}
	.iconcom {
		float: left;
    	position: relative;
    	top: 10px;
	}
`]
})
export class SelectorCompanyiaEmpresaComponent {

	@Output() selectedCompanyiaEmpresaChange: EventEmitter<SelectedCompanyiaEmpresa> = new EventEmitter();
	@Output() companyiaAdmin: EventEmitter<any> = new EventEmitter();

	selectionTree: any[];
	selectedCompanyiaEmpresa: SelectedCompanyiaEmpresa;
	mobileScreen: boolean;

	onEmpresaButtonClick(indexCompanyia: number, indexEmpresa: number) {
		let selectedCompanyia: any = this.selectionTree[indexCompanyia];
		let selectedEmpresa: any = selectedCompanyia.empreses[indexEmpresa];
		this.changeSelectedCompanyiaEmpresa({
			companyia: selectedCompanyia,
			empresa: selectedEmpresa
		}, true);
	}

	onAdministrarButtonClick(indexCompanyia: number) {
		let selectedCompanyiaFromTree = this.selectionTree[indexCompanyia];
		let selectedCompanyiaEmpresa: SelectedCompanyiaEmpresa = this.selectedCompanyiaEmpresaService.getSelectedCompanyiaEmpresa();
		let selectedCompanyia: any = selectedCompanyiaEmpresa ? selectedCompanyiaEmpresa.companyia : undefined;
		if (!selectedCompanyia || selectedCompanyia.id !== selectedCompanyiaFromTree.id) {
			this.changeSelectedCompanyiaEmpresa({
				companyia: selectedCompanyiaFromTree,
				empresa: undefined
			}, true);
		}
		this.companyiaAdmin.emit(selectedCompanyiaFromTree);
	}

	private changeSelectedCompanyiaEmpresa(selectedCompanyiaEmpresa: SelectedCompanyiaEmpresa, triggerSessioUpdate: boolean) {
		this.selectedCompanyiaEmpresa = selectedCompanyiaEmpresa;
		if (triggerSessioUpdate) {
			let companyia: any;
			if (selectedCompanyiaEmpresa && selectedCompanyiaEmpresa.companyia) {
				companyia = selectedCompanyiaEmpresa.companyia.id;
			}
			let empresa: any;
			if (selectedCompanyiaEmpresa && selectedCompanyiaEmpresa.empresa) {
				empresa = selectedCompanyiaEmpresa.empresa.id;
			}
			this.authService.sessionSave({
				c: companyia,
				e: empresa
			});
		}
		this.selectedCompanyiaEmpresaService.setSelectedCompanyiaEmpresa(selectedCompanyiaEmpresa);
		this.selectedCompanyiaEmpresaChange.emit(selectedCompanyiaEmpresa);
	}

	private refreshSelectionTree() {
		let authToken: string = this.authService.getAuthToken();
		if (authToken) {
			this.companyiesService.whenReady().subscribe(() => {
				this.companyiesService.getSelectionTree().subscribe((resposta: any) => {
					if (resposta && resposta._embedded) {
						this.selectionTree = resposta._embedded.companyiaSelectionTreeItems;
					} else {
						this.selectionTree = undefined;
					}
					let selectedCompanyia: any;
					let selectedEmpresa: any;
					let session: any = this.authService.getSession();
					if (session && session.c && this.selectionTree) {
						selectedCompanyia = this.selectionTree.find((companyia: any) => { return companyia.id === session.c });
						if (session.e && selectedCompanyia && selectedCompanyia.empreses) {
							selectedEmpresa = selectedCompanyia.empreses.find((empresa: any) => { return empresa.id === session.e });
						}
					}
					this.changeSelectedCompanyiaEmpresa({
						companyia: selectedCompanyia,
						empresa: selectedEmpresa
					}, true);
				});
			});
		} else {
			this.selectionTree = undefined;
		}
	}

	constructor(
		private authService: BngAuthService,
		private companyiesService: CompanyiesService,
		private selectedCompanyiaEmpresaService: SelectedCompanyiaEmpresaService,
		private screenSizeService: BngScreenSizeService) {
		/*authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			if (tokenPayload) {
				// Només refresca l'arbre si l'usuari ha canviat
				if (!this.tokenPayload || this.tokenPayload.sub !== tokenPayload.sub) {
					this.refreshSelectionTree();
				}
			}
			this.tokenPayload = tokenPayload;
		});*/
		// Es subscriu al subject de canvi de tamany de la pantalla
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: BngScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile
		});
		this.refreshSelectionTree();
	}

}