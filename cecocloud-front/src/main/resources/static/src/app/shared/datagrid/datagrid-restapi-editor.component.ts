import { Component, ViewChild } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Subscription } from 'rxjs';
import { TranslateService } from '@ngx-translate/core';
import { ICellEditorAngularComp } from 'ag-grid-angular';
import { Resource } from 'angular4-hal';

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';
import { RestapiBaseFieldComponent } from '../restapi-form/restapi-base-field.component';

@Component({
	template: `
<restapi-field-material
    #fieldComponent
    [fieldName]="fieldName"
    [formGroup]="formGroup"
    [restapiResource]="restapiResource"
    [resourceInstance]="resourceInstance"
    [hideLabel]="true"
    (click)="onFieldClick($event)"
    (change)="onFieldChange($event)"></restapi-field-material>`
})
export class DatagridRestapiEditorComponent implements ICellEditorAngularComp {

	@ViewChild('fieldComponent', { static: true }) fieldComponent: RestapiBaseFieldComponent;

	fieldName: string;
	formGroup: FormGroup;
	restapiResource: RestapiResource;
	resourceInstance: Resource;
	isFirst: boolean;
	params: any;

	rowEditErrorSubscription: Subscription;

	agInit(params: any): void {
		this.fieldName = params.column.getColId();
		this.restapiResource = params.api['getFromOptionsContext']('restapiProfile').resource;
		let first = true;
		let editIsCreate = params.data.id === undefined;
		this.restapiResource.fields.forEach((formField: RestapiResourceField) => {
			let formFieldDisabled = (editIsCreate) ? formField.disabledForCreate : formField.disabledForUpdate
			if (formField.name === this.fieldName) {
				this.isFirst = first && !formFieldDisabled;
			}
			if (first && !formFieldDisabled) {
				first = false;
			}
		});
		this.formGroup = params.api['getDatagridComponent']().getEditFormGroup(
			params.api,
			params.rowIndex);
		this.params = params;
	}

	isCancelBeforeStart(): boolean {
		if (this.isFirst) {
			setTimeout(() => {
				this.fieldComponent.focus();
			}, 100);
		}
		return false;
	}

	getValue(): any {
		if (this.params.column.colDef.valueParser) {
			return this.params.column.colDef.valueParser({
				oldValue: this.params.value,
				newValue: this.formGroup.controls[this.fieldName].value,
				node: this.params.node,
				colDef: this.params.column.colDef,
				column: this.params.column,
				api: this.params.api,
				columnApi: this.params.columnApi,
				context: this.params.context
			});
		} else {
			return this.formGroup.controls[this.fieldName].value;
		}
	}

	focusIn(): boolean {
		this.fieldComponent.focus();
		return true;
	}

	onFieldClick(event: Event) {
		event.stopPropagation();
	}

	onFieldChange(event: Event) {
		if (!event.target) {
            /*this.messageService.sendCellValueChange({
                rowIndex: this.params.rowIndex,
                fieldName: this.field.name,
                value: event,
                api: this.params.api,
                context: this.params.context,
                formGroup: this.formGroup
            });*/
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
		private translate: TranslateService) {
        /*this.rowEditErrorSubscription = this.messageService.getRowEditError().subscribe(
            ( message: RowEditErrorMessage ) => {
                let error = message ? message.error : undefined;
                if ( error && error.errors ) {
                    error.errors.forEach( fieldError => {
                        if ( fieldError.field === this.field.name ) {
                            setTimeout(() => {
                                this.fieldComponent.setValid( false, error.defaultMessage );
                            }, 100 );
                            //this.fieldComponent.setValid( false, rowEditError.defaultMessage );
                        }
                    } );
                }
            } );*/
	}

}