import { Component, OnInit, Input, Output, EventEmitter, ElementRef, ViewChild, Renderer2 } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { MatInput } from '@angular/material/input';
import { MdcDialog, MdcDialogComponent, MdcDialogRef } from '@angular-mdc/web';
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
    selector: 'restapi-lov-material',
    template: `
<mat-form-field *ngIf="lovFormGroup" [formGroup]="lovFormGroup" style="width:100%">
    <input
        #lovHiddenInput
        type="hidden"
        formControlName="id"/>
    <mat-label *ngIf="!hideLabel">{{label}}</mat-label>
    <input
        matInput
        type="text"
        formControlName="description"
        [required]="field.required"
        [readonly]="isReadonly"
        (click)="onFieldClick($event)"
        (blur)="onFieldBlur()"
        (keydown)="onFieldKeydown($event)"
        (change)="onFieldChange($event)"/>
    <button *ngIf="!formControl.value" mat-icon-button matSuffix (click)="onExpandIconClick($event)" tabindex="-1">
        <mat-icon>arrow_drop_down</mat-icon>
    </button>
    <button *ngIf="formControl.value" mat-icon-button matSuffix (click)="onClearIconClick($event)" tabindex="-1">
        <mat-icon>clear</mat-icon>
    </button>
    <mat-error>{{errorMessage}}</mat-error>
</mat-form-field>
`,
    providers: [RestapiGenericService]
} )
export class RestapiLovMaterialComponent extends RestapiBaseFieldComponent implements OnInit {

    @ViewChild( 'lovHiddenInput', { static: false } ) lovHiddenInput: ElementRef;
    @ViewChild( 'lovDetailInput', { static: false } ) lovDetailInput: MatInput;

    private lovFormGroup: FormGroup;
    private lovResource: RestapiResource;
    private errorMessage: string;

    private isReadonly: boolean;

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
        if ( !valid ) {
            this.lovFormGroup.get( 'description' ).markAsTouched();
            this.lovFormGroup.get( 'description' ).setErrors( errors );
        } else {
            this.lovFormGroup.get( 'description' ).setErrors( null );
        }
        this.errorMessage = valid ? undefined : errors[Object.keys( errors )[0]];
    }

    getFieldComponent() {
        return this.lovDetailInput;
    }

    onFieldClick( event ) {
        this.isReadonly = true;
        if ( this.lovFormGroup.get( 'id' ).value ) {
            event.target.select();
        } else {
            this.onExpandIconClick();
            event.stopPropagation();
            event.preventDefault();
        }
        this.click.emit( event );
    }
    onFieldBlur() {
        this.isReadonly = false;
    }
    onFieldKeydown( event ) {
        if ( event.keyCode == 8 || event.keyCode == 46 ) {
            this.updateLovValue();
        } else if ( event.keyCode == 13 && !this.lovFormGroup.get( 'id' ).value ) {
            this.onExpandIconClick();
        }
        return event.keyCode == 27 || event.keyCode == 9 || event.code.startsWith( 'F' );
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
        private translateService: TranslateService,
        private dialog: MdcDialog ) {
        super();
    }

}