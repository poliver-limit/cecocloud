import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { IAfterGuiAttachedParams, IDoesFilterPassParams, IFilterParams, RowNode } from 'ag-grid-community';
import { IFilterAngularComp } from 'ag-grid-angular';

/*export interface SerializedEnumFilter extends SerializedFilter {
    filter: string;
    type: string;
}*/

/*@Component( {
    template: `
    <select #input [ngModel]="value" (ngModelChange)="onChange($event)" style="margin:4px; width: calc(100% - 8px)">
        <option></option>
        <option *ngFor="let enumValue of enumValues" value="{{enumValue}}">{{enumValue}}</option>
    </select>`
} )*/
export class DatagridFilterEnumComponent implements IFilterAngularComp {

    private params: IFilterParams;
    private enumValues: string[];
    private valueGetter: ( rowNode: RowNode ) => any;
    public value: string;

    //@ViewChild( 'input', { read: ViewContainerRef } ) public input;

    agInit( params: IFilterParams ): void {
        this.params = params;
        this.enumValues = params['enumValues'];
        this.valueGetter = params.valueGetter;
    }

    isFilterActive(): boolean {
        return this.value !== null && this.value !== undefined;
    }

    doesFilterPass( params: IDoesFilterPassParams ): boolean {
        return this.value == this.valueGetter( params.node );
    }

    getModel(): any {
        return {
            filter: this.value,
            filterType: 'enum',
            type: 'equals'
        };
    }

    setModel( model/*: SerializedEnumFilter*/ ): void {
        if ( model.filter !== undefined ) {
            this.value = model.filter;
        } else {
            this.value = undefined;
        }
    }

    ngAfterViewInit( params: IAfterGuiAttachedParams ): void {
        /*window.setTimeout(() => {
            this.input.element.nativeElement.focus();
        } )*/
    }

    onChange( newValue ): void {
        let enumValue = newValue;
        if (newValue === '') {
            enumValue = undefined;
        }
        if ( this.value !== enumValue ) {
            this.value = enumValue;
            this.params.filterChangedCallback();
        }
    }

}