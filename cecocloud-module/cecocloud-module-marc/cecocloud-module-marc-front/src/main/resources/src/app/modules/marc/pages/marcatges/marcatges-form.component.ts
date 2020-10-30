import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BngFormBaseComponent, BngFormBaseField, BngRestapiProfile } from 'base-angular';
import * as moment from 'moment';

import { MarcatgesService } from './marcatges.service';
//import { OperarisEmpresesService } from './operaris-empreses.service';

@Component({
	template: `
<bng-form
	bng-form-mant
	[config]="formConfig"
	[restapiService]="marcatgesService"
	(formGroupChange)="onFormGroupChange($event)"
	(inputFieldsChange)="onInputFieldsChange($event)"
	(resourceLoad)="onResourceLoad($event)">
	<mat-card *ngIf="id && marcatge && hasAdminPermission" color="primary" [ngStyle]="{'background-color': marcatge.validat ? '#ddddff' : '#ffdddd', 'margin-bottom': '.6em'}">
		<mat-card-header>
			<div mat-card-avatar style="position:relative;top:.4em;"><mat-icon *ngIf="marcatge.validat" style="color:#3240a2;position:relative;top:2px;left:6px;">info</mat-icon><mat-icon *ngIf="!marcatge.validat" style="color:#bb3333;position:relative;top:2px;left:6px;">warning</mat-icon></div>
			<mat-card-title style="position:relative;top:.4em">{{marcatge.validat ? ('page.marcatge.title.detalls'| translate) : ('page.marcatge.title.no.validat' | translate)}}</mat-card-title>
			<div style="flex-grow:1"></div>
			<button *ngIf="!marcatge.validat" mat-flat-button (click)="onValidateButtonClick()" color="accent" style="transform: scale(0.9);"><mat-icon>done</mat-icon> {{'page.marcatge.button.validar' | translate}}</button>
			<button mat-icon-button (click)="showValidatDetails = !showValidatDetails">
				<mat-icon *ngIf="!showValidatDetails">expand_more</mat-icon>
				<mat-icon *ngIf="showValidatDetails">expand_less</mat-icon>
			</button>
		</mat-card-header>
		<mat-card-content *ngIf="showValidatDetails">
			<p *ngIf="!marcatge.validat" style="margin-top: 1em">{{'page.marcatge.info.no.validat' | translate}}</p>
			<mat-list>
				<mat-list-item><mat-icon *ngIf="marcatge.foraLinea" mat-list-icon>check_box</mat-icon><mat-icon *ngIf="!marcatge.foraLinea" mat-list-icon>check_box_outline_blank</mat-icon><div mat-line>{{'resource.marcatge.field.foraLinia' | translate}}</div></mat-list-item>
				<mat-list-item><mat-icon *ngIf="marcatge.llocFeinaFora" mat-list-icon>check_box</mat-icon><mat-icon *ngIf="!marcatge.llocFeinaFora" mat-list-icon>check_box_outline_blank</mat-icon><div mat-line>{{'resource.marcatge.field.llocFeinaFora' | translate}}</div></mat-list-item>
				<mat-list-item *ngIf="marcatge.validat"><mat-icon *ngIf="marcatge.intervalObert" mat-list-icon>check_box</mat-icon><mat-icon *ngIf="!marcatge.intervalObert" mat-list-icon>check_box_outline_blank</mat-icon><div mat-line>{{'resource.marcatge.field.intervalObert' | translate}}</div></mat-list-item>
				<mat-list-item *ngIf="marcatge.validat"><mat-icon *ngIf="marcatge.traspassat" mat-list-icon>check_box</mat-icon><mat-icon *ngIf="!marcatge.traspassat" mat-list-icon>check_box_outline_blank</mat-icon><div mat-line>{{'resource.marcatge.field.traspassat' | translate}}</div></mat-list-item>
				<mat-list-item *ngIf="marcatge.validat && marcatge.ubicacio">{{'resource.marcatge.field.ubicacio' | translate}}: {{marcatge.latitud}}, {{marcatge.longitud}}</mat-list-item>
				<mat-list-item *ngIf="marcatge.validat && marcatge.precisio">{{'resource.marcatge.field.precisio' | translate}}: {{marcatge.precisio}} m</mat-list-item>
				<mat-list-item *ngIf="marcatge.adressaIp">{{'resource.marcatge.field.adressaIp' | translate}}: {{marcatge.adressaIp}}</mat-list-item>
				<mat-list-item *ngIf="marcatge.validat && marcatge.intervalDuracio">{{'resource.marcatge.field.intervalDuracio' | translate}}: {{marcatge.intervalDuracio}} min</mat-list-item>
				<mat-list-item *ngIf="marcatge.validat && marcatge.validatData">{{'resource.marcatge.field.validatData' | translate}}: {{formatIso8601Date(marcatge.validatData, true, true)}}</mat-list-item>
			</mat-list>
		</mat-card-content>
	</mat-card>
	<div style="display:flex">
		<bng-custom-field name="operariEmpresa" style="width:50%;padding-right:2em"></bng-custom-field>
	</div>
	<div style="display:flex">
		<bng-custom-field name="data" style="width:calc(100%)"></bng-custom-field>
		<button mat-icon-button *ngIf="dateShowLinkIcon" (click)="onDatetimeLinkButtonClick()" aria-label="Link with current time" style="margin-left: 6px;top:16px">
        	<mat-icon *ngIf="dateLinkedWithCurrentTime">link</mat-icon>
        	<mat-icon *ngIf="!dateLinkedWithCurrentTime">link_off</mat-icon>
    	</button>
	</div>
	<div style="display:flex">
		<bng-custom-field name="latitud" style="width:50%;padding-right:2em"></bng-custom-field>
		<bng-custom-field name="longitud" style="width:50%"></bng-custom-field>
	</div>
	<bng-custom-field name="origen" style="width:100%"></bng-custom-field>
	<mat-card *ngIf="marcatge && marcatge.ubicacio" color="primary" style="background-color:#eee">
		<mat-card-header>
			<div mat-card-avatar style="position:relative;top:.4em;"><mat-icon>place</mat-icon></div>
			<mat-card-title style="position:relative;top:.2em;">{{'page.marcatge.title.ubicacio' | translate}}</mat-card-title>
			<mat-card-subtitle>{{marcatge.latitud}}, {{marcatge.longitud}}</mat-card-subtitle>
		</mat-card-header>
		<mat-card-content>
			<map
				[latitude]="marcatge.latitud"
				[longitude]="marcatge.longitud"
				[precision]="marcatge.precisio"></map>
		</mat-card-content>
	</mat-card>
</bng-form>
`
})
export class MarcatgesFormComponent extends BngFormBaseComponent implements OnInit {

