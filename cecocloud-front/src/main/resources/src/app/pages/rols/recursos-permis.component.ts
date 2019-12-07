import { PerfilUsuariEmpresaService } from './../companyia-usuaris/perfil-usuari-empresa.service';
import { PerfilRolService } from './../perfils/perfilRol.service';
import { Component, Input, OnInit } from '@angular/core';

import { RecursosService } from 'src/app/shared/recusros.service';
import { MatSnackBar } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';
import { BngScreenSizeService, BngScreenSizeChangeEvent } from '@programari-limit/base-angular';
import { HalParam } from 'angular4-hal';

@Component({
	selector: "cec-recursos",
	template: `
        <div style="display: flex">
			<div style="width: 100%; margin-top: 40px;">
                <mat-tab-group>
                    <mat-tab *ngFor="let recursosModul of recursosModuls; let index = index" label="{{'app.module.' + recursosModul.module.code |translate}}">
                    <div [style.height.px]="tableHeight" class="permisos-container">
                        <table mat-table [dataSource]="recursosModul.resources" class="mat-elevation-z8" style="width:100%;">
                                <!-- Columna de nom Recurs -->
                                <ng-container matColumnDef="label">
                                    <th mat-header-cell *matHeaderCellDef style=""> {{'resource.label' | translate}} </th>
                                    <td mat-cell *matCellDef="let recurs"> {{recurs.label | translate}} </td>
                                </ng-container>
                                <!-- Columna de read -->
                                <ng-container matColumnDef="read">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.permis.read' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">CON</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs">
                                        <mat-slide-toggle
                                            [ngClass]="{'toggle-mobile': mobileScreen}"
                                            [checked]="recurs.permission.readGranted"
                                            [disabled]="disableToggles">
                                        </mat-slide-toggle>
                                    </td>
                                </ng-container>
                                <!-- Columna de write -->
                                <ng-container matColumnDef="write">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.permis.write' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">MOD</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs">
                                        <mat-slide-toggle
                                            [ngClass]="{'toggle-mobile': mobileScreen}"
                                            [checked]="recurs.permission.writeGranted"
                                            [disabled]="disableToggles">
                                        </mat-slide-toggle>
                                    </td>
                                </ng-container>
                                <!-- Columna de create -->
                                <ng-container matColumnDef="create">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.permis.create' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">CRE</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs">
                                        <mat-slide-toggle
                                            [ngClass]="{'toggle-mobile': mobileScreen}"
                                            [checked]="recurs.permission.createGranted"
                                            [disabled]="disableToggles">
                                        </mat-slide-toggle>
                                    </td>
                                </ng-container>
                                <!-- Columna de delete -->
                                <ng-container matColumnDef="delete">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.permis.delete' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">BOR</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs">
                                        <mat-slide-toggle
                                            [ngClass]="{'toggle-mobile': mobileScreen}"
                                            [checked]="recurs.permission.deleteGranted"
                                            [disabled]="disableToggles">
                                        </mat-slide-toggle>
                                    </td>
                                </ng-container>
                                <!-- Columna de administration -->
                                <ng-container matColumnDef="administration">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.permis.administration' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">ADM</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs">
                                        <mat-slide-toggle
                                            [ngClass]="{'toggle-mobile': mobileScreen}"
                                            [checked]="recurs.permission.adminGranted"
                                            [disabled]="disableToggles">
                                        </mat-slide-toggle>
                                    </td>
                                </ng-container>
                                <!-- Columna de print -->
                                <ng-container matColumnDef="print">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.permis.print' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">IMP</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs">
                                        <mat-slide-toggle
                                            [ngClass]="{'toggle-mobile': mobileScreen}"
                                            [checked]="recurs.permission.printGranted"
                                            [disabled]="disableToggles">
                                        </mat-slide-toggle>
                                    </td>
                                </ng-container>
                                <tr mat-header-row *matHeaderRowDef="columnsToDisplay; sticky: true"></tr>
                                <tr mat-row *matRowDef="let rows; columns: columnsToDisplay"></tr>
                            </table>
                        </div>
                    </mat-tab>
                </mat-tab-group>
            </div>
        </div>
    `,
	styles: [`
        .toggle-mobile {
            transform: rotate(270deg);
        }
        .htoggle-mobile {
            width:8%;
            min-width:30px;
            max-width:50px;
            text-align: center;
        }
        .htoggle-desktop {
            width:8%;
            min-width:60px;
            max-width:60px;
            text-align: center;
        }
    `]
})
export class RecursosPermisComponent implements OnInit {

