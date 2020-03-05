import { Component, Input, OnInit } from "@angular/core";

import { MatSnackBar } from "@angular/material/snack-bar";
import { TranslateService } from "@ngx-translate/core";
import {
	BngScreenSizeService,
	BngScreenSizeChangeEvent
} from "@programari-limit/base-angular";
import { HalParam } from '@lagoshny/ngx-hal-client';
import { PerfilUsuariIdentificadorEmpresaService } from "./perfil-usuari-identificador-empresa.service";
import {
	FuncionalitatIdentificador
} from "./funcionalitats-identificador.service";
import { PerfilService } from './perfil.service';

@Component({
	selector: "cec-funcionalitats",
	template: `
		<!-- <div class="ample-complet" style="display: flex; text-align: right;">
			<button *ngIf="perfil" mat-button>
				<mat-icon aria-hidden="false"
					aria-label="Example home icon"
					(click)="onRefreshPermisos()">refresh</mat-icon>
			</button>
		</div> -->
		<div style="display: flex">
			<div class="ample-complet">
				<mat-tab-group animationDuration="0ms">
					<mat-tab
						*ngFor="let funcionalitatsModul of funcionalitatsModuls; let indexModul = index"
						label="{{ 'app.module.' + funcionalitatsModul.module.code | translate }}">

						<!-- <div [style.height.px]="tableHeight" class="permisos-container"> -->
						<table
							mat-table
							[dataSource]="funcionalitatsModul.funcionalitats"
							class="mat-elevation-z8"
							style="width:100%;">

							<!-- Columna de nom de la funcionalitat -->
							<ng-container matColumnDef="label">
								<th mat-header-cell *matHeaderCellDef style="">
									{{ "resource.funcionalitat" | translate }}
								</th>
								<td mat-cell *matCellDef="let funcionalitat">
									{{ ("funcionalitat." + funcionalitat.codi) | translate }}
								</td>
							</ng-container>

							<!-- Columna de read -->
							<ng-container matColumnDef="read">
								<th mat-header-cell
									*matHeaderCellDef
									[ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
									<ng-container *ngIf="!mobileScreen">{{"resource.permission.field.readGranted" | translate}}</ng-container>
									<ng-container *ngIf="mobileScreen">{{"resource.permission.field.readGranted.min" | translate}}</ng-container>
								</th>
								<td mat-cell *matCellDef="let funcionalitat; let index = index" class="rcheck">
									<mat-checkbox
										name="readGranted"
										[checked]="funcionalitat.permission.readGranted"
										[disabled]="disableToggles || !funcionalitat.allowedPermission.readGranted"
										(click)="!disableToggles &&
												funcionalitat.allowedPermission.readGranted &&
												funcionalitat.tipus == 'MANTENIMENT' &&
												onPermisChange($event, indexModul, index)">
									</mat-checkbox>
								</td>
							</ng-container>

							<!-- Columna de create -->
							<ng-container matColumnDef="create">
								<th mat-header-cell
									*matHeaderCellDef
									[ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
									<ng-container *ngIf="!mobileScreen">{{"resource.permission.field.createGranted" | translate}}</ng-container>
									<ng-container *ngIf="mobileScreen">{{"resource.permission.field.createGranted.min" | translate}}</ng-container>
								</th>
								<td mat-cell *matCellDef="let funcionalitat; let index = index" class="rcheck">
									<mat-checkbox
										name="createGranted"
										[checked]="funcionalitat.permission.createGranted"
										[disabled]="disableToggles || !funcionalitat.allowedPermission.createGranted"
										(click)="!disableToggles &&
												funcionalitat.allowedPermission.createGranted &&
												funcionalitat.tipus == 'MANTENIMENT' &&
												onPermisChange($event, indexModul, index)">
									</mat-checkbox>
								</td>
							</ng-container>

							<!-- Columna de write -->
							<ng-container matColumnDef="write">
								<th mat-header-cell
									*matHeaderCellDef
									[ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen }">
									<ng-container *ngIf="!mobileScreen">{{"resource.permission.field.writeGranted" | translate}}</ng-container>
									<ng-container *ngIf="mobileScreen">{{"resource.permission.field.writeGranted.min" | translate}}</ng-container>
								</th>
								<td mat-cell *matCellDef="let funcionalitat; let index = index" class="rcheck">
									<mat-checkbox
										name="writeGranted"
										[checked]="funcionalitat.permission.writeGranted"
										[disabled]="disableToggles || !funcionalitat.allowedPermission.writeGranted"
										(click)="!disableToggles &&
												funcionalitat.allowedPermission.writeGranted &&
												funcionalitat.tipus == 'MANTENIMENT' &&
												onPermisChange($event, indexModul, index)">
									</mat-checkbox>
								</td>
							</ng-container>

							<!-- Columna de delete -->
							<ng-container matColumnDef="delete">
								<th mat-header-cell
									*matHeaderCellDef
									[ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
									<ng-container *ngIf="!mobileScreen">{{"resource.permission.field.deleteGranted" | translate}}</ng-container>
									<ng-container *ngIf="mobileScreen">{{"resource.permission.field.deleteGranted.min" | translate}}</ng-container>
								</th>
								<td mat-cell *matCellDef="let funcionalitat; let index = index" class="rcheck">
									<mat-checkbox
										name="deleteGranted"
										[checked]="funcionalitat.permission.deleteGranted"
										[disabled]="disableToggles || !funcionalitat.allowedPermission.deleteGranted"
										(click)="!disableToggles &&
												funcionalitat.allowedPermission.deleteGranted &&
												funcionalitat.tipus == 'MANTENIMENT' &&
												onPermisChange($event, indexModul, index)">
									</mat-checkbox>
								</td>
							</ng-container>

							<!-- Columna de execute -->
							<ng-container matColumnDef="execute">
								<th mat-header-cell
									*matHeaderCellDef
									[ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
									<ng-container *ngIf="!mobileScreen">{{"resource.permission.field.executeGranted" | translate}}</ng-container>
									<ng-container *ngIf="mobileScreen">{{"resource.permission.field.executeGranted.min" | translate}}</ng-container>
								</th>
								<td	mat-cell *matCellDef="let funcionalitat; let index = index" class="rcheck">
									<mat-checkbox
										name="executeGranted"
										[checked]="funcionalitat.permission.executeGranted"
										[disabled]="disableToggles || !funcionalitat.allowedPermission.executeGranted"
										(click)="!disableToggles &&
												funcionalitat.allowedPermission.executeGranted &&
												funcionalitat.tipus != 'MANTENIMENT' &&
												onPermisChange($event, indexModul, index)">
									</mat-checkbox>
								</td>
							</ng-container>

							<!-- Columna de altres permisos -->
							<ng-container matColumnDef="altres">
								<th mat-header-cell
									*matHeaderCellDef
									[ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}"
									style="width:16%;">
									<ng-container *ngIf="!mobileScreen">{{"resource.permission.field.altres" | translate}}</ng-container>
									<ng-container *ngIf="mobileScreen"></ng-container>
								</th>
								<td	mat-cell *matCellDef="let funcionalitat; let index = index" class="rcheck" style="padding-top: 14px;">
									<mat-select *ngIf="funcionalitat.allowedPermission.adminGranted ||
												funcionalitat.allowedPermission.perm1Granted ||
												funcionalitat.allowedPermission.perm2Granted ||
												funcionalitat.allowedPermission.perm3Granted"
										[disabled]="disableToggles"
										[(value)]="funcionalitat.permission.selectedCustom"
										multiple>
										<mat-select-trigger>{{getCustomReducedLabel(indexModul, index)}}</mat-select-trigger>
										<mat-option *ngIf="funcionalitat.allowedPermission.adminGranted" value="admin" (onSelectionChange)="onCustomPermisChange($event, indexModul, index)">{{"resource.permission.field.adminGranted" | translate}}</mat-option>
										<mat-option *ngIf="funcionalitat.allowedPermission.perm1Granted" value="perm1" (onSelectionChange)="onCustomPermisChange($event, indexModul, index)">{{ ("funcionalitat." + funcionalitat.codi + ".permis.perm1") | translate }}</mat-option>
										<mat-option *ngIf="funcionalitat.allowedPermission.perm2Granted" value="perm2" (onSelectionChange)="onCustomPermisChange($event, indexModul, index)">{{ ("funcionalitat." + funcionalitat.codi + ".permis.perm2") | translate }}</mat-option>
										<mat-option *ngIf="funcionalitat.allowedPermission.perm3Granted" value="perm3" (onSelectionChange)="onCustomPermisChange($event, indexModul, index)">{{ ("funcionalitat." + funcionalitat.codi + ".permis.perm3") | translate }}</mat-option>
									</mat-select>
								</td>
							</ng-container>

							<!-- Capçaleres i columnes a mostrar -->
							<tr mat-header-row *matHeaderRowDef="columnsToDisplay; sticky: true"></tr>
							<tr mat-row *matRowDef="let rows; columns: columnsToDisplay"></tr>
						</table>
						<!-- </div> -->
					</mat-tab>
				</mat-tab-group>
			</div>
		</div>
	`,
	styles: [
		`
			.rcheck {
				text-align: center;
			}
			.htoggle-mobile {
				width: 8%;
				min-width: 30px;
				max-width: 50px;
				text-align: center;
			}
			.htoggle-desktop {
				width: 8%;
				min-width: 60px;
				max-width: 60px;
				text-align: center;
			}
			.mat-checkbox-disabled {
				opacity: 0.78;
			}
			.ample-complet {
				width: 100%;
				margin-top: 40px;
			}
			.mat-elevation-z8 {
				box-shadow: 0px 0px 0px 0px rgba(0, 0, 0, 0) !important;
				overflow: hidden !important;
			}
		`
	]
})
export class FuncionalitatsPermisosComponent implements OnInit {
	@Input() perfil: number;
	@Input() usuariIdentificadorEmpresa: any;