	hasAdminPermission: boolean;
	hasCreatePermission: boolean;
	hasUpdatePermission: boolean;
	marcatge: any;
	showValidatDetails: boolean = false;
	formGroup: FormGroup;
	dataField: BngFormBaseField;
	eachSecondIntervalId: any;
	dateShowLinkIcon: boolean;
	dateLinkedWithCurrentTime: boolean;

	ngOnInit() {
		this.eachSecondIntervalId = setInterval(() => {
			if (this.dateLinkedWithCurrentTime) {
				this.formGroup.get('data').setValue(moment());
			}
		}, 1000);
	}
	ngOnDestroy() {
		if (this.eachSecondIntervalId) {
			clearInterval(this.eachSecondIntervalId);
		}
	}

	onValidateButtonClick() {
		let confirmMessageTranslated: string = this.translateKey('page.marcatge.accio.validar.confirm');
		if (confirm(confirmMessageTranslated)) {
			let snackbarMessage: string = this.translateKey('page.marcatge.accio.validar.ok');
			this.marcatgesService.validate(this.id).subscribe((marcatge: any) => {
				this.validateSnackBar.open(
					snackbarMessage,
					this.translateKey('component.restapi.form.manteniment.button.close'),
					{ duration: 3000 });
				this.marcatge = marcatge;
			});
		}
	}

	onFormGroupChange(formGroup: FormGroup) {
		this.formGroup = formGroup;
	}

	onInputFieldsChange(inputFields: BngFormBaseField[]) {
		this.dataField = inputFields.find((inputField: BngFormBaseField) => {
			return inputField.fieldName == 'data';
		});
		if (this.dataField) {
			this.dataField.readOnlyState = this.dateLinkedWithCurrentTime;
		}
	}

	onResourceLoad(resource: any) {
		if (this.hasAdminPermission && ((!this.id && this.hasCreatePermission) || (this.id && this.hasUpdatePermission))) {
			this.dateShowLinkIcon = true;
		}
		this.marcatge = resource;
		if (!this.id) {
			this.switchDateLinked();
		}
	}

	onDatetimeLinkButtonClick() {
		this.switchDateLinked();
	}

	switchDateLinked() {
		this.dateLinkedWithCurrentTime = !this.dateLinkedWithCurrentTime;
		if (this.dataField) {
			this.dataField.readOnlyState = this.dateLinkedWithCurrentTime;
		}
	}

	formatIso8601Date(isoDate: string, isTimestamp?: boolean, includeYear?: boolean) {
		let dateSeparator = '/';
		let timeSeparator = ':';
		let dateValue = new Date(isoDate);
		let yearStr = (includeYear) ? (dateSeparator + dateValue.getFullYear()) : '';
		if (isTimestamp) {
			return this.numberWithPadding(dateValue.getDate(), 2) + dateSeparator +
				(this.numberWithPadding(dateValue.getMonth() + 1, 2)) + yearStr + ' ' +
				this.numberWithPadding(dateValue.getHours(), 2) + timeSeparator +
				this.numberWithPadding(dateValue.getMinutes(), 2) + timeSeparator +
				this.numberWithPadding(dateValue.getSeconds(), 2);
		} else {
			return this.numberWithPadding(dateValue.getDate(), 2) + dateSeparator +
				(this.numberWithPadding(dateValue.getMonth() + 1, 2)) + yearStr;
		}
	}
	private numberWithPadding(n: any, width: number, z?: string) {
		if (n >= 0) {
			z = z || '0';
			n = n + '';
			return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
		} else {
			return '-' + this.numberWithPadding(-n, width, z);
		}
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
		activatedRoute: ActivatedRoute,
		private translate: TranslateService,
		private validateSnackBar: MatSnackBar,
		public marcatgesService: MarcatgesService) {
		super(activatedRoute);
		marcatgesService.whenReady().subscribe((marcatgesProfile: BngRestapiProfile) => {
			this.hasAdminPermission = marcatgesProfile.resource.hasAdminPermission;
			this.hasCreatePermission = marcatgesProfile.resource.hasCreatePermission;
			this.hasUpdatePermission = marcatgesProfile.resource.hasUpdatePermission;
		});
		this.formConfig.readOnlyStateEnabled = false;
		//this.formConfig.goToGridWhenSavedEnabled = true;
		//this.formConfig.goToGridWhenSavedActive = true;
	}

}