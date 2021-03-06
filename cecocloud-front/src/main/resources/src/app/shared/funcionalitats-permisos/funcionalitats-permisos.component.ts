import { Component, Input, OnInit } from '@angular/core';

import { MatSnackBar } from '@angular/material';
import { TranslateService } from '@ngx-translate/core';
import { BngScreenSizeService, BngScreenSizeChangeEvent } from '@programari-limit/base-angular';
import { HalParam } from 'angular4-hal';
import { FuncionalitatsPermisosService } from './funcionalitats-permisos.service';
import { PerfilUsuariIdentificadorEmpresaService } from './perfil-usuari-identificador-empresa.service';
import { FuncionalitatsIdentificadorService, FuncionalitatIdentificador } from './funcionalitats-identificador.service';

@Component({
    selector: "cec-funcionalitats",
    template: `
        <div style="display: flex">
			<div style="width: 100%; margin-top: 40px;">
                <mat-tab-group animationDuration="0ms">
                    <mat-tab *ngFor="let funcionalitatsModuls of funcionalitatsModuls; let indexModul = index" label="{{'app.module.' + funcionalitatsModuls.module.code |translate}}">
                    <div [style.height.px]="tableHeight" class="permisos-container">
                        <table mat-table [dataSource]="funcionalitatsModuls.funcionalitat" class="mat-elevation-z8" style="width:100%;">
                                <!-- Columna de nom de la funcionalitat -->
                                <ng-container matColumnDef="label">
                                    <th mat-header-cell *matHeaderCellDef style=""> {{'page.rols.form.recurs' | translate}} </th>
                                    <td mat-cell *matCellDef="let recurs"> {{recurs.label | translate}} </td>
                                </ng-container>
                                <!-- Columna de read -->
                                <ng-container matColumnDef="read">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.baseBootPermission.field.readGranted' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">CON</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs; let index = index" class="rcheck">
                                        <mat-checkbox
                                            name = 'readGranted'
                                            [checked]="recurs.permission.readGranted"
                                            [disabled]="disableToggles"
                                            (click) = "onPermisChange($event, indexModul, index)">
                                        </mat-checkbox>
                                    </td>
                                </ng-container>
                                <!-- Columna de write -->
                                <ng-container matColumnDef="write">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.baseBootPermission.field.writeGranted' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">MOD</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs; let index = index" class="rcheck">
                                        <mat-checkbox
                                            name = 'writeGranted'
                                            [checked]="recurs.permission.writeGranted"
                                            [disabled]="disableToggles"
                                            (click) = "onPermisChange($event, indexModul, index)">
                                        </mat-checkbox>
                                    </td>
                                </ng-container>
                                <!-- Columna de create -->
                                <ng-container matColumnDef="create">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.baseBootPermission.field.createGranted' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">CRE</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs; let index = index" class="rcheck">
                                        <mat-checkbox
                                            name='createGranted'
                                            [checked]="recurs.permission.createGranted"
                                            [disabled]="disableToggles"
                                            (click) = "onPermisChange($event, indexModul, index)">
                                        </mat-checkbox>
                                    </td>
                                </ng-container>
                                <!-- Columna de delete -->
                                <ng-container matColumnDef="delete">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.baseBootPermission.field.deleteGranted' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">BOR</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs; let index = index" class="rcheck">
                                        <mat-checkbox
                                            name = 'deleteGranted'
                                            [checked]="recurs.permission.deleteGranted"
                                            [disabled]="disableToggles"
                                            (click) = "onPermisChange($event, indexModul, index)">
                                        </mat-checkbox>
                                    </td>
                                </ng-container>
                                <!-- Columna de execute -->
                                <ng-container matColumnDef="execute">
                                    <th mat-header-cell *matHeaderCellDef [ngClass]="{'htoggle-mobile': mobileScreen, 'htoggle-desktop': !mobileScreen}">
                                        <ng-container *ngIf="!mobileScreen"> {{'resource.baseBootPermission.field.executeGranted' | translate}}</ng-container>
                                        <ng-container *ngIf="mobileScreen">ADM</ng-container>
                                    </th>
                                    <td mat-cell *matCellDef="let recurs; let index = index" class="rcheck">
                                        <mat-checkbox
                                            name = 'executeGranted'
                                            [checked]="recurs.permission.executeGranted"
                                            [disabled]="disableToggles"
                                            (click) = "onPermisChange($event, indexModul, index)">
                                        </mat-checkbox>
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
        .rcheck {
            text-align: center;
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
        .mat-checkbox-disabled {
            opacity: .78;
        }
    `]
})
export class FuncionalitatsPermisosComponent implements OnInit {

