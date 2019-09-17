import { Component, OnInit, Input, Output, EventEmitter, ElementRef, ViewChild, Renderer2 } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { of } from 'rxjs';
import { debounceTime, tap, switchMap, finalize } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { TranslateService } from '@ngx-translate/core';
import { MatInput, MatAutocompleteTrigger } from '@angular/material';
import { MdcDialog, MdcDialogComponent, MdcDialogRef } from '@angular-mdc/web';
import { Resource } from 'angular4-hal';

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
<!--mat-form-field *ngIf="lovFormGroup" [formGroup]="lovFormGroup" [appearance]="appearance" style="width:100%">
    <input
        #lovHiddenInput
        type="hidden"
        formControlName="id"/>
    <mat-label *ngIf="!hideLabel">{{label}}</mat-label>
    <input
        matInput
        #lovDetailInput
        type="text"
        formControlName="description"
        [required]="field.required"
        [readonly]="isReadonly"
        (click)="onFieldClick($event)"
        (input)="onFieldInput($event)"
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
</mat-form-field-->
<mat-form-field *ngIf="lovFormGroup" [formGroup]="lovFormGroup" [appearance]="appearance" style="width:100%">
    <mat-label *ngIf="!hideLabel">{{label}}</mat-label>
    <input
        #lovHiddenInput
        type="hidden"
        formControlName="id"/>
    <input
        matInput
        #lovDetailInput
        [matAutocomplete]="lovAutocomplete"
        [type]="text"
        [readonly]="isReadonly"
        formControlName="description"
        [required]="field.required"
        (click)="onFieldClick($event)"
        (input)="onFieldInput($event)"
        (blur)="onFieldBlur()"
        (keydown)="onFieldKeydown($event)"
        (change)="onFieldChange($event)"/>
    <mat-autocomplete
        #lovAutocomplete="matAutocomplete"
        autoActiveFirstOption="false"
        [displayWith]="displayWith.bind(this)"
        (optionSelected)="onOptionSelected($event)">
        <mat-option *ngIf="isLoading"><mat-spinner diameter="40"></mat-spinner></mat-option>
        <mat-option *ngFor="let resource of autocompleteResources" [value]="resource">
            {{displayResource(resource)}}
        </mat-option>
        <mat-option id="FIND">Cercar...</mat-option>
    </mat-autocomplete>
