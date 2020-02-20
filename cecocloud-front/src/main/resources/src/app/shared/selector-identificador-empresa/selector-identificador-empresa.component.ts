import { Component, Output, EventEmitter } from '@angular/core';
import { BngAuthService, BngScreenSizeService, BngScreenSizeChangeEvent, BngAuthTokenPayload } from 'base-angular';

import { SelectedIdentificadorEmpresaService, SelectedIdentificadorEmpresa } from './selected-identificador-empresa.service';
import { UsuariIdentificadorEmpresaService } from './usuari-identificador-empresa.service';

@Component({
	selector: 'selector-identificador-empresa',
	template: `
<button mat-button *ngIf="selectionTree" [matMenuTriggerFor]="identificadorMenu">
	{{
		selectedIdentificadorEmpresa?.identificador
			? mobileScreen
				? selectedIdentificadorEmpresa?.identificador.codi
				: selectedIdentificadorEmpresa?.identificador.descripcio
			: '__'
	}}
	&nbsp;/&nbsp;
	{{
		selectedIdentificadorEmpresa?.empresa
			? mobileScreen
				? selectedIdentificadorEmpresa?.empresa.codi
				: selectedIdentificadorEmpresa?.empresa.nom
			: '__'
	}}
	<mat-icon>arrow_drop_down</mat-icon>
</button>
<mat-menu #identificadorMenu="matMenu" xPosition="before">
	<ng-container *ngFor="let treeItem of selectionTree; let i = index">
		<mat-divider></mat-divider>
		<button mat-menu-item (click)="treeItem.hasAdminPermission && onAdministrarButtonClick(i)" style="background-color: #ddd" [ngStyle]="{'cursor': treeItem.hasAdminPermission ? 'pointer': 'default'}">
			<mat-icon class="iconcom">domain</mat-icon>
			<span class="nomcom">{{ treeItem.descripcio }}</span>
			<mat-icon *ngIf="treeItem.hasAdminPermission" class="icon_adm">build</mat-icon>
		</button>
		<mat-divider></mat-divider>
		<button mat-menu-item *ngFor="let empresa of treeItem.empreses; let j = index" (click)="onEmpresaButtonClick(i, j)">
			<span style="padding-left:1em">{{ empresa.nom }}</span>
		</button>
	</ng-container>
</mat-menu>`,
	styles: [`
.icon_adm {
	position: relative;
	top: -1em;
	font-size:1.2em;
	margin: 0 !important;
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
}`],
	providers : [
		UsuariIdentificadorEmpresaService
	]
})
export class SelectorIdentificadorEmpresaComponent {

	@Output() identificadorEmpresaSelected: EventEmitter<SelectedIdentificadorEmpresa> = new EventEmitter();
	@Output() identificadorAdminSelected: EventEmitter<any> = new EventEmitter();

	selectionTree: any[];
	selectedIdentificadorEmpresa: SelectedIdentificadorEmpresa;
	tokenPayload: BngAuthTokenPayload;
	mobileScreen: boolean;

	onEmpresaButtonClick(indexIdentificador: number, indexEmpresa: number) {
		let selectedIdentificador: any = this.selectionTree[indexIdentificador];
		let selectedEmpresa: any = selectedIdentificador.empreses[indexEmpresa];
		this.changeSelectedIdentificadorEmpresa({
			identificador: selectedIdentificador,
			empresa: selectedEmpresa
		}, true);
	}

	onAdministrarButtonClick(indexIdentificador: number) {
		let selectedIdentificadorFromTree = this.selectionTree[indexIdentificador];
		let selectedIdentificadorEmpresa: SelectedIdentificadorEmpresa = this.selectedIdentificadorEmpresaService.getSelectedIdentificadorEmpresa();
		let selectedIdentificador: any = selectedIdentificadorEmpresa ? selectedIdentificadorEmpresa.identificador : undefined;
		if (!selectedIdentificador || selectedIdentificador.id !== selectedIdentificadorFromTree.id) {
			this.changeSelectedIdentificadorEmpresa({
				identificador: selectedIdentificadorFromTree,
				empresa: undefined
			}, true);
		}
		this.identificadorAdminSelected.emit(selectedIdentificadorFromTree);
	}

