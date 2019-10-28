import { Component, ViewChild } from '@angular/core';
import { MatInput } from '@angular/material/input';
import { BngFormBaseField } from '@programari-limit/bang';

@Component( {
    selector: 'companyia-nom',
    template: `
<mat-form-field *ngIf="field" style="width:100%">
    <input
        matInput type="text"
        [minlength]="field.minLength"
        [maxlength]="field.maxLength"
        [formControl]="formControl"
        [required]="field.required"/>
</mat-form-field>
`, styles: [`
`]
} )
export class CompanyiesNomFieldComponent extends BngFormBaseField {

    @ViewChild( MatInput, { static: false } ) matInputField: MatInput;

    valid: boolean;
    errorMessage: string;

    public setErrors( errors?: any ) {
        let valid = !( errors && Object.keys( errors ).length > 0 );
        if ( !valid ) {
            this.formControl.markAsTouched();
            this.formControl.setErrors( errors );
        } else {
            this.formControl.setErrors( null );
        }
        this.errorMessage = valid ? undefined : errors[Object.keys( errors )[0]];
    }

    getFieldComponent() {
        return this.matInputField;
    }

}