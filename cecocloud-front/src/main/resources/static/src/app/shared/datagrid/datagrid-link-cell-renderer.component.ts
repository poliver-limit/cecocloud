import { Component } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';

@Component( {
    template: `<a [routerLink]="linkUrl" [ngStyle]="{'left': left + 'px', 'width': width + 'px'}" *ngIf="showLink">&nbsp;</a>{{value}}`,
    styles: [`
a {
    display: inline;
    position: absolute;
    text-decoration: none;
}
`]
} )
export class DatagridLinkCellRenderer implements ICellRendererAngularComp {

    private params: any;
    private value: string;
    private linkUrl: any;
    private left: number;
    private width: number;
    private showLink: boolean;

    agInit( params: any ): void {
        this.params = params;
        this.value = ( params.valueFormatted ) ? params.valueFormatted : params.value;
        if ( params.data ) {
            this.linkUrl = './update/' + params.data.id;
        }
        let cellValueElement = params.eGridCell.querySelector( '.ag-cell-value' );
        if (!cellValueElement && params.eGridCell.classList.contains('ag-cell-value')) {
            cellValueElement = params.eGridCell;
        }
        this.left = cellValueElement.getBoundingClientRect().left - params.eGridCell.getBoundingClientRect().left;
        this.width = params.eGridCell.getBoundingClientRect().right - cellValueElement.getBoundingClientRect().left;
        this.showLink = params.context.gridComponent.hasMantenimentDirective && params.data;
    }

    refresh(): boolean {
        return false;
    }

}