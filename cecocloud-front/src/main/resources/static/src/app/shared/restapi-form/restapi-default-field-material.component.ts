import { Component, OnInit, Input, Output, EventEmitter, ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MatInput } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { Resource } from 'angular4-hal';

import {
    RestapiResource,
    RestapiResourceField
} from '../restapi/restapi-profile';
import { RestapiBaseFieldComponent } from './restapi-base-field.component';
import { RestapiLovMaterialComponent } from '../restapi-lov/restapi-lov-material.component';

@Component( {
    selector: 'restapi-field',
    template: `
<mat-form-field *ngIf="!isDate && !isCheckbox && !isLov" style="width:100%">
    <mat-label>{{label}}</mat-label>
    <input
        *ngIf="isText"
        matInput
        [type]="inputTextType"
        [minlength]="field.minLength"
        [maxlength]="field.maxLength"
        [formControl]="formControl"
        [required]="field.required"
        (click)="onFieldClick($event)"
        (change)="onFieldChange($event)"/>
    <textarea
        *ngIf="isTextarea"
        matInput
        [minlength]="field.minLength"
        [maxlength]="field.maxLength"
        [formControl]="formControl"
        [required]="field.required"
        (click)="onFieldClick($event)"
        (change)="onFieldChange($event)"></textarea>
    <input
        *ngIf="isDatetime"
        matInput
        type="datetime-local"
        [formControl]="formControl"
        [required]="field.required"
        (click)="onFieldClick($event)"
        (change)="onFieldChange($event)"/>
    <mat-error>{{errorMessage}}</mat-error>
    <!--mat-hint align="end">{{formControl.value?.length || 0}}/{{field.maxLength}}</mat-hint-->
</mat-form-field>
<ng-container *ngIf="isDate">
    <mat-form-field style="width:100%">
        <mat-label>{{label}}</mat-label>
        <input
            matInput
            [matDatepicker]="datePicker"
            [formControl]="formControl"
            [required]="field.required"
            (click)="onFieldClick($event)"
            (change)="onFieldChange($event)"/>
        <mat-datepicker-toggle matSuffix [for]="datePicker"></mat-datepicker-toggle>
        <mat-datepicker #datePicker></mat-datepicker>
    </mat-form-field>
</ng-container>
<div *ngIf="isCheckbox" style="width:100%">
    <mat-checkbox
        [formControl]="formControl"
        (click)="onFieldClick($event)"
        (change)="onFieldChange($event)">{{label}}</mat-checkbox>
</div>
<restapi-lov-material
    *ngIf="isLov"
    [label]="label"
    [fieldName]="fieldName"
    [formGroup]="formGroup"
    [restapiResource]="restapiResource"
    [resourceInstance]="resourceInstance"
    (click)="onFieldClick($event)"
    (change)="onFieldChange($event)"></restapi-lov-material>
`
} )
export class RestapiDefaultFieldMaterialComponent extends RestapiBaseFieldComponent implements OnInit {

    @ViewChild( MatInput, { static: false } ) matInputField: MatInput;
    @ViewChild( RestapiLovMaterialComponent, { static: false } ) restapiLovField: RestapiLovMaterialComponent;

    private isText: boolean = false;
    private inputTextType: string = 'text';
    private isTextarea: boolean = false;
    private isDate: boolean = false;
    private isDatetime: boolean = false;
    private isCheckbox: boolean = false;
    private isSelect: boolean = false;
    private isLov: boolean = false;
    private errorMessage: string;

    ngOnInit() {
        this.baseOnInit( this.fieldName, this.formGroup, this.restapiResource );
        switch ( this.field.type ) {
            case 'TEXTAREA':
                this.isTextarea = true;
                break;
            case 'DATE':
                this.isDate = true;
                break;
            case 'DATETIME':
                this.isDatetime = true;
                break;
            case 'BOOLEAN':
                this.isCheckbox = true;
                break;
            case 'ENUM':
                this.isSelect = true;
                break;
            case 'LOV':
                this.isLov = true;
                break;
            case 'INTEGER':
            case 'FLOAT':
            case 'BIGDECIMAL':
            case 'PREU':
            case 'IMPORT':
                this.inputTextType = 'number';
            case 'STRING':
            case 'PASSWORD':
            default:
                this.isText = true;
                break;
        }
    }

    onFieldChange( event ) {
        if ( event.target && event.target.value === '' ) {
            this.formControl.reset();
        }
        super.onFieldChange( event );
    }

    public setErrors( errors?: any ) {
        if ( this.restapiLovField ) {
            this.restapiLovField.setErrors( errors );
        } else {
            let valid = !( errors && Object.keys( errors ).length > 0 );
            if ( !valid ) {
                this.formControl.markAsTouched();
                this.formControl.setErrors( errors );
            } else {
                this.formControl.setErrors( null );
            }
            this.errorMessage = valid ? undefined : errors[Object.keys( errors )[0]];
        }
    }

    getFieldComponent() {
        return this.matInputField;
    }
    /*getEnumDescription( index: number, value: string ) {
        if ( this.field ) {
            if ( this.field.enumDescriptions ) {
                return this.field.enumDescriptions[index];
            } else if ( this.field.enumTranslateKeyPrefix ) {
                return this.translate.instant( this.field.enumTranslateKeyPrefix + value );
            } else {
                return value;
            }
        }
    }*/

    constructor(
        private translate: TranslateService) {
        super();
    }

}
