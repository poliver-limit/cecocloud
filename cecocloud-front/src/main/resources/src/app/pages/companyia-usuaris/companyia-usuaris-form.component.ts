import { EmpresaPerfil } from './companyia-usuaris-form.component';
import { EmpresesService } from './../empreses/empreses.service';
import { PerfilUsuariEmpresaService, PerfilUsuariEmpresa } from './perfil-usuari-empresa.service';
import { PerfilsService } from './../perfils/perfils.service';
import { UsuariEmpresaService } from './../../shared/usuari-empresa.service';
import { Resource, HalParam } from 'angular4-hal';
import { Component, OnInit, OnDestroy, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from "@ngx-translate/core";
import { Subscription } from 'rxjs';

import { BngScreenSizeChangeEvent, BngScreenSizeService } from '@programari-limit/base-angular';
import { BngRestapiProfile } from '@programari-limit/base-angular/lib/restapi/restapi-profile';

import { UsuarisService } from "./usuaris.service";
import { CompanyiaUsuarisService } from './companyia-usuaris.service';
import { MatTable, MatSnackBar } from '@angular/material';

export interface EmpresaPerfil {
	empresaNom: string;
	empresaId: number;
	usuariEmpresaId: string;
	ids: string[];
	perfils: number[];
}

@Component({
	template: `
	<mat-toolbar class="form-header" [ngClass]="{'form-header-mobile': mobileScreen, 'form-header-desktop': !mobileScreen}">
		<button mat-icon-button (click)="onButtonCancelClick()">
			<mat-icon>arrow_back</mat-icon>
		</button>
		<span style="padding-left:.4em">{{title}} / {{'component.restapi.form.header.title.modificar' | translate}}</span>
		<span class="toolbar-fill"></span>
		<!--button mat-icon-button *ngIf="hasSavePermission" title="{{'component.restapi.form.header.button.guardar'|translate}}" (click)="onButtonSaveClick()">
			<mat-icon>save_alt</mat-icon>
		</button>
		<button mat-icon-button *ngIf="hasSavePermission" title="{{'component.restapi.form.header.button.descartar'|translate}}" [disabled]="!anyFieldChanged" (click)="onButtonUndoClick()">
			<mat-icon>undo</mat-icon>
		</button-->
	</mat-toolbar>

	<mat-card class="mat-elevation-z4" style="margin: 1em; padding: 2em">
		<div style="display: flex; flex-wrap: wrap;">
			<div style="display: flex; flex-wrap: wrap; width: calc(100% - 110px);">
				<mat-form-field style="width:100%;">
					<mat-label>{{'resource.usuari.field.nom'|translate}}</mat-label>
					<input matInput type="text" readonly="true"	value='{{usuari?.nom}}' />
				</mat-form-field>
				<mat-form-field style="width:100%;">
					<mat-label>{{'resource.usuari.field.llinatges'|translate}}</mat-label>
					<input matInput type="text" readonly="true" value='{{usuari?.llinatges}}' />
				</mat-form-field>
			</div>
			<div *ngIf="usuariTeImatge(); else icona" style="width: 110px; display: flex;">
				<img src='{{usuari?.imatgeUrl}}' style="margin-left: 20px; width: 90px; height: 90px; background-color: #AAA;" />
			</div>
			<ng-template #icona>
				<div style="width: 90px; display: flex; padding-left: 20px;">
					<mat-icon style="font-size: 90px; width: 90px; height: 90px;">account_circle</mat-icon>
				</div>
			</ng-template>
		</div>
		<div style="width: 100%; display: flex; flex-wrap: wrap;">
			<mat-form-field style="width: calc(100% - 110px);">
				<mat-label>{{'resource.usuari.field.email'|translate}}</mat-label>
				<input matInput type="text" readonly="true" value='{{usuari?.email}}' />
			</mat-form-field>
			<mat-checkbox disabled="true" [checked]='usuari?.actiu' style="margin-left: 20px; position: relative; top: 12px;">
				<span>{{'resource.usuari.field.actiu'|translate}}</span>
			</mat-checkbox>
		</div>
		<div style="display: flex">
			<div style="width: 100%; margin-top: 40px;">
				<mat-tab-group>
					<mat-tab label="{{'page.componyia-usuari-empresa.permisos'|translate}}">
						<!-- Pestanya de permisos ->
						<table mat-table [dataSource]="perfilTree" class="mat-elevation-z8" style="width:100%;">
							<ng-container matColumnDef="nom">
								<th mat-header-cell *matHeaderCellDef style="width:30%;"> {{'resource.empresa' | translate}} </th>
								<td mat-cell *matCellDef="let empresa"> {{empresa.nom}} </td>
							</ng-container>
							<ng-container matColumnDef="perfils">
								<th mat-header-cell *matHeaderCellDef style="width:70%;"> {{'resource.perfil.plural' | translate}} </th>
								<td mat-cell *matCellDef="let empresa; let index = index">
									<mat-select [(value)]="empresa.perfils" multiple placeholder="Sense accés" (selectionChange)="onPerfilChange($event, index)">
										<mat-option *ngFor="let perfil of perfils" [value]="perfil.id">{{perfil.codi}}</mat-option>
									</mat-select>
								</td>
							</ng-container>
							<tr mat-header-row *matHeaderRowDef="columnsToDisplay"></tr>
							<tr mat-row *matRowDef="let rows; columns: columnsToDisplay"></tr>
						</table-->
						<table mat-table [dataSource]="empresaPerfils" class="mat-elevation-z8" style="width:100%;">
							<!-- Columna de empresa -->
							<ng-container matColumnDef="nom">
								<th mat-header-cell *matHeaderCellDef style="width:30%;"> {{'resource.empresa' | translate}} </th>
								<td mat-cell *matCellDef="let empresa"> {{empresa.empresaNom}} </td>
							</ng-container>
							<!-- Columna de perfils -->
							<ng-container matColumnDef="perfils">
								<th mat-header-cell *matHeaderCellDef style="width:70%;"> {{'resource.perfil.plural' | translate}} </th>
								<td mat-cell *matCellDef="let empresa; let index = index">
									<mat-select [(value)]="empresa.perfils" multiple placeholder="Sense accés" (selectionChange)="onPerfilChange($event, index)">
										<mat-option *ngFor="let perfil of perfils" [value]="perfil.id">{{perfil.codi}}</mat-option>
									</mat-select>
								</td>
							</ng-container>
							<tr mat-header-row *matHeaderRowDef="columnsToDisplay"></tr>
							<tr mat-row *matRowDef="let rows; columns: columnsToDisplay"></tr>
						</table>
					</mat-tab>
					<mat-tab label="{{'page.componyia-usuari-empresa.preferencies'|translate}}">
					<!-- Pestanya de preferències -->
						<h3>Empresa per defecte</h3>
					</mat-tab>
				</mat-tab-group>
			</div>
		</div>
	</mat-card>
	`,
	styles: [`
	.form-header {
		border-bottom: 1px solid #e2e2e2;
	}
	.form-header-desktop {
		background-color: #f2f2f2;
		color: rgba(0, 0, 0, 0.54);
	}
	.form-header-mobile {
		background-color: var(--mdc-theme-primary, #6200ee);
		color: white;
	}
	.toolbar-fill {
		flex: 1 1 auto;
	}
	`]
})
export class CompanyiaUsuarisFormComponent implements OnDestroy {

	@ViewChild(MatTable, null) table: MatTable<any>;

	public translate: TranslateService;
	private routeSub: Subscription;

	usuariCompanyiaId: string;
	currentRouteUrl: string;
	mobileScreen: boolean;
	hasSavePermission: boolean;
	title: string;

	usuari: any;
	empreses: any[];
	usuariEmpreses: any[];
	perfilsUsuariEpresa: any[];
	perfils: any[];
	empresaPerfils: EmpresaPerfil[];
	epo: EmpresaPerfil[];

	//anyFieldChanged: boolean;
	perfilTree: any[];
	perfilTreeOriginal: any[];
	columnsToDisplay: string[] = ['nom', 'perfils'];

	ngOnDestroy() {
		this.routeSub.unsubscribe();
	}

	onButtonCancelClick() {
		let index = this.currentRouteUrl.indexOf('/update');
		this.router.navigate([this.currentRouteUrl.substring(0, index)]);
	}

	// onPerfilChange(event, index) {
	// 	let perfilsNous = this.empresaPerfils[index].perfils.filter(item => this.epo[index].perfils.indexOf(item) < 0);
	// 	// TODO: Deshabilitar mentres s'està creant/eliminant el perfil
	// 	if (perfilsNous.length > 0) {
	// 		let usuariEmpresaId = this.empresaPerfils[index].usuariEmpresaId;
	// 		// TODO: Crear l'usuari-empresa si no existeix
	// 		let perfilUsuariEmpresa: any = {
	// 			usuariEmpresa: { id: this.empresaPerfils[index].usuariEmpresaId },
	// 			perfil: { id: perfilsNous[0] }
	// 		}
	// 		this.perfilUsuariEmpresaService.create(<PerfilUsuariEmpresa>perfilUsuariEmpresa).subscribe((resposta: any) => {
	// 			// TODO: Afegir l'id del perfil-usuari-empresa
	// 			this.epo = JSON.parse(JSON.stringify(this.empresaPerfils));
	// 			this.showMessage(this.translateKey('component.restapi.form.manteniment.created'));
	// 		});
	// 	} else {
	// 		let perfilsEliminats = this.epo[index].perfils.filter(item => this.empresaPerfils[index].perfils.indexOf(item) < 0);
	// 		if (perfilsEliminats.length > 0) {
	// 			if (this.empresaPerfils[index].perfils.length == 0) {
	// 				// TODO: Eliminar l'usuari-empresa
	// 			}
	// 			//let perfilUsuariEmpresaId = this.epo[index].ids[]
	// 			let perfilUsuariEmpresaPk = {
	// 				usuariId: this.usuari.id,
	// 				empresaId: this.empresaPerfils[index].id,
	// 				perfilId: perfilsEliminats[0]
	// 			}
	// 			this.perfilUsuariEmpresaService.deleteById(btoa(JSON.stringify(perfilUsuariEmpresaPk))).subscribe((resposta: any) => {
	// 				this.epo = JSON.parse(JSON.stringify(this.empresaPerfils));
	// 				this.showMessage(this.translateKey('component.restapi.form.manteniment.deleted'));
	// 			});
	// 		}
	// 	}
	// }

	onPerfilChange(event, index) {
		let nous = this.perfilTree[index].perfils.filter(item => this.perfilTreeOriginal[index].perfils.indexOf(item) < 0);
		// TODO: Deshabilitar mentres s'està creant/eliminant el perfil
		if (nous.length > 0) {
			let usuariEmpresa = { usuariId: this.usuari.id, empresaId: this.perfilTree[index].id };
			let perfilUsuariEmpresa: any = {
				usuariEmpresa: { id: btoa(JSON.stringify(usuariEmpresa)) },
				perfil: { id: nous[0] }
			}
			this.perfilUsuariEmpresaService.create(<PerfilUsuariEmpresa>perfilUsuariEmpresa).subscribe((resposta: any) => {
				this.perfilTreeOriginal = JSON.parse(JSON.stringify(this.perfilTree));
				this.showMessage(this.translateKey('component.restapi.form.manteniment.created'));
			});
		} else {
			let missing = this.perfilTreeOriginal[index].perfils.filter(item => this.perfilTree[index].perfils.indexOf(item) < 0);
			if (missing.length > 0) {
				let perfilUsuariEmpresaPk = {
					usuariId: this.usuari.id,
					empresaId: this.perfilTree[index].id,
					perfilId: missing[0]
				}
				this.perfilUsuariEmpresaService.deleteById(btoa(JSON.stringify(perfilUsuariEmpresaPk))).subscribe((resposta: any) => {
					this.perfilTreeOriginal = JSON.parse(JSON.stringify(this.perfilTree));
					this.showMessage(this.translateKey('component.restapi.form.manteniment.deleted'));
				});
			}
		}
	}


	private usuariTeImatge() {
		return this.usuari != null && this.usuari.imatgeUrl != null && this.usuari.imatgeUrl != '';
	}

	private refreshEmpresaPerfils() {
		this.usuariEmpresaService.whenReady().subscribe(() => {
			this.usuariEmpresaService.getPerfilTree().subscribe((resposta: any) => {
				console.log(resposta);
				if (resposta && resposta._embedded) {
					this.perfilTree = resposta._embedded.usuariEmpresaPerfilTreeItems;
				} else {
					this.perfilTree = undefined;
				}
				this.perfilTreeOriginal = JSON.parse(JSON.stringify(this.perfilTree));
				this.table.renderRows();
			});
		});
	}

	private generateTableData() {
		this.empresaPerfils = [];
		this.empreses.forEach((empresa) => {
			if (empresa.activa) {
				let usuariEmpresa = this.usuariEmpreses.find(item => item.empresa.id == empresa.id);
				let usuariEmpresaId = null;
				let perfilsUsuariEmpresaId = [];
				let perfils = [];
				if (usuariEmpresa) {
					usuariEmpresaId = usuariEmpresa.id;
					let perfilsUsuariEmpresa = this.perfilsUsuariEpresa.filter(item => item.usuariEmpresa.id == usuariEmpresa.id);
					perfilsUsuariEmpresaId = perfilsUsuariEmpresa.map(item => item.perfil.id);
				}
				let empresaPerfil: EmpresaPerfil = {
					empresaId: empresa.id,
					empresaNom: empresa.nom,
					usuariEmpresaId: usuariEmpresaId,
					ids: perfilsUsuariEmpresaId,
					perfils: perfils
				};

				this.empresaPerfils.push(empresaPerfil);
			}
		});
		this.epo = JSON.parse(JSON.stringify(this.empresaPerfils));
	}

	private showMessage(message: string) {
		const snackbarRef = this.snackbar.open(
			message,
			this.translateKey('component.restapi.form.manteniment.button.close'), {
			duration: 2000
		});
	}

	translateKey(key: string, params?: any, defaultValue?: string) {
		let translatedKey = this.translate.instant(key, params);
		if (defaultValue) {
			return (translatedKey !== key) ? translatedKey : defaultValue;
		} else {
			return translatedKey;
		}
	}

	constructor(
		public usuarisService: UsuarisService,
		public usuariCompanyiaService: CompanyiaUsuarisService,
		public usuariEmpresaService: UsuariEmpresaService,
		public empresaService: EmpresesService,
		public perfilsService: PerfilsService,
		public perfilUsuariEmpresaService: PerfilUsuariEmpresaService,
		translate: TranslateService,
		private router: Router,
		private route: ActivatedRoute,
		private screenSizeService: BngScreenSizeService,
		private snackbar: MatSnackBar) {

		this.perfilTree = [];
		//this.anyFieldChanged = false;
		this.currentRouteUrl = this.router.url;
		this.translate = translate;
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: BngScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile
		});
		this.routeSub = this.route.params.subscribe((params) => {
			if (params.id) {
				this.usuariCompanyiaId = params.id;
				this.usuariCompanyiaService.whenReady().subscribe((restapiProfile: BngRestapiProfile) => {
					this.title = this.translateKey(restapiProfile.resource.translateKey);
					this.hasSavePermission = restapiProfile.resource.hasUpdatePermission;
					this.usuariCompanyiaService.get(this.usuariCompanyiaId).subscribe((usuariCompanyia: Resource) => {
						this.usuarisService.get(usuariCompanyia['usuari']['id']).subscribe((usuari: Resource) => {
							this.usuari = usuari;
							this.refreshEmpresaPerfils();
							// Obtenim totes les empreses de la companyia
							this.empresaService.whenReady().subscribe((restapiProfile: BngRestapiProfile) => {
								let requestParams: HalParam[] = [];
								requestParams.push({ key: 'sort', value: 'nom,ASC' });
								this.empresaService.getAll({ params: requestParams }).subscribe((response: any) => {
									this.empreses = response;
									// Obtenim totes les empreses que estan associades a l'usuari
									this.usuariEmpresaService.whenReady().subscribe((restapiProfile: BngRestapiProfile) => {
										let requestParams: HalParam[] = [];
										requestParams.push({ key: 'query', value: 'usuari.id==' + this.usuari.id });
										requestParams.push({ key: 'sort', value: 'empresa.nom,ASC' });
										this.usuariEmpresaService.getAll({ params: requestParams }).subscribe((response: any) => {
											this.usuariEmpreses = response;
											// Obtenim tots els perfils-empresa de l'usuari
											this.perfilUsuariEmpresaService.whenReady().subscribe((restapiProfile: BngRestapiProfile) => {
												this.perfilUsuariEmpresaService.getAll().subscribe((response: any) => {
													this.perfilsUsuariEpresa = response;
													// Obtenim tots els perfils de la companyia
													this.perfilsService.whenReady().subscribe((restapiProfile: BngRestapiProfile) => {
														let requestParams: HalParam[] = [];
														requestParams.push({ key: 'sort', value: 'codi,ASC' });
														this.perfilsService.getAll({ params: requestParams }).subscribe((response: any) => {
															this.perfils = response;
															// Quan em obtingut totes les dades necessàries, generam l'estructura de dades
															// necessària per a montar la taula de empreses-perfils
															this.generateTableData();
														});
													});
												});
											});
										});
									});
								});
							});
						});
					});
				});
			}
		});
	}
}