	@Input() rol: number;
	@Input() perfil: number;
	@Input() usuariEmpresa: string;

	public translate: TranslateService;
	recursosModuls: any;
	columnsToDisplay: string[] = ['label', 'read', 'write', 'create', 'delete', 'administration', 'print'];
	disableToggles: boolean = (this.rol != null);

	mobileScreen: boolean;
	tableHeight: number;

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

	ngOnInit(): void {
		// Càrrega de permisos
		if (this.rol) {
			this.recursosService.getRecursosByRol(this.rol).subscribe((recursosModuls) => {
				this.recursosModuls = recursosModuls;
			});
		} else if (this.perfil) {
			let requestParams: HalParam[] = [];
			requestParams.push({
				key: 'query',
				value: 'perfil.id==' + this.perfil
			});
			this.perfilRolService.getAll({ params: requestParams }).subscribe((perfilRols) => {
				let rols: number[];
				if (perfilRols == null || perfilRols.length == 0) {
					rols = [-1];
				} else {
					rols = perfilRols.map(perfilRol => perfilRol['rol'].id);
				}
				this.recursosService.getRecursosByRols(rols).subscribe((recursosModuls) => {
					console.log("RecursosRol: ", recursosModuls);
					this.recursosModuls = recursosModuls;
				});
			});
		} else if (this.usuariEmpresa) {
			let requestParams: HalParam[] = [];
			requestParams.push({
				key: 'query',
				value: 'usuariEmpresa.id==' + this.usuariEmpresa
			});
			this.perfilUsuariEmpresaService.getAll({ params: requestParams }).subscribe((perfilUsuariEmpreses) => {
				let perfilsUsuari: string[];
				if (perfilUsuariEmpreses == null || perfilUsuariEmpreses.length == 0) {
					this.recursosService.getRecursosByRol(-1).subscribe((recursosModuls) => {
						this.recursosModuls = recursosModuls;
					});
				} else {
					let requestParams: HalParam[] = [];
					if (perfilUsuariEmpreses.length == 1) {
						requestParams.push({
							key: 'query',
							value: 'perfil.id==' + perfilUsuariEmpreses[0]['perfil'].id
						});
					} else {
						perfilsUsuari = perfilUsuariEmpreses.map(perfilUsuariEmpresa => perfilUsuariEmpreses['perfil'].id);
						requestParams.push({
							key: 'query',
							value: 'perfil.id in ' + perfilUsuariEmpreses.join(',')
						});
					}
					this.perfilRolService.getAll({ params: requestParams }).subscribe((perfilRols) => {
						let rols: number[];
						if (perfilRols == null || perfilRols.length == 0) {
							rols = [-1];
						} else {
							rols = perfilRols.map(perfilRol => perfilRol['rol'].id);
						}
						this.recursosService.getRecursosByRols(rols).subscribe((recursosModuls) => {
							console.log("RecursosRol: ", recursosModuls);
							this.recursosModuls = recursosModuls;
						});
					});
				}
			});
		}
	}

	constructor(
		public recursosService: RecursosService,
		public perfilRolService: PerfilRolService,
		public perfilUsuariEmpresaService: PerfilUsuariEmpresaService,
		translate: TranslateService,
		private screenSizeService: BngScreenSizeService,
		private snackbar: MatSnackBar) {
		this.translate = translate;
		this.mobileScreen = this.screenSizeService.isMobile();
		this.tableHeight = Math.max(window.innerHeight - 120, 200);
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: BngScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile;
			this.tableHeight = Math.max(event.height - 120, 200);
		});
	}
}