	public translate: TranslateService;
	funcionalitatsModuls: any;
	funcionalitats: FuncionalitatIdentificador[];
	columnsToDisplay: string[] = [
		"label",
		"read",
		"create",
		"write",
		"delete",
		"execute",
		"altres"
	];

	disableToggles: boolean = true;

	mobileScreen: boolean;
	tableHeight: number;

	onCustomPermisChange(event, indexModul, indexRecurs) {
		if (event.isUserInput) {
			const modulCodi = this.funcionalitatsModuls[indexModul].module.code;
			const funcionalitatInfo = JSON.parse(
				JSON.stringify(
					this.funcionalitatsModuls[indexModul].funcionalitats[indexRecurs]
				)
			);

			const permis = event.source.value;
			const check = event.source.selected;

			const customPermisos: string[] = funcionalitatInfo.permission.selectedCustom;
			switch (permis) {
				case "admin": funcionalitatInfo.permission.adminGranted = check; break;
				case "perm1": funcionalitatInfo.permission.perm1Granted = check; break;
				case "perm2": funcionalitatInfo.permission.perm2Granted = check; break;
				case "perm3": funcionalitatInfo.permission.perm3Granted = check; break;
			}

			this.perfilService
				.saveFuncionalitat(this.perfil, funcionalitatInfo)
				.subscribe(
					() => {
						this.funcionalitatsModuls[indexModul].funcionalitats[indexRecurs].permission[permis + "Granted"] = check;
					},
					error => {
						switch (permis) {
							case "admin": this.funcionalitatsModuls[indexModul].funcionalitats[indexRecurs].permission.adminGranted = !check; break;
							case "perm1": this.funcionalitatsModuls[indexModul].funcionalitats[indexRecurs].permission.perm1Granted = !check; break;
							case "perm2": this.funcionalitatsModuls[indexModul].funcionalitats[indexRecurs].permission.perm2Granted = !check; break;
							case "perm3": this.funcionalitatsModuls[indexModul].funcionalitats[indexRecurs].permission.perm3Granted = !check; break;
						}
						this.showMessage(this.translateKey('funcionalitat.permis.modificar.error'));
					}
				);
		}
	}

