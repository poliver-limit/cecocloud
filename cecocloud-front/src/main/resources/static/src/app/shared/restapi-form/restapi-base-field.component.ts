import { Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { Resource } from 'angular4-hal';

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';

export abstract class RestapiBaseFieldComponent {

    @Input() fieldName: string;
    @Input()
    set formGroup( formGroup: FormGroup ) {
        this.internalFormGroup = formGroup;
        this.formControl = <FormControl>this.internalFormGroup.get( this.fieldName );
    }
    @Input()
    set restapiResource( restapiResource: RestapiResource ) {
        this.internalRestapiResource = restapiResource;
        restapiResource.fields.forEach(( field: RestapiResourceField ) => {
            if ( field.name == this.fieldName ) {
                this.field = field;
            }
        } );
        this.label = ( this.field.translateKey ) ? this.translateKey( this.field.translateKey, {}, this.fieldName ) : this.fieldName;
    }
    @Input() resourceInstance: Resource;
    @Input() hideLabel: boolean;

    @Output() click: EventEmitter<any> = new EventEmitter();
    @Output() input: EventEmitter<any> = new EventEmitter();
    @Output() change: EventEmitter<any> = new EventEmitter();

    internalFormGroup: FormGroup;
    internalRestapiResource: RestapiResource;
    formControl: FormControl;
    field: RestapiResourceField;
    label: string;
    translate: TranslateService;

    onFieldClick( event ) {
        this.click.emit( event );
    }
    onFieldInput( event ) {
        this.input.emit( event );
    }
    onFieldChange( event ) {
        this.change.emit( event );
    }

    public focus() {
        if ( this.getFieldComponent() && this.getFieldComponent()['focus'] ) {
            this.getFieldComponent()['focus']();
        }
    }

    translateKey( key: string, params?: any, defaultValue?: string ) {
        let translatedKey = this.translate.instant( key, params );
        if ( defaultValue ) {
            return ( translatedKey !== key ) ? translatedKey : defaultValue;
        } else {
            return translatedKey;
        }
    }

    public abstract setErrors( errors?: any );
    public abstract getFieldComponent(): any;

    constructor(
        translate: TranslateService ) {
        this.translate = translate;
    }

}
