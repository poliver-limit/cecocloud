import { Component, Input, Output, EventEmitter, ElementRef, ViewChild, OnInit, Renderer2 } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MdcTextField, MdcTextarea, MdcSelect } from '@angular-mdc/web';

import {
    RestapiResource,
    RestapiResourceField
} from '../restapi/restapi-profile';
import { RestapiBaseFieldComponent } from './restapi-base-field.component';
import { RestapiLovMdcwebComponent } from '../restapi-lov/restapi-lov-mdcweb.component';

@Component( {
    selector: 'restapi-field-mdcweb',
    template: `
<mdc-form-field fluid *ngIf="field.type != 'BOOLEAN' && field.type != 'LOV'" [formGroup]="inputFormGroup">
    <ng-container *ngIf="field.type == 'STRING' || field.type == 'PASSWORD'">
        <mdc-text-field
            [type]="field.type == 'PASSWORD' ? 'password' : 'text'"
            [label]="label ? label : field.name"
            outlined dense
            [minlength]="field.minLength"
            [maxlength]="field.maxLength"
            [characterCounter]="field.minLength || field.maxLength"
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText"></mdc-text-field>
    </ng-container>
    <ng-container *ngIf="field.type == 'TEXTAREA'">
        <mdc-textarea
            [label]="label ? label : field.name"
            outlined dense fullwidth rows="4"
            [minlength]="field.minLength"
            [maxlength]="field.maxLength"
            [characterCounter]="field.minLength || field.maxLength"
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText"></mdc-textarea>
    </ng-container>
    <ng-container *ngIf="field.type == 'INTEGER'">
        <mdc-text-field
            type="number"
            [label]="label ? label : field.name"
            outlined dense
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText"></mdc-text-field>
    </ng-container>
    <ng-container *ngIf="field.type =='FLOAT' || field.type == 'BIGDECIMAL' || field.type == 'PREU' || field.type == 'IMPORT'">
        <mdc-text-field
            type="number"
            [label]="label ? label : field.name"
            outlined dense
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText"></mdc-text-field>
    </ng-container>
    <ng-container *ngIf="field.type == 'DATE'">
        <mdc-text-field
            type="date"
            [label]="label ? label : field.name"
            outlined dense
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText">
            <mdc-icon mdcTextFieldIcon trailing>event</mdc-icon>
        </mdc-text-field>
    </ng-container>
    <ng-container *ngIf="field.type == 'DATETIME'">
        <mdc-text-field
            type="datetime-local"
            [label]="label ? label : field.name"
            outlined dense
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText">
            <mdc-icon mdcTextFieldIcon trailing>event</mdc-icon>
        </mdc-text-field>
    </ng-container>
    <ng-container *ngIf="field.type == 'ENUM'">
        <mdc-select
            [placeholder]="label ? label : field.name"
            outlined dense
            [ngClass]="{'mdc-select--dense': true}"
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText">
            <option value=""></option>
            <option *ngFor="let enumValue of field.enumValues" [value]="enumValue">{{enumValue}}</option>
        </mdc-select>
    </ng-container>
    <mdc-helper-text #helperText validation>{{errorMessage}}</mdc-helper-text>
</mdc-form-field>
<mdc-form-field *ngIf="field.type == 'BOOLEAN'" [formGroup]="inputFormGroup" style="width:100%">
    <mdc-checkbox
        [formControlName]="field.name"></mdc-checkbox>
    <label>{{label ? label : field.name}}</label>
</mdc-form-field>
<ng-container *ngIf="field.type == 'LOV'">
    <restapi-lov-mdcweb
        [fieldName]="fieldName"
        [formGroup]="internalFormGroup"
        [restapiResource]="internalRestapiResource"
        [resourceInstance]="resourceInstance"></restapi-lov-mdcweb>
</ng-container>
`
} )
export class RestapiFieldMdcwebComponent extends RestapiBaseFieldComponent implements OnInit {

    @ViewChild( MdcTextField, { static: false } ) mdcTextField: MdcTextField;
    @ViewChild( MdcTextarea, { static: false } ) mdcTextarea: MdcTextarea;
    @ViewChild( MdcSelect, { static: false } ) mdcSelect: MdcSelect;
    @ViewChild( RestapiLovMdcwebComponent, { static: false } ) lovComponent: RestapiLovMdcwebComponent;

    errorMessage: string;
    mask: string;

    ngOnInit() {
        this.mask = this.getMask();
    }

    onFieldChange( newValue ) {
        this.change.emit( newValue );
    }
    onFieldClick( event ) {
        this.click.emit( event );
    }

    public setErrors( errors?: any ) {
        let valid = !( errors && Object.keys( errors ).length > 0 );
        if ( this.mdcTextField ) {
            this.mdcTextField.valid = valid;
        } else if ( this.mdcTextarea ) {
            this.mdcTextarea.valid = valid;
        } else if ( this.mdcSelect ) {
            this.mdcSelect.valid = valid;
        } else if ( this.lovComponent ) {
            this.lovComponent.setErrors( errors );
        }
        this.errorMessage = valid ? undefined : errors[Object.keys( errors )[0]];
    }

    getFieldComponent() {
        if ( this.mdcTextField ) {
            return this.mdcTextField;;
        } else if ( this.mdcTextarea ) {
            return this.mdcTextarea;
        } else if ( this.mdcSelect ) {
            return this.mdcSelect;
        } else if ( this.lovComponent ) {
            return this.lovComponent;
        }
    }

    getMask(): string {
        this.field.decimalMaxLength = 15;
        let integerMask = ( this.field.hasOwnProperty( 'maxLength' ) ) ? '9'.repeat( this.field.decimalMaxLength ) : '9*';
        /*if (integerMask.length > 3) {
            integerMask = integerMask.slice(0, integerMask.length - 3) + ',' + integerMask.slice(integerMask.length - 3);
        }*/
        let decimalMask = ( this.field.hasOwnProperty( 'decimalMaxLength' ) ) ? '.' + ( '0'.repeat( this.field.decimalMaxLength ) ) : '.0*';
        let mask;
        switch ( this.field.type ) {
            case 'INTEGER':
                mask = integerMask;
                break;
            case 'FLOAT':
            case 'BIGDECIMAL':
                mask = integerMask + decimalMask;
                break;
        }
        return mask;
    }

    setFieldValid( field: ElementRef, valid: boolean ) {
        if ( valid ) {
            this.renderer.removeClass(
                field.nativeElement,
                'is-invalid' );
        } else {
            this.renderer.addClass(
                field.nativeElement,
                'is-invalid' );
        }
    }

    getEnumDescription( index: number, value: string ) {
        if ( this.field ) {
            if ( this.field.enumDescriptions ) {
                return this.field.enumDescriptions[index];
            } else if ( this.field.enumTranslateKeyPrefix ) {
                return this.translate.instant( this.field.enumTranslateKeyPrefix + value );
            } else {
                return value;
            }
        }
    }

    constructor(
        translate: TranslateService,
        private renderer: Renderer2 ) {
        super( translate );
    }

}
