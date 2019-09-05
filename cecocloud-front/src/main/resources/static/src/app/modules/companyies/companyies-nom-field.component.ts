import { Component, Input, Output, EventEmitter, ViewChild } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MdcTextField } from '@angular-mdc/web';
import { MatInput } from '@angular/material/input';

import { RestapiBaseFieldComponent } from '../../shared/restapi-form/restapi-base-field.component';
import { RestapiResource, RestapiResourceField } from '../../shared/restapi/restapi-profile';

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
export class CompanyiesNomFieldComponent extends RestapiBaseFieldComponent {

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