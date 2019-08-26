import { Component, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MdcTextField } from '@angular-mdc/web';
import { MatInput } from '@angular/material/input';

import { RestapiBaseFieldComponent } from '../../shared/restapi-form/restapi-base-field.component';
import { RestapiResource, RestapiResourceField } from '../../shared/restapi/restapi-profile';

@Component( {
    selector: 'companyia-nom',
    template: `
<!--mdc-form-field fluid *ngIf="formGroup" [formGroup]="formGroup">
    <mdc-text-field
        type="text"
        [label]="label ? label : field.name"
        outlined dense
        [minlength]="field.minLength"
        [maxlength]="field.maxLength"
        [characterCounter]="field.minLength || field.maxLength"
        [formControlName]="field.name"
        [required]="field.required"
        [helperText]="helperText"></mdc-text-field>
    <mdc-helper-text #helperText validation>{{errorMessage}}</mdc-helper-text>
</mdc-form-field-->
<mat-form-field *ngIf="formControl" style="width:100%">
    <input
        matInput type="text"
        #input
        [placeholder]="label"
        [minlength]="field.minLength"
        [maxlength]="field.maxLength"
        [formControl]="formControl"
        [required]="field.required"/>
    <mat-error *ngIf="formControl.invalid">{{errorMessage}}</mat-error>
    <mat-hint *ngIf="field.minLength || field.maxLength" align="end">{{input.value?.length || 0}}/{{field.maxLength}}</mat-hint>
</mat-form-field>
`
} )
export class CompanyiesNomFieldComponent extends RestapiBaseFieldComponent {

    @ViewChild( MatInput, { static: false } ) matInputField: MatInput;

    private valid: boolean;
    private errorMessage: string;

    public setErrors( errors?: any ) {
        /*console.log('>>> setValid', valid, errorMessage, this.formGroup);
        if (!valid) {
            this.formControl.markAsTouched();
            this.formControl.setErrors({});
        } else {
            this.formControl.setErrors(null);
        }
        console.log('>>> matInputField', this.matInputField);
        this.valid = valid;
        this.errorMessage = errorMessage;*/
    }

    getFieldComponent() {
        return this.matInputField;
    }

}