import { Component, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Resource } from 'angular4-hal';

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';

@Component( {} )
export abstract class RestapiBaseFieldComponent {

    @Input() label: string;
    @Input() fieldName: string;
    @Input() formGroup: FormGroup;
    @Input() restapiResource: RestapiResource;
    @Input() resourceInstance: Resource;

    @Output() click: EventEmitter<any> = new EventEmitter();
    @Output() change: EventEmitter<any> = new EventEmitter();

    protected formControl: FormControl;
    protected field: RestapiResourceField;

    baseOnInit(
            fieldName: string,
            formGroup: FormGroup,
            restapiResource: RestapiResource) {
        this.formControl = <FormControl>formGroup.get( fieldName );
        // this.field = this.restapiResource.fields.filter(( field: RestapiResourceField ) => field.name == this.fieldName );
        restapiResource.fields.forEach(( field: RestapiResourceField ) => {
            if ( field.name == fieldName ) {
                this.field = field;
            }
        } );
    }

    protected onFieldClick( event ) {
        this.click.emit( event );
    }
    protected onFieldChange( event ) {
        if ( event.target && event.target.value === '' ) {
            this.formControl.reset();
        }
        this.change.emit( event );
    }

    public focus() {
        if ( this.getFieldComponent && this.getFieldComponent['focus'] ) {
            this.getFieldComponent()['focus']();
        }
    }

    public abstract setErrors( errors?: any );
    public abstract getFieldComponent(): any;

}
