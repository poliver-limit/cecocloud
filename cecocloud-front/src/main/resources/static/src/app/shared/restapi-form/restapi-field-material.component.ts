import { Component, OnInit, Input, Output, EventEmitter, ElementRef, ViewChild, isDevMode } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MatInput, MatSelect, MatCheckbox } from '@angular/material';
import { Resource } from 'angular4-hal';
import * as moment from 'moment';

import {
    RestapiResource,
    RestapiResourceField
} from '../restapi/restapi-profile';
import { RestapiBaseFieldComponent } from './restapi-base-field.component';
import { RestapiLovMaterialComponent } from '../restapi-lov/restapi-lov-material.component';

@Component( {
    selector: 'restapi-field-material',
    template: `
<mat-form-field *ngIf="isText || isTextarea" [appearance]="appearance" style="width:100%">
    <mat-label *ngIf="!hideLabel">{{label}}</mat-label>
    <input
        *ngIf="isText"
        matInput
        [type]="inputTextType"
        [minlength]="field.minLength"
        [maxlength]="field.maxLength"
        [formControl]="formControl"
        [required]="field.required"
        (click)="onFieldClick($event)"
        (input)="onFieldInput($event)"
        (change)="onFieldChange($event)"/>
    <textarea
        *ngIf="isTextarea"
        matInput
        [minlength]="field.minLength"
        [maxlength]="field.maxLength"
        [formControl]="formControl"
        [required]="field.required"
        (click)="onFieldClick($event)"
        (input)="onFieldInput($event)"
        (change)="onFieldChange($event)"></textarea>
    <mat-hint align="end" *ngIf="showCharCount">{{formControl.value?.length || 0}}/{{field.maxLength}}</mat-hint>
    <mat-error>{{errorMessage}}</mat-error>
</mat-form-field>
<ng-container *ngIf="isDate">
    <mat-form-field [appearance]="appearance" style="width:100%">
        <mat-label *ngIf="!hideLabel">{{label}}</mat-label>
        <input
            matInput
            [matDatepicker]="datePicker"
            [formControl]="formControl"
            [required]="field.required"
            (click)="onFieldClick($event)"
            (dateInput)="onFieldInput($event)"
            (dateChange)="onFieldChange($event)"/>
        <mat-datepicker-toggle matSuffix [for]="datePicker" tabindex="-1"></mat-datepicker-toggle>
        <mat-datepicker #datePicker></mat-datepicker>
        <mat-error>{{errorMessage}}</mat-error>
    </mat-form-field>
</ng-container>
<ng-container *ngIf="isDatetime" [formGroup]="datetimeFormGroup">
    <mat-form-field [appearance]="appearance" style="width:50%; margin-right: 6px">
        <mat-label *ngIf="!hideLabel">{{label}}</mat-label>
        <input
            matInput
            [matDatepicker]="datePicker"
            formControlName="date"
            [required]="field.required"
            [readonly]="datetimeLinkedWithCurrentTime"
            (click)="onFieldClick($event)"
            (dateInput)="onFieldInput($event)"
            (dateChange)="onFieldChange($event)"/>
        <mat-datepicker-toggle matSuffix [for]="datePicker" [disabled]="datetimeLinkedWithCurrentTime" tabindex="-1"></mat-datepicker-toggle>
        <mat-datepicker #datePicker></mat-datepicker>
        <mat-error>{{errorMessage}}</mat-error>
    </mat-form-field>
    <mat-form-field [appearance]="appearance" [ngStyle]="{'width': datetimeLinkButtonActive ? 'calc(50% - 6px - 40px - 6px)' : 'calc(50% - 6px)'}">
        <input
            matInput
            type="time"
            step="1"
            formControlName="time"
            [required]="field.required"
            [readonly]="datetimeLinkedWithCurrentTime"
            (click)="onFieldClick($event)"
            (input)="onFieldInput($event)"
            (change)="onFieldChange($event)"/>
        <button mat-icon-button matSuffix [disabled]="datetimeLinkedWithCurrentTime" tabindex="-1">
            <mat-icon>schedule</mat-icon>
        </button>
    </mat-form-field>
    <button
        *ngIf="datetimeLinkButtonActive"
        mat-icon-button
        (click)="onDatetimeLinkButtonClick()"
        aria-label="Link with current time"
        style="margin-left: 6px">
        <mat-icon *ngIf="datetimeLinkedWithCurrentTime">link</mat-icon>
        <mat-icon *ngIf="!datetimeLinkedWithCurrentTime">link_off</mat-icon>
    </button>
</ng-container>
<ng-container *ngIf="isSelect">
    <mat-form-field [appearance]="appearance" style="width:100%">
        <mat-label *ngIf="enumLabelShown">{{label}}</mat-label>
        <mat-select *ngIf="!nativeControl"
            [formControl]="formControl"
            [multiple]="field.multiple"
            [required]="field.required"
            (click)="onFieldClick($event)"
            (selectionChange)="onFieldInput($event)">
            <mat-option *ngFor="let enumValue of field.enumValues" [value]="enumValue">{{enumValue}}</mat-option>
        </mat-select>
        <select *ngIf="nativeControl"
            matNativeControl
            [formControl]="formControl"
            [multiple]="field.multiple"
            [required]="field.required"
            (click)="onFieldClick($event)"
            (selectionChange)="onFieldInput($event)">
            <option *ngFor="let enumValue of field.enumValues" [value]="enumValue">{{enumValue}}</option>
        </select>
        <mat-error>{{errorMessage}}</mat-error>
    </mat-form-field>
</ng-container>
<div *ngIf="isCheckbox" style="width:100%; padding-top: 10px;">
    <mat-checkbox
        [formControl]="formControl"
        (click)="onFieldClick($event)"
        (change)="onFieldChange($event)"><span *ngIf="!hideLabel">{{label}}</span></mat-checkbox>
</div>
<ng-container *ngIf="isLov">
    <restapi-lov-material
        [fieldName]="fieldName"
        [formGroup]="internalFormGroup"
        [restapiResource]="internalRestapiResource"
        [resourceInstance]="resourceInstance"
        [hideLabel]="hideLabel"
        [appearance]="appearance"
        (click)="onFieldClick($event)"
        (input)="onFieldInput($event)"
        (change)="onFieldChange($event)"></restapi-lov-material>
</ng-container>
`
} )
export class RestapiFieldMaterialComponent extends RestapiBaseFieldComponent implements OnInit {

