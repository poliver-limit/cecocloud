import { Component, Input, Output, EventEmitter, ElementRef, ViewChild, Inject } from '@angular/core';
import { MdcDialog, MdcDialogComponent, MdcDialogRef, MDC_DIALOG_DATA, MdcTextField } from '@angular-mdc/web';

import { RestapiGenericService } from '../restapi/restapi-generic.service';
import { DatagridConfig } from '../datagrid/datagrid.component';

@Component( {
    template: `
<mdc-dialog class="restapi-lov-dialog">
    <mdc-dialog-container>
        <mdc-dialog-surface>
            <mdc-dialog-title>{{ 'component.restapi.lov.title' | translate }} {{ resourceTranslateKey | translate | lowercase }}</mdc-dialog-title>
            <mdc-dialog-content>
                <datagrid
                    [config]="datagridConfig"
                    [restapiService]="restapiService"
                    (selectionChanged)="onDatagridSelectionChanged($event)"
                    (rowDoubleClicked)="onDatagridRowDoubleClicked($event)"></datagrid>
            </mdc-dialog-content>
            <mdc-dialog-actions>
                <button
                    mdcDialogButton
                    mdcDialogAction="close">{{ 'component.restapi.lov.button.close' | translate }}</button>
                <button
                    mdcDialogButton
                    mdcDialogAction="accept"
                    [disabled]="!selectedRowData"
                    (click)="onSelectButtonClick()">{{ 'component.restapi.lov.button.select' | translate }}</button>
            </mdc-dialog-actions>
        </mdc-dialog-surface>
    </mdc-dialog-container>
</mdc-dialog>`
} )
export class RestapiLovDialogComponent {

    private restapiService: RestapiGenericService;
    private resourceTranslateKey: string;
    private datagridConfig: DatagridConfig;
    private selectedRowData: any;

    onDatagridSelectionChanged( event ) {
        this.selectedRowData = ( event.api.getSelectedRows() ) ? event.api.getSelectedRows()[0] : null;
    }

    onDatagridRowDoubleClicked( event ) {
        this.sendSelectionAndClose( event.data );
    }

    onSelectButtonClick(): void {
        this.sendSelectionAndClose( this.selectedRowData );
    }

    sendSelectionAndClose( data: any ) {
        this.selectedRowData = data;
        this.dialogRef.close( this.selectedRowData );
    }

    constructor(
        public dialogRef: MdcDialogRef<RestapiLovDialogComponent>,
        @Inject( MDC_DIALOG_DATA ) public data ) {
        this.restapiService = data.restapiService;
        this.resourceTranslateKey = data.resourceTranslateKey;
        this.datagridConfig = {
            columns: data.columns,
            parent: data.parent,
            lovMode: true
        }
    }

}