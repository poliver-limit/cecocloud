import { Component, Input, Output, EventEmitter, ViewChild, ViewContainerRef, ContentChild } from '@angular/core';

import { RestapiBaseFieldComponent } from './restapi-base-field.component';

@Component( {
    selector: 'restapi-custom',
    template: `
<ng-content></ng-content>
<ng-template #content></ng-template>`
} )
export class RestapiCustomFieldComponent {

    @Input() name: string;

    @Output() fieldChange: EventEmitter<any> = new EventEmitter();
    @Output() fieldClick: EventEmitter<any> = new EventEmitter();

    @ViewChild( 'content', { read: ViewContainerRef, static: false } ) contentRef: ViewContainerRef;
    @ContentChild( 'customField', { static: false } ) fieldComponent;

    public getContentField() {
        return this.fieldComponent;
    }

}
