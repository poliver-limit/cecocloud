import { EmpresesService } from '../empreses/empreses.service';
import { PerfilsService } from '../perfils/perfils.service';
import { Resource, HalParam } from 'angular4-hal';
import { Component, OnDestroy, ViewChild } from "@angular/core";
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from "@ngx-translate/core";
import { Subscription } from 'rxjs';

import { BngScreenSizeChangeEvent, BngScreenSizeService, BngFormConfig } from '@programari-limit/base-angular';
import { BngRestapiProfile } from '@programari-limit/base-angular/lib/restapi/restapi-profile';

import { MatTable, MatSnackBar } from '@angular/material';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { UsuarisService } from './usuaris.service';
import { UsuariIdentificadorEmpresaService, UsuariIdentificadorEmpresa } from 'src/app/shared/usuari-identificador-empresa.service';
import { UsuariIdentificadorsService } from './usuari-identificadors.service';
import { PerfilUsuariIdentificadorEmpresaService, PerfilUsuariIdentificadorEmpresa } from 'src/app/shared/funcionalitats-permisos/perfil-usuari-identificador-empresa.service';


export interface EmpresaPerfil {
	empresaNom: string;
	empresaId: number;
	usuariIdentificadorEmpresaId: string;
	ids: string[];
	perfils: number[];
}

