import { Component, Input, Output, TemplateRef, EventEmitter, ViewChild, ViewContainerRef, ElementRef, ContentChild } from '@angular/core';

import { RestapiBaseFieldComponent } from './restapi-base-field.component';

@Component( {
    selector: 'restapi-custom',
    template: `
<div #body><ng-content></ng-content></div>
<ng-template #content></ng-template>`
} )
export class RestapiCustomFieldComponent {

    @Input() name: string;
    @Input() componentTemplate: TemplateRef<any>;

    @Output() fieldChange: EventEmitter<any> = new EventEmitter();
    @Output() fieldClick: EventEmitter<any> = new EventEmitter();

    @ViewChild( 'content', { read: ViewContainerRef, static: false } ) contentRef: ViewContainerRef;
    @ViewChild( 'body', { static: false } ) bodyRef: ElementRef;
    @ContentChild( 'customField', { static: false } ) fieldComponent: RestapiBaseFieldComponent;

    public getContentField() {
        return this.fieldComponent;
    }

}
