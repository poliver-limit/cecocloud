import { EmpresaPerfil } from './companyia-usuaris-form.component';
import { EmpresesService } from './../empreses/empreses.service';
import { PerfilUsuariEmpresaService, PerfilUsuariEmpresa } from './perfil-usuari-empresa.service';
import { PerfilsService } from './../perfils/perfils.service';
import { UsuariEmpresaService, UsuariEmpresa } from './../../shared/usuari-empresa.service';
import { Resource, HalParam } from 'angular4-hal';
import { Component, OnInit, OnDestroy, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from "@ngx-translate/core";
import { Subscription } from 'rxjs';

import { BngScreenSizeChangeEvent, BngScreenSizeService, BngFormConfig } from '@programari-limit/base-angular';
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
	<bng-form
		bng-form-mant
		[config]="formConfig"
		[restapiService]="usuariCompanyiaService">
		<ng-container *ngTemplateOutlet="fieldsTemplate"></ng-container>
		<ng-template #fieldsTemplate>
			<div style="display: flex">
				<bng-custom-field name="usuari" style="width: 30%; padding-right: 2em; display:none;"></bng-custom-field>
			</div>
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
		</ng-template>
		<div style="display: flex">
			<div style="width: 100%; margin-top: 40px;">
				<mat-tab-group>
					<mat-tab label="{{'page.componyia-usuari-empresa.permisos'|translate}}">
						<!-- Pestanya de permisos -->
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
									<mat-select [disabled]="disableSelects" [(value)]="empresa.perfils" multiple placeholder="Sense accés" (selectionChange)="onPerfilChange($event, index)">
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
	</bng-form>
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
	button[title="Editar"] {
    	display: none;
	}
	`]
})
export class CompanyiaUsuarisFormComponent implements OnDestroy {

	@ViewChild(MatTable, null) table: MatTable<any>;

	id: any;
	formConfig: BngFormConfig = {
		readOnlyStateEnabled: true,
		isButtonSave: false,
		isUpdateShow: false
	};

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

	columnsToDisplay: string[] = ['nom', 'perfils'];
	disableSelects: boolean = false;

	ngOnDestroy() {
		this.routeSub.unsubscribe();
	}

	onButtonCancelClick() {
		let index = this.currentRouteUrl.indexOf('/update');
		this.router.navigate([this.currentRouteUrl.substring(0, index)]);
	}

	onPerfilChange(event, index) {
		// Deshabilitar selects mentres s'està creant/eliminant el perfil
		this.disableSelects = true;
		let perfilsNous = this.empresaPerfils[index].perfils.filter(item => this.epo[index].perfils.indexOf(item) < 0);
		if (perfilsNous.length > 0) {
			let usuariEmpresaId = this.empresaPerfils[index].usuariEmpresaId;
			if (usuariEmpresaId) {
				let perfilUsuariEmpresa: any = {
					usuariEmpresa: { id: usuariEmpresaId },
					perfil: { id: perfilsNous[0] }
				}
				this.createPerfilEmpresa(perfilUsuariEmpresa, index);
			} else {
				// Crear l'usuari-empresa si no existeix
				let usuariEmpresa: any = {
					usuari: { id: this.usuari.id },
					empresa: { id: this.empresaPerfils[index].empresaId }
				}
				this.usuariEmpresaService.create(<UsuariEmpresa>usuariEmpresa).subscribe((resposta: any) => {
					this.empresaPerfils[index].usuariEmpresaId = resposta.id;
					let perfilUsuariEmpresa: any = {
						usuariEmpresa: { id: resposta.id },
						perfil: { id: perfilsNous[0] }
					}
					this.createPerfilEmpresa(perfilUsuariEmpresa, index);
				});
			}
		} else {
			let perfilsEliminats = this.epo[index].perfils.filter(item => this.empresaPerfils[index].perfils.indexOf(item) < 0);
			if (perfilsEliminats.length > 0) {
				let pos = this.epo[index].perfils.indexOf(perfilsEliminats[0]);
				let perfilUsuariEmpresaId = this.epo[index].ids[pos];
				// Eliminar el perfil-usuari-empresa
				this.deletePerfilEmpresa(
					perfilUsuariEmpresaId,
					index,
					pos,
					this.empresaPerfils[index].perfils.length == 0);
			} else {
				this.disableSelects = false;
			}
		}
	}

	private deletePerfilEmpresa(perfilUsuariEmpresaId, index, pos, ultim) {
		// Eliminar el perfil-usuari-empresa
		this.perfilUsuariEmpresaService.deleteById(perfilUsuariEmpresaId).subscribe((resposta: any) => {
			if (ultim) {
				// Eliminar l'usuari-empresa
				this.usuariEmpresaService.deleteById(this.empresaPerfils[index].usuariEmpresaId).subscribe((resposta: any) => {
					this.empresaPerfils[index].usuariEmpresaId = null;
					this.empresaPerfils[index].ids.splice(pos, 1);
					this.epo = JSON.parse(JSON.stringify(this.empresaPerfils));
					this.showMessage(this.translateKey('component.restapi.form.manteniment.deleted'));
					this.disableSelects = false;
				});
			} else {
				this.empresaPerfils[index].ids.splice(pos, 1);
				this.epo = JSON.parse(JSON.stringify(this.empresaPerfils));
				this.showMessage(this.translateKey('component.restapi.form.manteniment.deleted'));
				this.disableSelects = false;
			}
		});
	}

	private createPerfilEmpresa(perfilUsuariEmpresa, index) {
		this.perfilUsuariEmpresaService.create(<PerfilUsuariEmpresa>perfilUsuariEmpresa).subscribe((resposta: any) => {
			let pos = this.empresaPerfils[index].perfils.indexOf(perfilUsuariEmpresa.perfil.id);
			if (pos == this.empresaPerfils[index].ids.length) {
				this.empresaPerfils[index].ids.push(resposta.id);
			} else {
				this.empresaPerfils[index].ids.splice(pos, 0, resposta.id);
			}
			this.epo = JSON.parse(JSON.stringify(this.empresaPerfils));
			this.showMessage(this.translateKey('component.restapi.form.manteniment.created'));
			this.disableSelects = false;
		});
	}

	private usuariTeImatge() {
		return this.usuari != null && this.usuari.imatgeUrl != null && this.usuari.imatgeUrl != '';
	}

	private generateTableData() {
		this.empresaPerfils = [];
		this.empreses.forEach((empresa) => {
			if (empresa.activa) {
				let usuariEmpresa = this.usuariEmpreses.find(item => item.empresa.id == empresa.id);
				let usuariEmpresaId = null;
				let perfilsUsuariEmpresaId = [];
				let perfilsId = [];
				if (usuariEmpresa) {
					usuariEmpresaId = usuariEmpresa.id;
					let perfilsUsuariEmpresa = this.perfilsUsuariEpresa.filter(item => item.usuariEmpresa.id == usuariEmpresa.id);
					perfilsId = perfilsUsuariEmpresa.map(item => item.perfil.id);
					perfilsUsuariEmpresaId = perfilsUsuariEmpresa.map(item => item.id);
				}
				let empresaPerfil: EmpresaPerfil = {
					empresaId: empresa.id,
					empresaNom: empresa.nom,
					usuariEmpresaId: usuariEmpresaId,
					ids: perfilsUsuariEmpresaId,
					perfils: perfilsId
				};

				this.empresaPerfils.push(empresaPerfil);
			}
		});
		this.epo = JSON.parse(JSON.stringify(this.empresaPerfils));
		//this.table.renderRows();
	}

	private showMessage(message: string) {
		const snackbarRef = this.snackbar.open(
			message,
			this.translateKey('component.restapi.form.manteniment.button.close'), {
			duration: 1000
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
