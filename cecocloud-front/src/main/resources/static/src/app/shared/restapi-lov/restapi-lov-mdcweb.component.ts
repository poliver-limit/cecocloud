import { Component, Input, Output, EventEmitter, ElementRef, ViewChild, Renderer2 } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MdcDialog, MdcDialogComponent, MdcDialogRef, MdcTextField, MdcHelperText } from '@angular-mdc/web';
import { Resource } from 'angular4-hal';
import { TranslateService } from '@ngx-translate/core';

import { RestapiGenericService } from '../restapi/restapi-generic.service';
import {
    RestapiProfile,
    RestapiResource,
    RestapiResourceField
} from '../restapi/restapi-profile';
import { RestapiBaseFieldComponent } from '../restapi-form/restapi-base-field.component';
import { RestapiLovDialogComponent } from './restapi-lov-dialog.component';

@Component( {
    selector: 'restapi-lov-mdcweb',
    template: `
<mdc-form-field fluid *ngIf="lovFormGroup" [formGroup]="lovFormGroup">
    <input
        #lovHiddenInput
        type="hidden"
        formControlName="id"/>
    <mdc-text-field
        #lovDetailInput
        [label]="label"
        formControlName="description"
        [required]="field.required"
        [helperText]="helperText"
        (click)="onFieldClick($event)"
        (change)="onFieldChange($event)"
        readonly outlined dense>
        <mdc-icon *ngIf="!formControl.value" mdcTextFieldIcon trailing clickable (click)="onExpandIconClick($event)">expand_more</mdc-icon>
        <mdc-icon *ngIf="formControl.value" mdcTextFieldIcon trailing clickable (click)="onClearIconClick($event)">clear</mdc-icon>
    </mdc-text-field>
    <mdc-helper-text #helperText validation>{{errorMessage}}</mdc-helper-text>
</mdc-form-field>
`,
    providers: [RestapiGenericService]
} )
export class RestapiLovMdcwebComponent extends RestapiBaseFieldComponent {

    @ViewChild( 'lovHiddenInput', { static: false } ) lovHiddenInput: ElementRef;
    @ViewChild( 'lovDetailInput', { static: false } ) lovDetailInput: MdcTextField;

    private lovFormGroup: FormGroup;
    private lovResource: RestapiResource;
    private errorMessage: string;

    ngOnInit() {
        this.baseOnInit( this.fieldName, this.formGroup, this.restapiResource );
        this.createLovFormGroup( this.field );
        this.restapiService.configureWithResourceName( this.field.name );
        this.restapiService.whenReady().subscribe(( restapiProfile: RestapiProfile ) => {
            this.lovResource = restapiProfile.resource;
        } );
    }

    public setErrors( errors?: any ) {
        let valid = !( errors && Object.keys( errors ).length > 0 );
        if ( this.lovDetailInput ) {
            this.lovDetailInput.valid = valid;
        }
        this.errorMessage = valid ? undefined : errors[Object.keys( errors )[0]];
    }
    
    getFieldComponent() {
        return this.lovDetailInput;
    }

    onFieldClick( event ) {
        event.stopPropagation();
        this.onExpandIconClick();
    }

    onExpandIconClick( event?: Event ) {
        if ( event ) {
            event.stopPropagation();
        }
        let dialogRef = this.dialog.open( RestapiLovDialogComponent, {
            escapeToClose: true,
            clickOutsideToClose: true,
            data: {
                restapiService: this.restapiService,
                lovResource: this.lovResource
            }
        } );
        dialogRef.afterClosed().subscribe( data => {
            if ( data !== 'close' ) {
                this.updateLovValue( data );
            }
        } );
    }
    
    onClearIconClick( event ) {
        event.stopPropagation();
        this.updateLovValue();
    }

    updateLovValue( data?: any ) {
        if ( data && data.id ) {
            this.lovFormGroup.get( 'id' ).setValue( data.id );
            let lovValueDescription = ( this.lovResource.descriptionField ) ? data[this.lovResource.descriptionField] : this.lovResource.name + "_" + data.id;
            this.lovFormGroup.get( 'description' ).setValue( lovValueDescription );
            let formControlValue = {
                id: data.id
            };
            this.formControl.setValue( formControlValue );
        } else {
            this.lovFormGroup.get( 'id' ).setValue( undefined );
            this.lovFormGroup.get( 'description' ).setValue( undefined );
            this.formControl.setValue( undefined );
        }
    }

    createLovFormGroup( field: RestapiResourceField ) {
        let lovValueId = this.formControl.value ? this.formControl.value.id : undefined;
        let lovValueDescription;
        if ( lovValueId ) {
            if ( field.lovGenericResource ) {
                lovValueDescription = this.formControl.value['description'];
            } else if ( field.lovDescriptionField ) {
                lovValueDescription = this.formControl.value[field.lovDescriptionField];
            } else {
                lovValueDescription = field.lovResourceName + "_" + lovValueId;
            }
        }
        let lovControls = {};
        lovControls['id'] = { value: lovValueId, disabled: this.formControl.disabled };
        lovControls['description'] = { value: lovValueDescription, disabled: this.formControl.disabled };
        this.lovFormGroup = this.formBuilder.group( lovControls );
    }

    constructor(
        private formBuilder: FormBuilder,
        private restapiService: RestapiGenericService,
        private dialog: MdcDialog,
        private translateService: TranslateService ) {
        super();
    }

}