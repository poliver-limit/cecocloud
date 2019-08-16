import { Component, Input, ViewChild, ViewContainerRef, Output, EventEmitter } from '@angular/core';

@Component( {
    selector: 'restapi-custom',
    template: '<ng-template #content></ng-template>'
} )
export class RestapiCustomComponent {

    @Input() fieldName: string;

    @ViewChild( 'content', { read: ViewContainerRef, static: false } ) contentRef: ViewContainerRef;
    @Output() fieldChange: EventEmitter<any> = new EventEmitter();
    @Output() fieldClick: EventEmitter<any> = new EventEmitter();

}
