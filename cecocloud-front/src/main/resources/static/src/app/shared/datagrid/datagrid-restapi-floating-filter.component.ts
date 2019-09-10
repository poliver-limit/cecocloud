import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { IAfterGuiAttachedParams, IDoesFilterPassParams, IFilterParams, RowNode, IFloatingFilterParams, FilterChangedEvent, TextFilter } from 'ag-grid-community';
import { IFilterAngularComp, IFloatingFilterComp } from 'ag-grid-angular';
import * as moment from 'moment';

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';

export interface DatagridRestapiFloatingFilterParams extends IFloatingFilterParams {
    value: number;
    maxValue: number;
}

@Component( {
    template: `
<restapi-field-material
    fieldName="filter"
    [inputFormGroup]="formGroup"
    [restapiResource]="restapiResource"
    [hideLabel]="true"
    appearance="outline"
    (input)="onFieldInput($event)"
    style="width:100%; position: relative; top: 2px;"></restapi-field-material>
`,
    styles: [`
:host {
    width: 100%;
}
`]
} )
export class DatagridRestapiFloatingFilterComponent implements IFloatingFilterComp {

    formGroup: FormGroup;
    restapiResource: RestapiResource = {
        name: 'floatingFilter',
        fields: []
    };
    resourceInstance: any = {};
    params: DatagridRestapiFloatingFilterParams;
    field: RestapiResourceField;
    value: string;

    agInit( params: DatagridRestapiFloatingFilterParams ): void {
        this.params = params;
        this.field = Object.assign( {}, params['restapiField'] );
        this.field.name = 'filter';
        this.field.required = false;
        if ( this.field.type === 'DATETIME' ) {
            this.field.type = 'DATE';
        }
        this.restapiResource.fields = [this.field];
        this.formGroup = this.formBuilder.group( {
            filter: new FormControl()
        } );
    }

    onParentModelChanged( parentModel: any, event: FilterChangedEvent ): void {
        if ( parentModel ) {
            if ( parentModel.operator ) {
                this.value = parentModel.condition1.filter + ' ' + parentModel.operator + ' ' + parentModel.condition2.filter;
            } else {
                this.value = parentModel.filter;
            }
        } else {
            this.value = undefined;
        }
    }

    valueChanged( value ) {
        let filterType;
        let processedValue;
        if ( value && this.field.type === 'BOOLEAN' ) {
            filterType = 'EQUAL';
            processedValue = ( value ) ? value : null;
        } else if ( value && this.field.type === 'ENUM' ) {
            filterType = 'EQUAL';
            processedValue = ( value ) ? value : null;
        } else if ( value && this.field.type === 'DATE' ) {
            filterType = 'EQUAL';
            if ( value ) {
                let m = moment( value.format( 'YYYY-MM-DD' ) + ' 00:00:00', 'YYYY-MM-DD HH:mm:ss' );
                processedValue = m.format( 'YYYY-MM-DD' ) + 'T' + m.format( 'HH:mm:ss.SSS' ) + '+0000';
            } else {
                processedValue = null;
            }
        } else if ( value && this.field.type === 'LOV' ) {
            filterType = 'EQUAL';
            processedValue = value.id;
        } else {
            filterType = 'CONTAINS';
            processedValue = ( value ) ? value : null;
        }
        this.params.parentFilterInstance( function( instance ) {
            ( <TextFilter>instance ).onFloatingFilterChanged(
                filterType,
                processedValue );
        } );
    }

    onFieldInput( event ) {
        this.valueChanged( this.formGroup.get( 'filter' ).value )
    }

    constructor(
        private formBuilder: FormBuilder ) {
    }

}