    @Input() appearance: string = 'standard'; // 'legacy' | 'standard' | 'fill' | 'outline'
    @Input() nativeControl: boolean;

    @ViewChild( MatInput, { static: false } ) matInputField: MatInput;
    @ViewChild( MatSelect, { static: false } ) matSelectField: MatSelect;
    @ViewChild( MatCheckbox, { static: false } ) matCheckboxField: MatCheckbox;
    @ViewChild( RestapiLovMaterialComponent, { static: false } ) restapiLovField: RestapiLovMaterialComponent;

    isText: boolean = false;
    inputTextType: string = 'text';
    isTextarea: boolean = false;
    isDate: boolean = false;
    isDatetime: boolean = false;
    isCheckbox: boolean = false;
    isSelect: boolean = false;
    isLov: boolean = false;
    datetimeFormGroup: FormGroup;
    datetimeLinkButtonActive: boolean = true;
    datetimeLinkedWithCurrentTime: boolean = true;
    showCharCount: boolean;
    errorMessage: string;
    // Per a evitar l'error ExpressionChangedAfterItHasBeenCheckedError en el label del mat-select
    enumLabelShown: boolean = false;

    ngOnInit() {
        this.enumLabelShown = !isDevMode && this.hideLabel;
        this.doEachSecond();
        switch ( this.field.type ) {
            case 'TEXTAREA':
                this.isTextarea = true;
                break;
            case 'DATE':
                this.isDate = true;
                break;
            case 'DATETIME':
                this.buildDatetimeFormGroup();
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
        if ( this.isDatetime ) {
            this.propagateDateToFormControl(
                this.datetimeFormGroup.get( 'date' ).value,
                this.datetimeFormGroup.get( 'time' ).value );
        }
        super.onFieldChange( event );
    }

    onFieldInput( event ) {
        super.onFieldInput( event );
    }

    public setErrors( errors?: any ) {
        if ( this.restapiLovField ) {
            this.restapiLovField.setErrors( errors );
        } else {
            let valid = !( errors && Object.keys( errors ).length > 0 );
            if ( !valid ) {
                if ( this.datetimeFormGroup ) {
                    this.datetimeFormGroup.get( 'date' ).markAsTouched();
                    this.datetimeFormGroup.get( 'date' ).setErrors( errors );
                    this.datetimeFormGroup.get( 'time' ).markAsTouched();
                    this.datetimeFormGroup.get( 'time' ).setErrors( errors );
                } else {
                    this.formControl.markAsTouched();
                    this.formControl.setErrors( errors );
                }
            } else {
                if ( this.datetimeFormGroup ) {
                    this.datetimeFormGroup.get( 'date' ).setErrors( null );
                    this.datetimeFormGroup.get( 'time' ).setErrors( null );
                } else {
                    this.formControl.setErrors( null );
                }
            }
            this.errorMessage = valid ? undefined : errors[Object.keys( errors )[0]];
        }
    }

    getFieldComponent() {
        if ( this.restapiLovField ) {
            return this.restapiLovField.getFieldComponent();
        } else if ( this.matSelectField ) {
            return this.matSelectField;
        } else if ( this.matCheckboxField ) {
            return this.matCheckboxField;
        } else {
            return this.matInputField;
        }
    }

    getEnumDescription( index: number, value: string ) {
        if ( this.field.enumDescriptions ) {
            return this.field.enumDescriptions[index];
        } else if ( this.field.enumTranslateKeyPrefix ) {
            return this.translate.instant( this.field.enumTranslateKeyPrefix + value );
        } else {
            return value;
        }
    }

    buildDatetimeFormGroup() {
        let fieldValue = this.internalFormGroup.get( this.fieldName ).value;
        let dateValue;
        let timeValue;
        let fieldMoment;
        if ( fieldValue ) {
            fieldMoment = moment( fieldValue );
            this.datetimeLinkedWithCurrentTime = false;
        } else if ( this.datetimeLinkedWithCurrentTime ) {
            fieldMoment = moment();
        }
        if ( fieldMoment ) {
            dateValue = fieldMoment;
            timeValue = fieldMoment.format( 'HH:mm:ss' );
        }
        let lovControls = {};
        lovControls['date'] = { value: dateValue, disabled: this.formControl.disabled };
        lovControls['time'] = { value: timeValue, disabled: this.formControl.disabled };
        this.datetimeFormGroup = this.formBuilder.group( lovControls );
    }

    onDatetimeLinkButtonClick() {
        this.datetimeLinkedWithCurrentTime = !this.datetimeLinkedWithCurrentTime;
        if ( this.datetimeLinkedWithCurrentTime ) {
            this.doEachSecond();
        }
    }

    doEachSecond() {
        if ( this.datetimeFormGroup && this.datetimeLinkedWithCurrentTime ) {
            let currentMoment = moment();
            this.datetimeFormGroup.get( 'date' ).setValue( currentMoment );
            this.datetimeFormGroup.get( 'time' ).setValue( currentMoment.format( 'HH:mm:ss' ) );
            this.propagateDateToFormControl(
                this.datetimeFormGroup.get( 'date' ).value,
                this.datetimeFormGroup.get( 'time' ).value );
        }
    }

    propagateDateToFormControl( dateValue, timeValue?: string ) {
        let time = timeValue ? timeValue : '00:00:00';
        let m = moment(( dateValue ? dateValue : moment() ).format( 'YYYY-MM-DD' ) + ' ' + time, 'YYYY-MM-DD HH:mm:ss' );
        let apiValue = m.format( 'YYYY-MM-DDTHH:mm:ss.SSS' ) + this.getTimeZoneOffset();
        this.internalFormGroup.get( this.fieldName ).setValue( apiValue );
    }

    getTimeZoneOffset() {
        let offsetInHours = -( new Date().getTimezoneOffset() / 60 );
        let timezoneOffsetNegative = offsetInHours < 0;
        if ( timezoneOffsetNegative ) {
            offsetInHours = -offsetInHours;
        }
        let timezoneOffsetStr = ( timezoneOffsetNegative ? '-' : '+' ) + ( ( offsetInHours < 10 ) ? '0' + offsetInHours : '' + offsetInHours ) + ':00';
        return timezoneOffsetStr;
    }

    constructor(
        private formBuilder: FormBuilder,
        translate: TranslateService ) {
        super( translate );
        setInterval(() => {
            this.doEachSecond();
        }, 1000 );
    }

}
