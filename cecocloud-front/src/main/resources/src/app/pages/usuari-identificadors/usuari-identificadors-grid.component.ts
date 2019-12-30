import { Component, ViewChild, AfterViewInit, Inject } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { HalParam } from 'angular4-hal';
import { of } from 'rxjs';
import { debounceTime, distinctUntilChanged, tap, switchMap, finalize } from 'rxjs/operators';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BngAuthService, BngDatagrid } from 'base-angular';

import { UsuariIdentificadorsService } from './usuari-identificadors.service';
import { UsuarisService } from './usuaris.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
	template: `
    <bng-datagrid
		#datagrid
        [config]="datagridConfig"
        [restapiService]="usuariIdentificadorsService"
		(headerActionCreate)="onGridActionCreate()"
		(headerActionDelete)="onGridActionDelete($event)"></bng-datagrid>`
})
export class UsuariIdentificadorsGridComponent {

	@ViewChild('datagrid', { static: false }) datagrid: BngDatagrid;

	datagridConfig = {
		columFiltersEnable: true
	};

	onGridActionCreate() {

		const dialogRef = this.dialog.open(UsuariIdentificadorsAddDialog, {
			width: '500px'
		});
		dialogRef.afterClosed().subscribe(usuari => {
			if (usuari) {
				let session = this.authService.getSession();
				let usuariIdentificador: any = {
					usuari: { id: usuari.id },
					identificador: { id: session.i }
				};
				this.usuariIdentificadorsService.create(usuariIdentificador).subscribe(() => {
					this.datagrid.refresh();
				});
			}
		});
	}

	onGridActionDelete(event: any) {
		if (event.selectedRows) {
			if (event.selectedRows.length == 1) {
				let resourceName = this.translateKey(event.resource.translateKey).toLowerCase();
				let rowData = event.selectedRows[0];
				let rowDescription = (event.resource.descriptionField) ? rowData[event.resource.descriptionField] : '#' + rowData.id;
				let confirmMessageTranslated: string = this.translateKey(
					'component.datagrid.manteniment.delete.single.confirm',
					{ description: resourceName + ' ' + rowDescription });
				if (confirm(confirmMessageTranslated)) {
					this.usuariIdentificadorsService.deleteById(event.selectedRows[0].id).subscribe(() => {
						this.datagrid.refresh();
					});
				}
			} else {
				let resourceNamePlural = this.translateKey(event.resource.translateKeyPlural).toLowerCase();
				let confirmMessageTranslated = this.translateKey(
					'component.datagrid.manteniment.delete.multiple.confirm',
					{ count: event.selectedRows.length, description: resourceNamePlural });
				if (confirm(confirmMessageTranslated)) {
					let ids = event.selectedRows.map((resource: any) => { return resource.id });
					this.usuariIdentificadorsService.deleteBulk(ids).subscribe(() => {
						this.datagrid.refresh();
					});
				}
			}
		}
	}

	onRowClicked(event: any) {
		this.router.navigate(['update', event.data.id], { relativeTo: this.route });
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
		private translate: TranslateService,
		private dialog: MatDialog,
		private authService: BngAuthService,
		private router: Router,
		private route: ActivatedRoute,
		public usuariIdentificadorsService: UsuariIdentificadorsService) {
	}

}

@Component({
	template: `
<h1 mat-dialog-title>{{'page.companyia-usuaris.modal.titol' | translate}}</h1>
<div mat-dialog-content>
	<mat-form-field appearance="outline" style="width:100%">
		<mat-label>Correu-e</mat-label>
		<input matInput type="email" [formControl]="email" cdkFocusInitial/>
		<mat-error *ngIf="email.invalid">{{getErrorMessage()}}</mat-error>
	</mat-form-field>
	<mat-card *ngIf="usuari">
		<mat-card-header>
			<ng-container mat-card-avatar>
				<button mat-mini-fab>{{usuari.nom.charAt(0).toUpperCase()}}</button>
			</ng-container>
			<mat-card-title>{{usuari.llinatges}}, {{usuari.nom}}</mat-card-title>
			<mat-card-subtitle>{{usuari.email}}</mat-card-subtitle>
		</mat-card-header>
	</mat-card>
	<br/>
</div>
<div mat-dialog-actions style="justify-content:space-between">
	<button mat-raised-button (click)="onCancelButtonClick()">{{'page.companyia-usuaris.modal.button.cancelar' | translate}}</button>
	<button mat-raised-button color="primary" [mat-dialog-close]="usuari" [disabled]="!usuari">{{'page.companyia-usuaris.modal.button.afegir' | translate}}</button>
</div>
`,
})
export class UsuariIdentificadorsAddDialog implements AfterViewInit {

	email = new FormControl('', [Validators.required, Validators.email]);

	usuari: any;
	isLoading: boolean;

	ngAfterViewInit() {
		this.email.valueChanges.pipe(
			debounceTime(500),
			distinctUntilChanged(),
			tap(() => {
				this.usuari = undefined;
				this.isLoading = true;
			}),
			switchMap((value: string) => {
				if (!this.email.invalid) {
					let requestParams: HalParam[] = [];
					requestParams.push({
						key: 'query',
						value: 'email==' + value
					});
					return this.usuarisService.getAll({ params: requestParams });
				} else {
					return of(null);
				}
			}),
			finalize(() => {
				this.isLoading = false;
			})).subscribe((data: any) => {
				if (data && data.length == 1) {
					this.usuari = data[0];
				}
			});
	}

	getErrorMessage() {
		if (this.email.hasError('required')) {
			return this.translate.instant('error.validation.constraint.required');
		} else if (this.email.hasError('email')) {
			return this.translate.instant('error.validation.constraint.email');
		}
	}
	onCancelButtonClick(): void {
		this.dialogRef.close();
	}

	constructor(
		private translate: TranslateService,
		private usuarisService: UsuarisService,
		public dialogRef: MatDialogRef<UsuariIdentificadorsAddDialog>,
		@Inject(MAT_DIALOG_DATA) public data: any) {
	}

}