	onPermisChange(event, indexModul, indexRecurs) {
		event.preventDefault();
		const modulCodi = this.funcionalitatsModuls[indexModul].module.code;
		const funcionalitatInfo = JSON.parse(
			JSON.stringify(
				this.funcionalitatsModuls[indexModul].funcionalitats[indexRecurs]
			)
		);
		const permis = event.currentTarget.attributes.name.value;
		const check = !funcionalitatInfo.permission[permis];
		funcionalitatInfo.permission[permis] = check;

		this.perfilService
			.saveFuncionalitat(this.perfil, funcionalitatInfo)
			.subscribe(
				() => {
					this.funcionalitatsModuls[indexModul].funcionalitats[
						indexRecurs
					].permission[permis] = check;
				},
				error => {
					event.preventDefault();
					this.showMessage(this.translateKey('funcionalitat.permis.modificar.error'));
				}
			);
	}

	// onRefreshPermisos() {
	// 	this.perfilService.refreshPermisosPerfil(this.perfil).subscribe(() => {

	// 	});
	// }

	getCustomReducedLabel(indexModul, indexRecurs) {
		const funcionalitat = this.funcionalitatsModuls[indexModul].funcionalitats[indexRecurs];
		let label = "";
		if (funcionalitat.permission.adminGranted) {
			label += this.translateKey("resource.permission.field.adminGranted.min", null, "Adm") + ", ";
		}
		if (funcionalitat.permission.perm1Granted) {
			label += this.translateKey("funcionalitat." + funcionalitat.codi + ".permis.perm1.min", null, "P1") + ", ";
		}
		if (funcionalitat.permission.perm2Granted) {
			label += this.translateKey("funcionalitat." + funcionalitat.codi + ".permis.perm2.min", null, "P2") + ", ";
		}
		if (funcionalitat.permission.perm3Granted) {
			label += this.translateKey("funcionalitat." + funcionalitat.codi + ".permis.perm3.min", null, "P3") + ", ";
		}
		if (label.length > 0)
			label = label.substring(0, label.length - 2);

		return label;
	}

