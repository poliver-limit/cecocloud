import { Component, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MdcTextField } from '@angular-mdc/web';

import { RestapiBaseFieldComponent } from '../../shared/restapi-form/restapi-base-field.component';
import { RestapiResourceInfo, RestapiResourceField } from '../../shared/restapi/restapi-profile';

@Component( {
    selector: 'companyia-nom',
    template: `
<mdc-form-field fluid *ngIf="formGroup" [formGroup]="formGroup">
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
</mdc-form-field>
`
} )
export class CompanyiesNomFieldComponent implements RestapiBaseFieldComponent {

    @Input() label: string;
    @Input() resource: RestapiResourceInfo;
    @Input() field: RestapiResourceField;
    @Input() formGroup: FormGroup;

    @Output() change: EventEmitter<any> = new EventEmitter();
    @Output() click: EventEmitter<any> = new EventEmitter();
    
    @ViewChild( MdcTextField, { static: false } ) mdcTextField: MdcTextField;

    private errorMessage: string;

    public setValid( valid: boolean, errorMessage?: string ) {
        if ( this.mdcTextField ) {
            this.mdcTextField.valid = valid;
        }
        this.errorMessage = errorMessage;
    }
    public focus() {
        this.mdcTextField.focus();
    }

}