@Component({
	template: `
	<bng-form
		bng-form-mant
		[config]="formConfig"
		[restapiService]="usuariIdentificadorService">
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
				<mat-tab-group animationDuration="0ms">
					<mat-tab label="{{'resource.usuariIdentificador.perfils'|translate}}">
						<!-- Pestanya de permisos -->
						<table mat-table [dataSource]="empresaPerfils" multiTemplateDataRows class="mat-elevation-z8" style="width:100%;">
							<!-- Columna de empresa -->
							<ng-container matColumnDef="nom">
								<th mat-header-cell *matHeaderCellDef> {{'resource.empresa' | translate}} </th>
								<td mat-cell *matCellDef="let empresa">
									<button mat-button class="bdown">
										<mat-icon (click)="this.expandedEmpresa = this.expandedEmpresa === empresa ? null : empresa">keyboard_arrow_down</mat-icon>
									</button>
									{{empresa.empresaNom}}
								</td>
							</ng-container>
							<!-- Columna de perfils -->
							<ng-container matColumnDef="perfils">
								<th mat-header-cell *matHeaderCellDef> {{'resource.perfil.plural' | translate}} </th>
								<td mat-cell *matCellDef="let empresa; let index = dataIndex">
									<mat-select [disabled]="disableSelects" [(value)]="empresa.perfils" multiple placeholder="Sense accés" (selectionChange)="onPerfilChange($event, index)">
										<mat-option *ngFor="let perfil of perfils" [value]="perfil.id">{{perfil.codi}}</mat-option>
									</mat-select>
								</td>
							</ng-container>
							<!-- Detall de permisos -->
							<ng-container matColumnDef="expandedDetail">
								<td mat-cell *matCellDef="let empresa" [attr.colspan]="columnsToDisplay.length">
									<div class="empresa-permisos-detail" [@detailExpand]="empresa == expandedEmpresa ? 'expanded' : 'collapsed'">
										<cec-funcionalitats [usuariIdentificadorEmpresa] = "{'identificadorId': identificadorId,'empresaId': empresa.empresaId, 'usuariCodi': usuari.codi}" style="width:100%;"></cec-funcionalitats>
									</div>
								</td>
							</ng-container>
							<tr mat-header-row *matHeaderRowDef="columnsToDisplay"></tr>
							<tr mat-row *matRowDef="let empresa; columns: columnsToDisplay;"
								[class.empresa-expanded-row]="expandedEmpresa === empresa">
							</tr>
							<tr mat-row *matRowDef="let row; columns: ['expandedDetail']" class="empresa-permisos-row"></tr>
						</table>
					</mat-tab>
				</mat-tab-group>
			</div>
		</div>
	</bng-form>
	`,
	animations: [
		trigger('detailExpand', [
			state('collapsed', style({ height: '0px', minHeight: '0' })),
			state('expanded', style({ height: '*' })),
			transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
		]),
	],
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
	tr.empresa-permisos-row {
		height: 0;
	}

	tr.empresa-permisos-row:not(.example-expanded-row):hover {
	background: #777;
	}

	tr.empresa-permisos-row:not(.example-expanded-row):active {
	background: #efefef;
	}

	.empresa-permisos-row td {
	border-bottom-width: 0;
	}
	.empresa-permisos-detail {
  		overflow: hidden;
  		display: flex;
	}
	.mat-column-nom {
		width: 25%;
		flex: 0 0 25% !important;
	}
	.mat-column-perfils {
		width: 75%;
		flex: 0 0 75% !important;
	}
	.bdown {
		min-width: 24px;
		padding: 0px;
	}
	`]
})
export class UsuariIdentificadorsFormComponent implements OnDestroy {

	@ViewChild(MatTable, null) table: MatTable<any>;

	id: any;
	formConfig: BngFormConfig = {
		readOnlyStateEnabled: true
	};

	public translate: TranslateService;
	private routeSub: Subscription;

	usuariIdentificadorId: string;
	identificadorId: number;
	currentRouteUrl: string;
	mobileScreen: boolean;
	hasSavePermission: boolean;
	title: string;

	usuari: any;
	empreses: any[];
	usuariIdentificadorEmpreses: any[];
	perfilsUsuariIdentificadorEmpresa: any[];
	perfils: any[];
	empresaPerfils: EmpresaPerfil[];
	epo: EmpresaPerfil[];

	columnsToDisplay: string[] = ['nom', 'perfils'];
	expandedEmpresa: any | null;
	disableSelects: boolean = false;

	ngOnDestroy() {
		this.routeSub.unsubscribe();
	}

	onButtonCancelClick() {
		const index = this.currentRouteUrl.indexOf('/update');
		this.router.navigate([this.currentRouteUrl.substring(0, index)]);
	}

	onPerfilChange(event, index) {
		// Deshabilitar selects mentres s'està creant/eliminant el perfil
		this.disableSelects = true;
		const perfilsNous = this.empresaPerfils[index].perfils.filter(item => this.epo[index].perfils.indexOf(item) < 0);
		if (perfilsNous.length > 0) {
			const usuariIdentificadorEmpresaId = this.empresaPerfils[index].usuariIdentificadorEmpresaId;
			if (usuariIdentificadorEmpresaId) {
				const perfilUsuariIdentificadorEmpresa: any = {
					usuariIdentificadorEmpresa: { id: usuariIdentificadorEmpresaId },
					perfil: { id: perfilsNous[0] }
				};
				this.createPerfilEmpresa(perfilUsuariIdentificadorEmpresa, index);
			} else {
				// Crear l'usuari-identificador-empresa si no existeix
				const usuariIdentificadorEmpresa: any = {
					usuariIdentificador: { id: this.usuariIdentificadorId },
					empresa: { id: this.empresaPerfils[index].empresaId }
				};
				this.usuariIdentificadorEmpresaService.create(usuariIdentificadorEmpresa as UsuariIdentificadorEmpresa).subscribe((resposta: any) => {
					this.empresaPerfils[index].usuariIdentificadorEmpresaId = resposta.id;
					const perfilUsuariIdentificadorEmpresa: any = {
						usuariIdentificadorEmpresa: { id: resposta.id },
						perfil: { id: perfilsNous[0] }
					};
					this.createPerfilEmpresa(perfilUsuariIdentificadorEmpresa, index);
				});
			}
		} else {
			const perfilsEliminats = this.epo[index].perfils.filter(item => this.empresaPerfils[index].perfils.indexOf(item) < 0);
			if (perfilsEliminats.length > 0) {
				const pos = this.epo[index].perfils.indexOf(perfilsEliminats[0]);
				const perfilUsuariIdentificadorEmpresaId = this.epo[index].ids[pos];
				// Eliminar el perfil-usuari-empresa
				this.deletePerfilEmpresa(
					perfilUsuariIdentificadorEmpresaId,
					index,
					pos,
					this.empresaPerfils[index].perfils.length === 0);
			} else {
				this.disableSelects = false;
			}
		}
	}

	private deletePerfilEmpresa(perfilUsuariIdentificadorEmpresaId, index, pos, ultim) {
		// Eliminar el perfil-usuari-empresa
		this.perfilUsuariIdentificadorEmpresaService.deleteById(perfilUsuariIdentificadorEmpresaId).subscribe((resposta: any) => {
			if (ultim) {
				// Eliminar l'usuari-empresa
				this.usuariIdentificadorEmpresaService.deleteById(this.empresaPerfils[index].usuariIdentificadorEmpresaId).subscribe(() => {
					this.empresaPerfils[index].usuariIdentificadorEmpresaId = null;
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

	private createPerfilEmpresa(perfilUsuariIdentificadorEmpresa, index) {
		this.perfilUsuariIdentificadorEmpresaService.create(perfilUsuariIdentificadorEmpresa as PerfilUsuariIdentificadorEmpresa).subscribe((resposta: any) => {
			const pos = this.empresaPerfils[index].perfils.indexOf(perfilUsuariIdentificadorEmpresa.perfil.id);
			if (pos === this.empresaPerfils[index].ids.length) {
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
		return this.usuari != null && this.usuari.imatgeUrl != null && this.usuari.imatgeUrl !== '';
	}

	private generateTableData() {
		this.empresaPerfils = [];
		this.empreses.forEach((empresa) => {
			if (empresa.activa) {
				const usuariIdenticadorEmpresa = this.usuariIdentificadorEmpreses.find(item => item.empresa.id === empresa.id);
				let usuariIdentificadorEmpresaId = null;
				let perfilsUsuariIdentificadorEmpresaId = [];
				let perfilsId = [];
				if (usuariIdenticadorEmpresa) {
					usuariIdentificadorEmpresaId = usuariIdenticadorEmpresa.id;
					const perfilsUsuariIdentificadorEmpresa = this.perfilsUsuariIdentificadorEmpresa.filter(item => item.usuariIdentificadorEmpresa.id === usuariIdenticadorEmpresa.id);
					perfilsId = perfilsUsuariIdentificadorEmpresa.map(item => item.perfil.id);
					perfilsUsuariIdentificadorEmpresaId = perfilsUsuariIdentificadorEmpresa.map(item => item.id);
				}
				const empresaPerfil: EmpresaPerfil = {
					empresaId: empresa.id,
					empresaNom: empresa.nom,
					usuariIdentificadorEmpresaId: usuariIdentificadorEmpresaId,
					ids: perfilsUsuariIdentificadorEmpresaId,
					perfils: perfilsId
				};

				this.empresaPerfils.push(empresaPerfil);
			}
		});
		this.epo = JSON.parse(JSON.stringify(this.empresaPerfils));
		// this.table.renderRows();
	}

	private showMessage(message: string) {
		const snackbarRef = this.snackbar.open(
			message,
			this.translateKey('component.restapi.form.manteniment.button.close'), {
			duration: 1000
		});
	}

	translateKey(key: string, params?: any, defaultValue?: string) {
		const translatedKey = this.translate.instant(key, params);
		if (defaultValue) {
			return (translatedKey !== key) ? translatedKey : defaultValue;
		} else {
			return translatedKey;
		}
	}

	constructor(
		public usuarisService: UsuarisService,
		public usuariIdentificadorService: UsuariIdentificadorsService,
		public usuariIdentificadorEmpresaService: UsuariIdentificadorEmpresaService,
		public empresaService: EmpresesService,
		public perfilsService: PerfilsService,
		public perfilUsuariIdentificadorEmpresaService: PerfilUsuariIdentificadorEmpresaService,
		translate: TranslateService,
		private router: Router,
		private route: ActivatedRoute,
		private screenSizeService: BngScreenSizeService,
		private snackbar: MatSnackBar) {

		this.currentRouteUrl = this.router.url;
		this.translate = translate;
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: BngScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile;
		});
		this.routeSub = this.route.params.subscribe((params) => {
			if (params.id) {
				this.usuariIdentificadorId = params.id;
				this.usuariIdentificadorService.whenReady().subscribe((restapiProfile: BngRestapiProfile) => {
					this.title = this.translateKey(restapiProfile.resource.translateKey);
					this.hasSavePermission = restapiProfile.resource.hasUpdatePermission;
					this.usuariIdentificadorService.get(this.usuariIdentificadorId).subscribe((usuariIdentificador: any) => {
						this.identificadorId = usuariIdentificador.identificador.id;
						this.usuarisService.get(usuariIdentificador.usuari.id).subscribe((usuari: Resource) => {
							this.usuari = usuari;
							// Obtenim totes les empreses de la companyia
							this.empresaService.whenReady().subscribe(() => {
								const requestParams: HalParam[] = [];
								requestParams.push({ key: 'sort', value: 'nom,ASC' });
								this.empresaService.getAll({ params: requestParams }).subscribe((eResponse: any) => {
									this.empreses = eResponse;
									// Obtenim totes les empreses que estan associades a l'usuari
									this.usuariIdentificadorEmpresaService.whenReady().subscribe(() => {
										const ueRequestParams: HalParam[] = [];
										ueRequestParams.push({ key: 'query', value: 'usuariIdentificador.id==' + this.usuariIdentificadorId });
										ueRequestParams.push({ key: 'sort', value: 'empresa.nom,ASC' });
										this.usuariIdentificadorEmpresaService.getAll({ params: ueRequestParams }).subscribe((response: any) => {
											this.usuariIdentificadorEmpreses = response;
											// Obtenim tots els perfils-empresa de l'usuari
											this.perfilUsuariIdentificadorEmpresaService.whenReady().subscribe(() => {
												this.perfilUsuariIdentificadorEmpresaService.getAll().subscribe((puResponse: any) => {
													this.perfilsUsuariIdentificadorEmpresa = puResponse;
													// Obtenim tots els perfils de la companyia
													this.perfilsService.whenReady().subscribe((/*restapiProfile: BngRestapiProfile*/) => {
														const pRequestParams: HalParam[] = [];
														pRequestParams.push({ key: 'sort', value: 'codi,ASC' });
														this.perfilsService.getAll({ params: pRequestParams }).subscribe((pResponse: any) => {
															this.perfils = pResponse;
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
