import { Component, Input, Output, EventEmitter, ElementRef, ViewChild, OnInit, Renderer2 } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MdcTextField, MdcTextarea, MdcSelect } from '@angular-mdc/web';

import {
    RestapiResource,
    RestapiResourceField
} from '../restapi/restapi-profile';
import { RestapiBaseFieldComponent } from './restapi-base-field.component';
import { RestapiLovComponent } from '../restapi-lov/restapi-lov.component';

@Component( {
    selector: 'restapi-field',
    template: `
<mdc-form-field fluid [formGroup]="formGroup">
    <ng-container *ngIf="field.type === 'STRING' || field.type === 'PASSWORD'">
        <mdc-text-field
            [type]="field.type === 'PASSWORD' ? 'password' : 'text'"
            [label]="label ? label : field.name"
            outlined dense
            [minlength]="field.minLength"
            [maxlength]="field.maxLength"
            [characterCounter]="field.minLength || field.maxLength"
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText"></mdc-text-field>
    </ng-container>
    <ng-container *ngIf="field.type === 'TEXTAREA'">
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
    <ng-container *ngIf="field.type === 'INTEGER'">
        <mdc-text-field
            type="number"
            [label]="label ? label : field.name"
            outlined dense
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText"></mdc-text-field>
    </ng-container>
    <ng-container *ngIf="field.type ==='FLOAT' || field.type === 'BIGDECIMAL' || field.type === 'PREU' || field.type === 'IMPORT'">
        <mdc-text-field
            type="number"
            [label]="label ? label : field.name"
            [step]="any"
            outlined dense
            [formControlName]="field.name"
            [required]="field.required"
            [helperText]="helperText"></mdc-text-field>
    </ng-container>
    <ng-container *ngIf="field.type === 'DATE'">
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
    <ng-container *ngIf="field.type === 'DATETIME'">
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
    <ng-container *ngIf="field.type === 'BOOLEAN'">
        <mdc-form-field>
            <mdc-checkbox
                [formControlName]="field.name"></mdc-checkbox>
            <label>{{label ? label : field.name}}</label>
        </mdc-form-field>
    </ng-container>
    <ng-container *ngIf="field.type === 'ENUM'">
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
    <ng-container *ngIf="field.type === 'LOV'">
        <restapi-lov
            [label]="label ? label : field.name"
            [formGroup]="formGroup"
            [resource]="resource"
            [field]="field"
            [helperText]="helperText"></restapi-lov>
    </ng-container>
    <mdc-helper-text #helperText validation>{{errorMessage}}</mdc-helper-text>
</mdc-form-field>
`
} )
export class RestapiDefaultFieldComponent implements OnInit, RestapiBaseFieldComponent {

    @Input() resource: RestapiResource;
    @Input() field: RestapiResourceField;
    @Input() formGroup: FormGroup;
    @Input() label: string;

    @Output() change: EventEmitter<any> = new EventEmitter();
    @Output() click: EventEmitter<any> = new EventEmitter();

    @ViewChild( MdcTextField, { static: false } ) mdcTextField: MdcTextField;
    @ViewChild( MdcTextarea, { static: false } ) mdcTextarea: MdcTextarea;
    @ViewChild( MdcSelect, { static: false } ) mdcSelect: MdcSelect;
    @ViewChild( 'inputField', { static: false } ) inputField: ElementRef;
    @ViewChild( 'textareaField', { static: false } ) textareaField: ElementRef;
    @ViewChild( 'selectField', { static: false } ) selectField: ElementRef;
    @ViewChild( RestapiLovComponent, { static: false } ) lovComponent: RestapiLovComponent;

    private valid: boolean = true;
    private errorMessage: string;
    private mask: string;

    ngOnInit() {
        if ( !this.label && this.field.translateKey ) {
            let translatedKey = this.translate.instant( this.field.translateKey );
            if ( translatedKey !== this.field.translateKey ) {
                this.label = translatedKey;
            }
        }
        this.mask = this.getMask();
    }

    onFieldChange( newValue ) {
        this.change.emit( newValue );
    }
    onFieldClick( event ) {
        this.click.emit( event );
    }

    public setValid( valid: boolean, errorMessage?: string ) {
        if ( this.mdcTextField ) {
            this.mdcTextField.valid = valid;
        } else if ( this.mdcTextarea ) {
            this.mdcTextarea.valid = valid;
        } else if ( this.mdcSelect ) {
            this.mdcSelect.valid = valid;
        } else if ( this.lovComponent ) {
            this.lovComponent.setValid( valid );
        } else if ( this.inputField ) {
            this.setFieldValid( this.inputField, valid );
        } else if ( this.textareaField ) {
            this.setFieldValid( this.textareaField, valid );
        } else if ( this.selectField ) {
            this.setFieldValid( this.selectField, valid );
        }
        this.errorMessage = errorMessage;
        this.valid = valid;
    }

    public focus() {
        if ( this.mdcTextField ) {
            this.mdcTextField.focus();
        } else if ( this.mdcTextarea ) {
            this.mdcTextarea.focus();
        } else if ( this.mdcSelect ) {
            this.mdcSelect.focus();
        } else if ( this.inputField ) {
            this.inputField.nativeElement.focus();
        } else if ( this.textareaField ) {
            this.textareaField.nativeElement.focus();
        } else if ( this.selectField ) {
            this.selectField.nativeElement.focus();
        } else if ( this.lovComponent ) {
            this.lovComponent.focus();
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
        private translate: TranslateService,
        private renderer: Renderer2 ) { }

}
