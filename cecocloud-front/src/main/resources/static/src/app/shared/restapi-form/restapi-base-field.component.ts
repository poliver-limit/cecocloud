import { Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Resource } from 'angular4-hal';

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';

export abstract class RestapiBaseFieldComponent {

    @Input() label: string;
    @Input() fieldName: string;
    @Input() formGroup: FormGroup;
    @Input() restapiResource: RestapiResource;
    @Input() resourceInstance: Resource;
    @Input() hideLabel: boolean;

    @Output() click: EventEmitter<any> = new EventEmitter();
    @Output() change: EventEmitter<any> = new EventEmitter();

    formControl: FormControl;
    field: RestapiResourceField;

    baseOnInit(
            fieldName: string,
            formGroup: FormGroup,
            restapiResource: RestapiResource) {
        this.formControl = <FormControl>formGroup.get( fieldName );
        restapiResource.fields.forEach(( field: RestapiResourceField ) => {
            if ( field.name == fieldName ) {
                this.field = field;
            }
        } );
    }

    onFieldClick( event ) {
        this.click.emit( event );
    }
    onFieldChange( event ) {
        if ( event.target && event.target.value === '' ) {
            this.formControl.reset();
        }
        this.change.emit( event );
    }

    public focus() {
        if ( this.getFieldComponent() && this.getFieldComponent()['focus'] ) {
            this.getFieldComponent()['focus']();
        }
    }

    public abstract setErrors( errors?: any );
    public abstract getFieldComponent(): any;

}