</mat-form-field>
`,
    providers: [RestapiGenericService]
} )
export class RestapiLovMaterialComponent extends RestapiBaseFieldComponent implements OnInit {

    @Input() appearance: string = 'standard'; // 'legacy' | 'standard' | 'fill' | 'outline'

    @ViewChild( 'lovHiddenInput', { static: false } ) lovHiddenInput: ElementRef;
    @ViewChild( 'lovDetailInput', { static: false } ) lovDetailInput: ElementRef;
    @ViewChild( MatAutocompleteTrigger, { static: false } ) lovAutocomplete: MatAutocompleteTrigger;
    //@ViewChild( 'lovAutocomplete', { static: false } ) lovAutocomplete: MatAutocompleteTrigger;

    lovFormGroup: FormGroup;
    lovResource: RestapiResource;
    errorMessage: string;

    autocompleteResources: Resource[];
    isLoading: boolean;
    isReadonly: boolean;

    ngOnInit() {
        this.createLovFormGroup( this.field );
        this.restapiService.configureWithResourceName( this.field.lovResourceName );
        this.restapiService.whenReady().subscribe(( restapiProfile: RestapiProfile ) => {
            this.lovResource = restapiProfile.resource;
        } );
        this.lovFormGroup.get( 'description' ).valueChanges.pipe(
            debounceTime( 250 ),
            tap( value => {
                this.autocompleteResources = [];
                this.isLoading = true;
            } ),
            switchMap( value => {
                if ( !this.formControl.value ) {
                    let params;
                    if ( value ) {
                        params = [{ key: 'quickFilter', value: value }];
                    }
                    return this.restapiService.getAll( { size: 100, params: params } )
                } else {
                    return of( null );
                }
            } ),
            finalize(() => {
                this.isLoading = false;
            } )
        ).subscribe( resources => {
            this.isLoading = false;
            if ( resources ) {
                this.autocompleteResources = resources;
                this.lovAutocomplete.openPanel();
            } else {
                this.autocompleteResources = [];
            }
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

    onOptionSelected( event ) {
        if ( event.option.id !== 'FIND' ) {
            if ( event.option.value ) {
                let formControlValue = {
                    id: event.option.value.id
                };
                this.formControl.setValue( formControlValue );
                this.isReadonly = true;
            } else {
                this.formControl.setValue( undefined );
                this.isReadonly = false;
            }
            this.lovDetailInput.nativeElement.dispatchEvent( new Event( 'input', { bubbles: true } ) );
        } else {
            this.openLovDialog();
        }
    }
    onFieldClick( event ) {
        if ( this.formControl.value ) {
            this.isReadonly = true;
        } else {
            this.lovFormGroup.get( 'description' ).setValue( event.target.value );
            this.isReadonly = false;
        }
        this.click.emit( event );
    }
    onFieldInput( event ) {
        this.input.emit( event );
    }
    onFieldBlur() {
        this.isReadonly = false;
    }
    onFieldKeydown( event ) {
        if ( this.formControl.value ) {
            if ( event.keyCode == 8 || event.keyCode == 46 ) {
                this.updateLovValue();
                this.isReadonly = false;
            }
            return event.keyCode == 27 || event.keyCode == 9 || event.code.startsWith( 'F' );
        } else {
            return true;
        }
    }

    /*onFieldClick( event ) {
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
    onFieldInput( event ) {
        this.input.emit( event );
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
    }*/

    openLovDialog() {
        let dialogRef = this.dialog.open( RestapiLovDialogComponent, {
            escapeToClose: true,
            clickOutsideToClose: true,
            data: {
                restapiService: this.restapiService,
                lovResource: this.lovResource
            }
        } );
        dialogRef.afterClosed().subscribe( data => {
            this.lovDetailInput.nativeElement.focus();
            if ( data !== 'close' ) {
                this.updateLovValue( data );
            }
        } );
    }

    updateLovValue( data?: any ) {
        if ( data && data.id ) {
            let lovValueDescription = ( this.lovResource.descriptionField ) ? data[this.lovResource.descriptionField] : '#' + data.id;
            let formControlValue = {
                id: data.id
            };
            this.formControl.setValue( formControlValue );
            this.lovFormGroup.get( 'description' ).setValue( data );
        } else {
            console.log( '>>> updateLovValue delete' )
            this.formControl.setValue( undefined );
            this.lovFormGroup.get( 'id' ).setValue( undefined );
            this.lovFormGroup.get( 'description' ).setValue( undefined );
        }
        this.lovDetailInput.nativeElement.dispatchEvent( new Event( 'input', { bubbles: true } ) );
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
                lovValueDescription = '#' + lovValueId;
            }
        }
        let lovControls = {};
        lovControls['id'] = { value: lovValueId, disabled: this.formControl.disabled };
        lovControls['description'] = { value: lovValueDescription, disabled: this.formControl.disabled };
        this.lovFormGroup = this.formBuilder.group( lovControls );
    }

    displayWith( this, resource?: Resource ): string | undefined {
        if ( resource ) {
            if ( resource instanceof Resource ) {
                return this.displayResource( resource );
            } else {
                return resource;
            }
        }
    }
    displayResource( resource?: Resource ): string | undefined {
        if ( resource ) {
            let descriptionField = ( this.lovResource ) ? this.lovResource.descriptionField : undefined;
            return ( descriptionField ) ? resource[descriptionField] : '#' + resource['id'];
        }
    }

    constructor(
        private formBuilder: FormBuilder,
        private http: HttpClient,
        private restapiService: RestapiGenericService,
        translateService: TranslateService,
        private dialog: MdcDialog ) {
        super( translateService );
    }

}