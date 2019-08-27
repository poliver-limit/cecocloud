import { Component, OnInit, Input, Output, EventEmitter, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MatInput } from '@angular/material/input';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { Resource } from 'angular4-hal';
import * as moment from 'moment';

import {
    RestapiResource,
    RestapiResourceField
} from '../restapi/restapi-profile';
import { RestapiBaseFieldComponent } from './restapi-base-field.component';
import { RestapiLovMaterialComponent } from '../restapi-lov/restapi-lov-material.component';

@Component( {
    selector: 'restapi-field',
    template: `
<mat-form-field *ngIf="isText || isTextarea" style="width:100%">
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
    <mat-hint align="end" *ngIf="showCharCount">{{formControl.value?.length || 0}}/{{field.maxLength}}</mat-hint>
    <mat-error>{{errorMessage}}</mat-error>
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
        <mat-error>{{errorMessage}}</mat-error>
    </mat-form-field>
</ng-container>
<ng-container *ngIf="isDatetime" [formGroup]="datetimeFormGroup">
    <mat-form-field style="width:50%; margin-right: 6px">
        <mat-label>{{label}}</mat-label>
        <input
            matInput
            [matDatepicker]="datePicker"
            formControlName="date"
            [required]="field.required"
            [readonly]="datetimeLinkedWithCurrentTime"
            (click)="onFieldClick($event)"
            (change)="onFieldChange($event)"/>
        <mat-datepicker-toggle matSuffix [for]="datePicker" [disabled]="datetimeLinkedWithCurrentTime"></mat-datepicker-toggle>
        <mat-datepicker #datePicker></mat-datepicker>
        <mat-error>{{errorMessage}}</mat-error>
    </mat-form-field>
    <mat-form-field [ngStyle]="{'width': datetimeLinkButtonActive ? 'calc(50% - 6px - 40px - 6px)' : 'calc(50% - 6px)'}">
        <input
            matInput
            type="time"
            step="1"
            formControlName="time"
            [required]="field.required"
            [readonly]="datetimeLinkedWithCurrentTime"
            (click)="onFieldClick($event)"
            (change)="onFieldChange($event)"/>
        <button mat-icon-button matSuffix>
            <mat-icon>schedule</mat-icon>
        </button>
    </mat-form-field>
    <button
        *ngIf="datetimeLinkButtonActive"
        mat-icon-button
        (click)="onDatetimeLinkButtonClick($event)"
        aria-label="Link with current time"
        style="margin-left: 6px">
        <mat-icon *ngIf="datetimeLinkedWithCurrentTime">link</mat-icon>
        <mat-icon *ngIf="!datetimeLinkedWithCurrentTime">link_off</mat-icon>
    </button>
</ng-container>
<ng-container *ngIf="isSelect">
    <mat-form-field style="width:100%">
        <mat-label>{{label}}</mat-label>
        <mat-select
            [formControl]="formControl"
            multiple
            [required]="field.required"
            (click)="onFieldClick($event)"
            (change)="onFieldChange($event)">
            <mat-option *ngFor="let enumValue of field.enumValues" [value]="enumValue">{{enumValue}}</mat-option>
        </mat-select>
        <mat-error>{{errorMessage}}</mat-error>
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
    private datetimeFormGroup: FormGroup;
    private datetimeLinkButtonActive: boolean = true;
    private datetimeLinkedWithCurrentTime: boolean = false;
    private showCharCount: boolean;
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
            this.datetimePropagateToFormControl();
        }
        super.onFieldChange( event );
    }

    onFieldInput( event ) {
        console.log( '>>> onFieldInput', event )
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
        return this.matInputField;
    }

    private getEnumDescription( index: number, value: string ) {
        if ( this.field.enumDescriptions ) {
            return this.field.enumDescriptions[index];
        } else if ( this.field.enumTranslateKeyPrefix ) {
            return this.translate.instant( this.field.enumTranslateKeyPrefix + value );
        } else {
            return value;
        }
    }

    private buildDatetimeFormGroup() {
        let fieldValue = this.formGroup.get( this.fieldName ).value;
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
        lovControls['date'] = { value: dateValue, disabled: this.formControl.disabled || this.datetimeLinkedWithCurrentTime };
        lovControls['time'] = { value: timeValue, disabled: this.formControl.disabled || this.datetimeLinkedWithCurrentTime };
        this.datetimeFormGroup = this.formBuilder.group( lovControls );
    }

    private onDatetimeLinkButtonClick() {
        this.datetimeLinkedWithCurrentTime = !this.datetimeLinkedWithCurrentTime;
        if ( !this.datetimeLinkedWithCurrentTime ) {
            this.doEachSecond();
        }
    }

    private doEachSecond() {
        if ( this.datetimeFormGroup && this.datetimeLinkedWithCurrentTime ) {
            let currentMoment = moment();
            this.datetimeFormGroup.get( 'date' ).setValue( currentMoment );
            this.datetimeFormGroup.get( 'time' ).setValue( currentMoment.format( 'HH:mm:ss' ) );
            this.datetimePropagateToFormControl();
        }
    }

    private datetimePropagateToFormControl() {
        let dateValue = this.datetimeFormGroup.get( 'date' ).value;
        let timeValue = this.datetimeFormGroup.get( 'time' ).value;
        let m = moment( dateValue.format( 'YYYY-MM-DD' ) + ' ' + timeValue, 'YYYY-MM-DD HH:mm:ss' );
        let apiValue = m.format( 'YYYY-MM-DD' ) + 'T' + m.format( 'HH:mm:ss.SSS' ) + this.getTimeZoneOffset();
        this.formGroup.get( this.fieldName ).setValue( apiValue );
    }

    private getTimeZoneOffset() {
        let offsetInHours = -( new Date().getTimezoneOffset() / 60 );
        let timezoneOffsetNegative = offsetInHours < 0;
        if ( timezoneOffsetNegative ) {
            offsetInHours = -offsetInHours;
        }
        let timezoneOffsetStr = ( timezoneOffsetNegative ? '-' : '+' ) + (( offsetInHours < 10 ) ? '0' + offsetInHours : '' + offsetInHours) + ':00';
        return timezoneOffsetStr;
    }

    constructor(
        private formBuilder: FormBuilder,
        private translate: TranslateService ) {
        super();
        setInterval(() => {
            this.doEachSecond();
        }, 1000 );
    }

}