    @Input() perfil: number;
    @Input() usuariIdentificadorEmpresa: any;

    public translate: TranslateService;
    funcionalitatsModuls: any;
    funcionalitats: FuncionalitatIdentificador[];
    columnsToDisplay: string[] = ['label', 'read', 'write', 'create', 'delete', 'execute'];

    disableToggles: boolean;

    mobileScreen: boolean;
    tableHeight: number;

    onPermisChange(event, indexModul, indexRecurs) {
        // Deshabilitar els checks mentres es desen els permisos
        this.disableToggles = true;
        let funcionalitatInfo = JSON.parse(JSON.stringify(this.funcionalitatsModuls[indexModul].resources[indexRecurs]));
        let permis = event.currentTarget.attributes['name'].value;
        let check = !funcionalitatInfo.permission[permis];
        funcionalitatInfo.permission[permis] = check;
        this.funcionalitatsPermisosService.saveFuncionalitat(funcionalitatInfo).subscribe(
            () => {
                this.funcionalitatsModuls[indexModul].resources[indexRecurs].permission[permis] = check;
                this.disableToggles = false;
                //this.showMessage(this.translateKey('component.restapi.form.manteniment.created'));
            },
            error => {
                event.preventDefault();
                this.disableToggles = false;
                console.error(error);
            }
        );
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

    ngOnInit(): void {
        // Càrrega de permisos
        this.disableToggles = true;


        if (this.perfil) {
            this.disableToggles = false;

            this.funcionalitatsPermisosService.getFuncionalitatsByPerfil(this.perfil).subscribe((funcionalitatsModuls) => {
                this.funcionalitatsModuls = funcionalitatsModuls;
            });


            // let requestParams: HalParam[] = [];
            // requestParams.push({
            //     key: 'sort',
            //     value: 'funcionalitat.descripcio,desc'
            // });
            // this.funcionalitatsIdentificadorService.getAll({ params: requestParams }).subscribe((funcionalitats) => {
            //     console.log("Funcionalitats: ", funcionalitats);
            //     this.funcionalitats = funcionalitats;
            // });


        } else if (this.usuariIdentificadorEmpresa) {
            let requestParams: HalParam[] = [];
            requestParams.push({
                key: 'query',
                value: 'usuariIdentificadorEmpresa.usuariIdentificador.usuari.codi=="' + this.usuariIdentificadorEmpresa.usuariCodi + '";' +
                    ' usuariIdentificadorEmpresa.usuariIdentificador.identificador.id=="' + this.usuariIdentificadorEmpresa.identificadorId + '";' +
                    ' usuariIdentificadorEmpresa.empresa.id==' + this.usuariIdentificadorEmpresa.empresaId
            });
            this.perfilUsuariIdentificadorEmpresaService.getAll({ params: requestParams }).subscribe((perfilUsuariIdentificadorEmpreses) => {
                if (perfilUsuariIdentificadorEmpreses == null || perfilUsuariIdentificadorEmpreses.length == 0) {
                    this.funcionalitatsPermisosService.getFuncionalitatsByPerfil(-1).subscribe((funcionalitatsModuls) => {
                        this.funcionalitatsModuls = funcionalitatsModuls;
                    });
                } else {
                    let perfils: number[];
                    if (perfilUsuariIdentificadorEmpreses == null || perfilUsuariIdentificadorEmpreses.length == 0) {
                        perfils = [-1];
                    } else {
                        perfils = perfilUsuariIdentificadorEmpreses.map(perfilUsuariIdentificadorEmpreses => perfilUsuariIdentificadorEmpreses['perfil'].id);
                    }

                    this.funcionalitatsPermisosService.getFuncionalitatsByPerfils(perfils).subscribe((funcionalitatsModuls) => {
                        console.log("FuncionalitatsPerfil: ", funcionalitatsModuls);
                        this.funcionalitatsModuls = funcionalitatsModuls;
                    });
                }
            });
        }
    }

    constructor(
        public funcionalitatsPermisosService: FuncionalitatsPermisosService,
        public perfilUsuariIdentificadorEmpresaService: PerfilUsuariIdentificadorEmpresaService,
        public funcionalitatsIdentificadorService: FuncionalitatsIdentificadorService,
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