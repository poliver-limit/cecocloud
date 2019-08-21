import { Directive, Component, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';

@Component( {} )
export abstract class RestapiBaseFieldComponent {

    @Input() label: string;
    @Input() resource: RestapiResource;
    @Input() field: RestapiResourceField;
    @Input() formGroup: FormGroup;

    @Output() change: EventEmitter<any> = new EventEmitter();
    @Output() click: EventEmitter<any> = new EventEmitter();

    public abstract setValid( valid: boolean, errorMessage?: string );
    public abstract focus();

}