	private changeSelectedIdentificadorEmpresa(selectedIdentificadorEmpresa: SelectedIdentificadorEmpresa, triggerSessioUpdate: boolean) {
		this.selectedIdentificadorEmpresa = selectedIdentificadorEmpresa;
		if (triggerSessioUpdate) {
			let identificador: any;
			if (selectedIdentificadorEmpresa && selectedIdentificadorEmpresa.identificador) {
				identificador = selectedIdentificadorEmpresa.identificador.id;
			}
			let empresa: any;
			if (selectedIdentificadorEmpresa && selectedIdentificadorEmpresa.empresa) {
				empresa = selectedIdentificadorEmpresa.empresa.id;
			}
			let session: any = this.authService.getSession();
			if (!this.selectedIdentificadorEmpresaEqualsSession(identificador, empresa, session)) {
				this.authService.sessionSave({
					i: identificador,
					e: empresa
				});
			}
		}
		this.selectedIdentificadorEmpresaService.setSelectedIdentificadorEmpresa(selectedIdentificadorEmpresa);
		this.identificadorEmpresaSelected.emit(selectedIdentificadorEmpresa);
	}

	private selectedIdentificadorEmpresaEqualsSession(identificador: any, empresa: any, session: any): boolean {
		let sessionIdentificador: any = session ? session.i : undefined;
		let sessionEmpresa: any = session ? session.e : undefined;
		return identificador === sessionIdentificador && empresa === sessionEmpresa;
	}

	private refreshSelectionTree() {
		if (this.authService.isAuthenticated()) {
			this.usuariIdentificadorEmpresaService.whenReady().subscribe(() => {
				this.usuariIdentificadorEmpresaService.getSelectionTree().subscribe((resposta: any) => {
					if (resposta && resposta._embedded) {
						this.selectionTree = resposta._embedded.identificadorEmpresaSelectionTreeItems;
					} else {
						this.selectionTree = undefined;
					}
					let empresaUnica: any;
					if (this.selectionTree && this.selectionTree.length === 1) {
						if (this.selectionTree[0].empreses && this.selectionTree[0].empreses.length === 1) {
							empresaUnica = this.selectionTree[0].empreses[0];
						}
					}
					let selectedIdentificador: any;
					let selectedEmpresa: any;
					if (empresaUnica) {
						selectedIdentificador = this.selectionTree[0];
						selectedEmpresa = empresaUnica;
					} else {
						let session: any = this.authService.getSession();
						if (session && session.i && this.selectionTree) {
							selectedIdentificador = this.selectionTree.find((identificador: any) => { return identificador.id === session.i });
							if (session.e && selectedIdentificador && selectedIdentificador.empreses) {
								selectedEmpresa = selectedIdentificador.empreses.find((empresa: any) => { return empresa.id === session.e });
							}
						}
					}
					this.changeSelectedIdentificadorEmpresa({
						identificador: selectedIdentificador,
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
		private usuariIdentificadorEmpresaService: UsuariIdentificadorEmpresaService,
		private selectedIdentificadorEmpresaService: SelectedIdentificadorEmpresaService,
		private screenSizeService: BngScreenSizeService) {
		authService.getAuthTokenChangeEvent().subscribe((tokenPayload: BngAuthTokenPayload) => {
			if (tokenPayload) {
				// Només refresca l'arbre si l'usuari ha canviat
				if (!this.tokenPayload || this.tokenPayload.sub !== tokenPayload.sub) {
					this.refreshSelectionTree();
				}
			}
			this.tokenPayload = tokenPayload;
		});
		// Es subscriu al subject de canvi de tamany de la pantalla
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: BngScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile
		});
		this.refreshSelectionTree();
	}

}