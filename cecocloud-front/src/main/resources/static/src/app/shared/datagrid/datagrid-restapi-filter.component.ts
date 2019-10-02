import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { IAfterGuiAttachedParams, IDoesFilterPassParams, IFilterParams, RowNode } from 'ag-grid-community';
import { IFilterAngularComp } from 'ag-grid-angular';
import * as moment from 'moment';

import { RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';

@Component( {
    template: `
<div style="padding:.6em .6em 0 .6em">
    <restapi-field-material
        fieldName="operation"
        [formGroup]="formGroup"
        [restapiResource]="restapiResource"
        [hideLabel]="true"
        nativeControl="true"
        appearance="outline"
        (input)="onFieldInput($event)"
        style="width:100%"></restapi-field-material>
    <restapi-field-material
        fieldName="filter"
        [formGroup]="formGroup"
        [restapiResource]="restapiResource"
        [hideLabel]="true"
        appearance="outline"
        (input)="onFieldInput($event)"
        style="width:100%"></restapi-field-material>
</div>
`
} )
export class DatagridRestapiFilterComponent implements IFilterAngularComp {

    formGroup: FormGroup;
    restapiResource: RestapiResource = {
        name: 'filter',
        fields: []
    };
    resourceInstance: any = {};
    params: IFilterParams;
    operationField: RestapiResourceField;
    filterField: RestapiResourceField;
    value: string;
    isDateTime: boolean;

    private valueGetter: ( rowNode: RowNode ) => any;

    agInit( params: IFilterParams ): void {
        this.params = params;
        this.filterField = Object.assign( {}, params['restapiField'] );
        this.filterField.name = 'filter';
        this.filterField.required = false;
        if ( this.filterField.type === 'DATETIME' ) {
            this.filterField.type = 'DATE';
            this.isDateTime = true;
        }
        this.operationField = {
            name: 'operation',
            type: 'ENUM',
            enumValues: this.getOperationValues( this.filterField )
        };
        this.restapiResource.fields = [
            this.operationField,
            this.filterField];
        this.formGroup = this.formBuilder.group( {
            operation: ['EQUAL'],
            filter: new FormControl()
        } );
        this.valueGetter = params.valueGetter;
    }

    isFilterActive(): boolean {
        let value = this.formGroup.get( 'filter' ).value;
        return value !== null && value !== undefined;
    }

    doesFilterPass( params: IDoesFilterPassParams ): boolean {
        let value = this.formGroup.get( 'filter' ).value;
        return value == this.valueGetter( params.node );
    }

    getModel(): any {
        let processedOperation = this.formGroup.get( 'operation' ).value;
        let processedValue = this.formGroup.get( 'filter' ).value;
        let additionalPath: string;
        let additionalValue: string;
        if ( this.filterField.type === 'DATE' && this.isDateTime ) {
            processedOperation = 'BETWEEN';
            let m = moment( this.formGroup.get( 'filter' ).value )
            additionalValue = m.format( 'YYYY-MM-DD' ) + 'T23:59:59.999+0000';
        } else if ( this.filterField.type === 'LOV' ) {
            additionalPath = 'id';
        } else if ( this.filterField.type === 'ENUM' ) {
            processedOperation = 'IN';
            if ( Array.isArray( processedValue ) && processedValue.length > 1 ) {
                processedValue = '(' + processedValue + ')';
            }
        }
        let model = {
            value: processedValue,
            operation: processedOperation,
            type: this.filterField.type
        }
        if ( additionalPath ) {
            model['additionalPath'] = additionalPath;
        }
        if ( additionalValue ) {
            model['additionalValue'] = additionalValue;
        }
        return model;
    }

    setModel( model: any ): void {
        if ( model && model.value !== undefined ) {
            this.formGroup.setValue( {
                operation: model.operation,
                filter: model.value
            } );
        } else {
            this.formGroup.setValue( {
                operation: 'EQUAL',
                filter: ''
            } );
        }
    }

    ngAfterViewInit( params: IAfterGuiAttachedParams ): void {
        /*window.setTimeout(() => {
            this.input.element.nativeElement.focus();
        } )*/
    }

    onFieldInput( newValue ): void {
        this.params.filterChangedCallback();
        /*let enumValue = newValue;
        if ( newValue === '' ) {
            enumValue = undefined;
        }
        if ( this.value !== enumValue ) {
            this.value = enumValue;
            this.params.filterChangedCallback();
        }*/
    }

    onFloatingFilterChanged( operation, value ) {
        this.formGroup.setValue( {
            operation: operation,
            filter: value
        } );
        this.params.filterChangedCallback();
    }

    private getOperationValues( filterField: RestapiResourceField ): string[] {
        switch ( this.filterField.type ) {
            case 'INTEGER':
            case 'FLOAT':
            case 'BIGDECIMAL':
            case 'DATE':
            case 'DATETIME':
                return [
                    'EQUAL', 'NOT_EQUAL',
                    'GREATER_THAN', 'GREATER_THAN_OR_EQUAL',
                    'LESS_THAN', 'LESS_THAN_OR_EQUAL'];
            case 'BOOLEAN':
            case 'ENUM':
            case 'LOV':
                return ['EQUAL', 'NOT_EQUAL'];
            default:
                return [
                    'EQUAL', 'NOT_EQUAL',
                    'STARTS_WITH', 'ENDS_WITH',
                    'CONTAINS', 'NOT_CONTAINS',
                    'GREATER_THAN', 'GREATER_THAN_OR_EQUAL',
                    'LESS_THAN', 'LESS_THAN_OR_EQUAL'];
        }
    }

    constructor(
        private formBuilder: FormBuilder ) {
    }

}