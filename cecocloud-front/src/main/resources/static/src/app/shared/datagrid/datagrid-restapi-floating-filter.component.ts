import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { IAfterGuiAttachedParams, IDoesFilterPassParams, IFilterParams, RowNode, IFloatingFilterParams, FilterChangedEvent, TextFilter } from 'ag-grid-community';
import { IFilterAngularComp, IFloatingFilterComp } from 'ag-grid-angular';

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';

export interface DatagridRestapiFloatingFilterParams extends IFloatingFilterParams {
    value: number;
    maxValue: number;
}

@Component( {
    template: `
<!--input #input [ngModel]="value" type="text" (ngModelChange)="valueChanged($event)" style="margin:4px; width: calc(100% - 8px)"/>
<input #inputTo [ngModel]="valueTo" type="text" (ngModelChange)="valueChanged($event)" style="margin:4px; width: calc(100% - 8px)" hidden/-->
<mat-form-field style="width:100%; top: 2px;" appearance="outline">
    <input matInput type="text" [ngModel]="value" (ngModelChange)="valueChanged($event)" autocomplete="off"/>
</mat-form-field>
<!--restapi-field-material
    [fieldName]="fieldName"
    [formGroup]="formGroup"
    [restapiResource]="restapiResource"
    [resourceInstance]="resourceInstance"
    [hideLabel]="true"
    (click)="onFieldClick($event)"
    (change)="onFieldChange($event)"></restapi-field-material-->
`,
    styles: [`
:host {
    width: 100%;
}
`]
} )
export class DatagridRestapiFloatingFilterComponent implements IFloatingFilterComp {

    fieldName: string = 'filter';
    formGroup: FormGroup;
    restapiResource: RestapiResource = {
        name: 'filter',
        fields: []
    };
    params: DatagridRestapiFloatingFilterParams;
    value: string;

    agInit( params: DatagridRestapiFloatingFilterParams ): void {
        this.params = params;
        this.formGroup = this.formBuilder.group( {
            filter: [{ value: undefined }]
        } );
        this.restapiResource.fields = [params['restapiField']];
        this.restapiResource.fields[0].name = 'filter';
        console.log( '>>> agInit', this.restapiResource );
    }

    onParentModelChanged( parentModel: any, event: FilterChangedEvent ): void {
        if ( parentModel ) {
            if ( parentModel.operator ) {
                this.value = parentModel.condition1.filter + ' ' + parentModel.operator + ' ' + parentModel.condition2.filter;
            } else {
                this.value = parentModel.filter;
            }
        } else {
            this.value = undefined;
        }
    }

    valueChanged( newValue ) {
        this.params.parentFilterInstance( function( instance ) {
            ( <TextFilter>instance ).onFloatingFilterChanged(
                'contains',
                newValue );
        } );
    }

    constructor(
        private formBuilder: FormBuilder ) {
    }

}