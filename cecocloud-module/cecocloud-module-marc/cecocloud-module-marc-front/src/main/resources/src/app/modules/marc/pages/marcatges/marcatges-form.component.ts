import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormGroup } from '@angular/forms';
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
	<bng-custom-field *ngIf="id || hasAdminPermission" name="llocFeinaFora" style="width:100%"></bng-custom-field>
	<bng-custom-field *ngIf="id || hasAdminPermission" name="foraLinia" style="width:100%"></bng-custom-field>
	<bng-custom-field *ngIf="id || hasAdminPermission" name="validat" style="width:100%"></bng-custom-field>
	<map *ngIf="showMap"
		[longitude]="longitud"
		[latitude]="latitud"></map>
</bng-form>
`
})
export class MarcatgesFormComponent extends BngFormBaseComponent implements OnInit {

	hasAdminPermission: boolean;
	hasCreatePermission: boolean;
	hasUpdatePermission: boolean;
	longitud: number;
	latitud: number;
	showMap: boolean;
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
		if (resource.ubicacio) {
			this.longitud = resource.longitud;
			this.latitud = resource.latitud;
			this.showMap = true;
		}
		if (this.hasAdminPermission && ((!this.id && this.hasCreatePermission) || (this.id && this.hasUpdatePermission))) {
			this.dateShowLinkIcon = true;
		}
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

	constructor(
		activatedRoute: ActivatedRoute,
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