	private showMessage(message: string) {
		const snackbarRef = this.snackbar.open(
			message,
			this.translateKey('component.restapi.form.manteniment.button.close'), {
			duration: 5000
		});
	}

	translateKey(key: string, params?: any, defaultValue?: string) {
		const translatedKey = this.translate.instant(key, params);
		if (defaultValue) {
			return translatedKey !== key ? translatedKey : defaultValue;
		} else {
			return translatedKey;
		}
	}

	ngOnInit(): void {
		// Càrrega de permisos
		if (this.perfil) {
			this.disableToggles = false;
			this.perfilService.whenReady().subscribe(() => {
				this.perfilService.getFuncionalitatsByPerfil(this.perfil).subscribe(funcionalitatsModuls => {
					this.funcionalitatsModuls = funcionalitatsModuls;
					console.log("Funcionalitats: ", this.funcionalitatsModuls);
				});
			});
		} else if (this.usuariIdentificadorEmpresa) {
			const requestParams: HalParam[] = [];
			requestParams.push({
				key: "query",
				value:
					'usuariIdentificadorEmpresa.usuariIdentificador.usuari.codi=="' +
					this.usuariIdentificadorEmpresa.usuariCodi +
					'";' +
					' usuariIdentificadorEmpresa.usuariIdentificador.identificador.id=="' +
					this.usuariIdentificadorEmpresa.identificadorId +
					'";' +
					" usuariIdentificadorEmpresa.empresa.id==" +
					this.usuariIdentificadorEmpresa.empresaId
			});
			this.perfilUsuariIdentificadorEmpresaService.whenReady().subscribe(() => {
				this.perfilUsuariIdentificadorEmpresaService.getAll({ params: requestParams }).subscribe(perfilUsuariIdentificadorEmpreses => {
					if (
						perfilUsuariIdentificadorEmpreses == null ||
						perfilUsuariIdentificadorEmpreses.length === 0
					) {
						this.perfilService.getFuncionalitatsByPerfil(-1).subscribe(funcionalitatsModuls => {
							this.funcionalitatsModuls = funcionalitatsModuls;
						});
					} else {
						let perfils: number[];
						// if (
						// 	perfilUsuariIdentificadorEmpreses == null ||
						//	perfilUsuariIdentificadorEmpreses.length === 0
						// ) {
						// 	perfils = [-1];
						// } else {
						perfils = perfilUsuariIdentificadorEmpreses.map(
							puie => puie.perfil.id
						);
						// }
						this.perfilService.getFuncionalitatsByPerfils(perfils).subscribe(funcionalitatsModuls => {
							//console.log("FuncionalitatsPerfil: ", funcionalitatsModuls);
							this.funcionalitatsModuls = funcionalitatsModuls;
						});
					}
				});
			});
		}
	}

	constructor(
		public perfilService: PerfilService,
		public perfilUsuariIdentificadorEmpresaService: PerfilUsuariIdentificadorEmpresaService,
		translate: TranslateService,
		private screenSizeService: BngScreenSizeService,
		private snackbar: MatSnackBar) {
		this.translate = translate;
		this.mobileScreen = this.screenSizeService.isMobile();
		// this.tableHeight = Math.max(window.innerHeight - 490, 200);
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: BngScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile;
			// this.tableHeight = Math.max(event.height - 120, 200);
		});
	}

}
