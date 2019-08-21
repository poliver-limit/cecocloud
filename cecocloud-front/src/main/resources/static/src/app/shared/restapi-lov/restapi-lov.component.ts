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
import { RestapiLovDialogComponent } from './restapi-lov-dialog.component';

@Component( {
    selector: 'restapi-lov',
    template: `
<div *ngIf="formGroupConfigured" [formGroup]="formGroup" style="display:flex; justify-content: space-between;width: 100%">
    <ng-container [formGroupName]="formGroupName">
        <input
            #lovHiddenInput
            type="hidden"
            formControlName="id"/>
        <mdc-text-field
            #lovDetailInput
            [label]="label"
            formControlName="description"
            [required]="required"
            [helperText]="helperText"
            (click)="onDetailInputClick($event)"
            style="flex-basis:100%"
            readonly outlined dense>
            <mdc-icon *ngIf="hasValue" mdcTextFieldIcon trailing clickable (click)="onClearIconClick($event)">clear</mdc-icon>
            <mdc-icon *ngIf="!hasValue" mdcTextFieldIcon trailing clickable (click)="onExpandIconClick($event)">expand_more</mdc-icon>
        </mdc-text-field>
    </ng-container>
</div>`,
    providers: [RestapiGenericService]
} )
export class RestapiLovComponent {

    @Input() label;
    @Input() formGroup: FormGroup;
    @Input() resource: RestapiResource;
    @Input()
    set field( field: RestapiResourceField ) {
        this.formGroupName = field.name;
        this.lovResourceName = field.lovResourceName;
        this.lovParentField = field.lovParentField;
        this.restapiService.configureWithResourceName( this.lovResourceName );
        this.restapiService.whenReady().subscribe(( restapiProfile: RestapiProfile ) => {
            this.lovResourceTranslateKey = restapiProfile.resource.translateKey;
            this.descriptionField = restapiProfile.resource.descriptionField;
            restapiProfile.resource.fields.forEach(( field: RestapiResourceField ) => {
                if ( !field.hiddenInLov ) {
                    this.dialogColumns.push( {
                        field: field.name,
                        editable: false
                    } );
                }
            } );
            this.formControlDisabled = this.formGroup.controls[field.name].disabled;
            this.updateLovInputValues( this.formGroup.value[field.name], field.lovDescriptionFieldInFront );
        } );
        this.required = field.required;
    }
    @Input() helperText: MdcHelperText;

    @Output() change: EventEmitter<any> = new EventEmitter();

    @ViewChild( 'lovHiddenInput', { static: false } ) lovHiddenInput: ElementRef;
    @ViewChild( 'lovDetailInput', { static: false } ) lovDetailInput: MdcTextField;

    private formGroupName: string;
    private formGroupConfigured: boolean = false;
    private formControlDisabled: boolean;
    private lovResourceName: string;
    private lovResourceTranslateKey: string;
    private lovParentField: string;
    private descriptionField: string;
    private hasValue: boolean = false;
    private dialogColumns: any[] = [];
    private required: boolean;

    public setValid( valid: boolean ) {
        if ( this.lovDetailInput ) {
            this.lovDetailInput.valid = valid;
        }
    }

    public focus() {
        if ( this.lovDetailInput ) {
            this.lovDetailInput.focus();
        }
    }

    onDetailInputClick( event ) {
        event.stopPropagation();
        this.onExpandIconClick();
    }

    onClearIconClick( event ) {
        event.stopPropagation();
        this.processLovChange();
    }

    onExpandIconClick( event?: Event ) {
        if ( event ) {
            event.stopPropagation();
        }
        if ( !this.lovParentField || ( this.lovParentField && this.getParent() ) ) {
            let dialogRef = this.dialog.open( RestapiLovDialogComponent, {
                escapeToClose: true,
                clickOutsideToClose: true,
                data: {
                    restapiService: this.restapiService,
                    resourceTranslateKey: this.lovResourceTranslateKey,
                    columns: this.dialogColumns,
                    parent: this.getParent(),
                }
            } );
            dialogRef.afterClosed().subscribe( data => {
                if ( data !== 'close' ) {
                    this.processLovChange( data );
                }
            } );
        }
    }

    processLovChange( data?: any ) {
        let childField;
        this.resource.fields.forEach(( formField: RestapiResourceField ) => {
            if ( formField.lovParentField === this.formGroupName ) {
                childField = formField;
            }
        } );
        if ( childField ) {
            let emptyLovValue = {
                id: undefined,
                pk: undefined,
                description: undefined
            };
            if ( this.descriptionField ) {
                emptyLovValue[this.descriptionField] = undefined;
            }
            let patchValue = {};
            patchValue[childField.name] = emptyLovValue;
            this.formGroup.patchValue( patchValue )
        }
        this.updateLovInputValues( data );
        this.change.emit( data );
    }

    updateLovInputValues( data?: any, descriptionField?: string ) {
        if ( !descriptionField ) {
            descriptionField = this.descriptionField;
        }
        let valueId = ( data ) ? data['id'] : null;
        let valuePk = ( data ) ? data['pk'] : null;
        let valueDescription = '';
        if ( data ) {
            valueDescription = ( descriptionField ) ? data[descriptionField] : this.lovResourceName + "_" + valueId;
        }
        let lovControls = {};
        lovControls['id'] = { value: valueId, disabled: this.formControlDisabled };
        if ( valuePk ) {
            lovControls['pk'] = { value: valuePk, disabled: this.formControlDisabled };
        }
        lovControls['description'] = { value: valueDescription, disabled: this.formControlDisabled };
        if ( descriptionField ) {
            lovControls[descriptionField] = ( data ) ? data[descriptionField] : null;
        }
        this.formGroup.removeControl( this.formGroupName );
        this.formGroup.setControl( this.formGroupName, this.formBuilder.group( lovControls ) );
        if ( this.lovDetailInput ) {
            this.lovHiddenInput.nativeElement.value = valueId;
            this.lovDetailInput.value = valueDescription;
        }
        this.formGroup.get( this.formGroupName ).valueChanges.subscribe( value => {
            if ( !value.id ) {
                this.change.emit( {} );
            }
        } );
        this.hasValue = valueId !== null;
        this.formGroupConfigured = true;
    }

    getParent(): any {
        let parent = {};
        if ( this.lovParentField ) {
            let parentFieldValue = this.formGroup.controls[this.lovParentField].value;
            if ( parentFieldValue ) {
                parent = parentFieldValue.pk;
            }
        }
        return parent;
    }

    constructor(
        private formBuilder: FormBuilder,
        private restapiService: RestapiGenericService,
        private dialog: MdcDialog,
        private translateService: TranslateService ) { }

}