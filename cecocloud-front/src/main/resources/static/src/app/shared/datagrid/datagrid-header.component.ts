import { Component, ViewChild, ElementRef, Output, EventEmitter } from '@angular/core';
import { IHeaderGroupAngularComp } from 'ag-grid-angular';
import { TranslateService } from '@ngx-translate/core';
import { Subscription } from 'rxjs';

import {
    RestapiProfile,
    RestapiResource,
    RestapiResourceField
} from '../restapi/restapi-profile';
import { DatagridConfig } from './datagrid.component';

@Component( {
    selector: 'datagrid-header',
    template: `
<div class="datagrid-header">
    <mdc-top-app-bar-row *ngIf="!lovMode">
        <mdc-top-app-bar-section align="start" [title]="title">
        </mdc-top-app-bar-section>
        <mdc-top-app-bar-section align="end">
            <button mdc-icon-button class="mdc-icon-button-sm" title="{{'component.datagrid.header.button.crear'|translate}}"(click)="onButtonCreateClick()">
                <mdc-icon>add</mdc-icon>
            </button>
            <!--button mdc-icon-button class="mdc-icon-button-sm" title="{{'component.datagrid.header.button.importar'|translate}}" (click)="onButtonImportClick()">
                <mdc-icon>get_app</mdc-icon>
            </button-->
            <button mdc-icon-button class="mdc-icon-button-sm" [disabled]="!anyRowSelected" title="{{'component.datagrid.header.action.delete'|translate}}" (click)="onButtonDeleteClick()">
                <mdc-icon>delete</mdc-icon>
            </button>
            <!--button mdc-icon-button class="mdc-icon-button-sm">
                <mdc-icon>build</mdc-icon>
            </button-->
            <mat-form-field *ngIf="quickFilterAvailable" appearance="outline" class="mat-form-field-sm" style="margin-left: 1em">
                <input matInput type="text" (input)="onQuickFilterChange($event)"/>
                <mat-icon matSuffix>search</mat-icon>
            </mat-form-field>
        </mdc-top-app-bar-section>
    </mdc-top-app-bar-row>
    <mdc-top-app-bar-row *ngIf="lovMode && quickFilterAvailable" style="border-top: 1px solid #e2e2e2">
        <mdc-top-app-bar-section>
            <mat-form-field *ngIf="quickFilterAvailable" appearance="outline" class="mat-form-field-sm" style="width:100%">
                <input matInput type="text" (input)="onQuickFilterChange($event)"/>
                <mat-icon matSuffix>search</mat-icon>
            </mat-form-field>
        </mdc-top-app-bar-section>
    </mdc-top-app-bar-row>
    <!--mdc-top-app-bar-row>
        <mdc-top-app-bar-section align="start">
            <ng-container *ngIf="paginationActive">
                <button mdc-icon-button (click)="onPageFirstClick()" [disabled]="paginationFirstPage" class="mdc-icon-button-xs"><mdc-icon>first_page</mdc-icon></button>
                <button mdc-icon-button (click)="onPageDownClick()" [disabled]="paginationFirstPage" class="mdc-icon-button-xs"><mdc-icon>chevron_left</mdc-icon></button>
                &nbsp;{{paginationCurrentPage}}&nbsp;
                <button mdc-icon-button (click)="onPageUpClick()" [disabled]="paginationLastPage" class="mdc-icon-button-xs"><mdc-icon>chevron_right</mdc-icon></button>
                <button mdc-icon-button (click)="onPageLastClick()" [disabled]="paginationLastPage" class="mdc-icon-button-xs"><mdc-icon>last_page</mdc-icon></button>
            </ng-container>
        </mdc-top-app-bar-section>
    </mdc-top-app-bar-row-->
</div>
`,
    styles: [`
.datagrid-header {
    /*background-color: grey;
    color: white;*/
    background-color: #f2f2f2;
    color: rgba(0, 0, 0, 0.54);
    border-bottom: 1px solid #e2e2e2;
}
.datagrid-header-lov {
    border-top: 1px solid #e2e2e2;
}
`],
/*    template: `
<div class="page-header">
    <div class="header-first-row">
        <div class="mant-headline" mdcHeadline6 *ngIf="!lovMode">
            <!--span class="main">Invoices</span><span class="current"> / FAC-123/2017</span-->
            <span class="main">{{title}}</span>
        </div>
        <div *ngIf="quickFilterAvailable" [ngClass]="{'mant-filter': !lovMode, 'mant-filter-lov': lovMode}">
            <!--mat-form-field style="width:100%">
                <mat-label>Filtre</mat-label>
                <input matInput type="text" (input)="onQuickFilterChange($event)"/>
                <mat-icon matSuffix>search</mat-icon>
            </mat-form-field-->
            <div class="ag-input-wrapper">
                <input class="ag-cell-edit-input" type="text" (input)="onQuickFilterChange($event)"/>
                <mdc-icon>search</mdc-icon>
            </div>
        </div>
    </div>
    <div class="header-second-row" *ngIf="!lovMode">
        <div class="mant-actions">
            <div class="mant-actions-main">
                <a mdc-button dense secondary (click)="onButtonCreateClick()">
                    <mdc-icon>add</mdc-icon>
                    {{'component.datagrid.header.button.crear'|translate}}
                </a>&nbsp;
                <!--a mdc-button dense (click)="onButtonImportClick()">
                    <mdc-icon>get_app</mdc-icon>
                    {{'component.datagrid.header.button.importar'|translate}}
                </a-->
            </div>
            <div class="mant-actions-selection" *ngIf="anyRowSelected">
                <!--a mdc-button dense>
                    <span mdcButtonLabel>Print</span>
                    <mdc-icon>arrow_drop_down</mdc-icon>
                </a-->
                <div mdcMenuSurfaceAnchor #actionsButton>
                    <button mdc-button dense (click)="actionsMenu.open = !actionsMenu.open">
                        <mdc-icon>settings</mdc-icon>
                        <span mdcButtonLabel>{{'component.datagrid.header.button.actions'|translate}}</span>
                        <mdc-icon>arrow_drop_down</mdc-icon>
                    </button>
                    <mdc-menu #actionsMenu anchorCorner="bottomStart" quickOpen [anchorElement]="actionsButton" (selected)="onActionSelect($event)">
                        <mdc-list>
                            <mdc-list-item>{{'component.datagrid.header.action.delete'|translate}}</mdc-list-item>
                        </mdc-list>
                    </mdc-menu>
                </div>
            </div>
        </div>
        <div class="mant-controls mant-controls-pagination" *ngIf="paginationActive">
            <span class="mant-page-info">{{paginationFirstRow}} - {{paginationLastRow}} / {{scrollRowCount}}</span>
            &nbsp;
            <button mdc-icon-button (click)="onPageFirstClick()" [disabled]="paginationFirstPage" class="header-button-small"><mdc-icon>first_page</mdc-icon></button>
            <button mdc-icon-button (click)="onPageDownClick()" [disabled]="paginationFirstPage" class="header-button-small"><mdc-icon>chevron_left</mdc-icon></button>
            &nbsp;{{paginationCurrentPage}}&nbsp;
            <button mdc-icon-button (click)="onPageUpClick()" [disabled]="paginationLastPage" class="header-button-small"><mdc-icon>chevron_right</mdc-icon></button>
            <button mdc-icon-button (click)="onPageLastClick()" [disabled]="paginationLastPage" class="header-button-small"><mdc-icon>last_page</mdc-icon></button>
            <!-- &nbsp;
            <button mdc-icon-button disabled class="header-button-small"><mdc-icon>view_list</mdc-icon></button>
            <button mdc-icon-button disabled class="header-button-small"><mdc-icon>view_module</mdc-icon></button-->
        </div>
        <div class="mant-controls mant-controls-infinite-scroll" *ngIf="!paginationActive">
            <span class="mant-page-info">{{scrollFirstRow}} - {{scrollLastRow}} / {{paginationRowCount}}</span>
            <!-- &nbsp;
            <button mdc-icon-button disabled class="header-button-small"><mdc-icon>view_list</mdc-icon></button>
            <button mdc-icon-button disabled class="header-button-small"><mdc-icon>view_module</mdc-icon></button-->
        </div>
    </div>
</div>
`,
    styles: [`
.page-header {
    padding: 9px 24px 7px 24px;
    border-bottom: 1px solid #e2e2e2;
    color: rgba(0, 0, 0, 0.54);
    font-weight: 700;
    font-size: 12px;
}
.header-first-row {
    display: flex;
    padding-top: 8px;
}
.header-first-row .mant-headline {
    flex-basis: 50%;
    color: #999 !important;
}
.header-first-row .mant-headline span.main {
    color: $mdc-theme-secondary;
}
.header-first-row .mant-headline span.current {
    color: $mdc-theme-on-surface;
}
.header-first-row .mant-filter {
    flex-basis: 50%;
}
.header-first-row .mant-filter-lov {
    flex-basis: 100%;
}
.header-first-row .ag-cell-edit-input {
    color: rgba(0, 0, 0, 0.87);
    height: 40px;
    border-width: 0;
    border-bottom: 2px solid #e2e2e2;
    font-size: 12px;
    width: 100%;
    height: 26px;
}
.header-first-row .ag-cell-edit-input:focus {
    border-bottom-color: #3f51b5;
    outline: none;
}
.header-second-row {
    display: flex;
    padding-top: 6px;
}
.header-second-row .mant-actions {
    flex-basis: 50%;
    display: flex;
    justify-content: space-between;
}
.header-second-row .mant-actions-main {
    flex-grow: 1;
    text-align: left;
}
.header-second-row .mant-actions-selection {
    flex-grow: 1;
    text-align: right;
}
.header-second-row .mant-controls {
    flex-basis: 50%;
    text-align: right;
    position: relative;
    top: -5px;
}
.header-second-row .mant-controls-infinite-scroll {
    padding-top: 18px;
}
.header-second-row .mant-page-info {
}
.header-button-small {
    position: relative;
    top: 6px;
}
.header-button-small mdc-icon {
    position: relative;
    left: -2px;
}
`]*/
} )
export class DatagridHeaderComponent implements IHeaderGroupAngularComp {

    @Output() quickFilterChange: EventEmitter<any> = new EventEmitter();

    private params: any;
    private lovMode: boolean = true;
    private selectionSubscription: Subscription;
    private paginationSubscription: Subscription;
    private restapiProfile: RestapiProfile;

    private title: string;
    private quickFilterAvailable: boolean;
    private anyRowSelected: boolean;
    private paginationActive: boolean;
    private paginationFirstRow: number;
    private paginationLastRow: number;
    private paginationRowCount: number;
    private paginationCurrentPage: number;
    private paginationTotalPages: number;
    private paginationFirstPage: boolean;
    private paginationLastPage: boolean;
    private scrollFirstRow: number;
    private scrollLastRow: number;
    private scrollRowCount: number;

    agInit( params ): void {
        this.params = params;
        this.lovMode = params.context.config.lovMode;
        this.restapiProfile = params.context.restapiProfile;
        // Calcula del titol
        this.title = this.restapiProfile.resource.name;
        if ( this.restapiProfile && this.restapiProfile.resource && this.restapiProfile.resource.translateKeyPlural ) {
            let translatedKey = this.translate.instant( this.restapiProfile.resource.translateKeyPlural );
            if ( translatedKey !== this.restapiProfile.resource.translateKeyPlural ) {
                this.title = translatedKey;
            }
        }
        // Consulta si el quickFilter està disponible
        this.quickFilterAvailable = this.restapiProfile.resource.quickFilterAvailable
        // Actualitza la selecció actual
        this.anyRowSelected = params.api.getSelectedRows().length > 0;
        this.selectionSubscription = params.context.gridComponent.selectionSubject.subscribe( event => {
            this.anyRowSelected = event.api.getSelectedRows().length > 0;
        } );
        // Actualitza la informacio de paginació
        this.paginationActive = params.context.gridComponent.gridOptions.pagination;
        this.paginationSubscription = params.context.gridComponent.paginationSubject.subscribe( event => {
            this.paginationActive = params.context.gridComponent.gridOptions.pagination;
            let currentPage = event.api.paginationGetCurrentPage();
            let pageSize = event.api.paginationGetPageSize();
            this.paginationFirstRow = currentPage * pageSize + 1;
            this.paginationLastRow = this.paginationFirstRow + pageSize - 1;
            this.paginationRowCount = event.api.paginationGetRowCount();
            if ( this.paginationLastRow > this.paginationRowCount ) {
                this.paginationLastRow = this.paginationRowCount;
            }
            this.paginationCurrentPage = currentPage + 1;
            this.paginationTotalPages = event.api.paginationGetTotalPages();
            this.paginationFirstPage = currentPage === 0;
            this.paginationLastPage = currentPage + 1 === this.paginationTotalPages;
            this.calculateScrollFirstAndLastRow();
        } );
        this.paginationSubscription = params.context.gridComponent.scrollSubject.subscribe( event => {
            this.calculateScrollFirstAndLastRow();
        } );
    }

    onQuickFilterChange( event ) {
        this.quickFilterChange.emit( event.target.value );
    }
    onButtonCreateClick() {
        this.params.api['gridOptionsWrapper'].gridOptions.context.gridComponent.headerActionCreate.emit( {} );
    }
    onButtonImportClick() {
        console.log( '>>> onButtonImportClick' )
    }
    onButtonDeleteClick() {
        this.params.api['gridOptionsWrapper'].gridOptions.context.gridComponent.headerActionDelete.emit( {
            resource: this.restapiProfile.resource,
            selectedRows: this.params.api.getSelectedRows()
        } );
    }
    onActionSelect( event ) {
        if ( event.index == 0 ) {
            this.params.api['gridOptionsWrapper'].gridOptions.context.gridComponent.headerActionDelete.emit( {
                resource: this.restapiProfile.resource,
                selectedRows: this.params.api.getSelectedRows()
            } );
        }
    }
    onPageFirstClick() {
        this.params.api.paginationGoToFirstPage();
    }
    onPageDownClick() {
        this.params.api.paginationGoToPreviousPage();
    }
    onPageUpClick() {
        this.params.api.paginationGoToNextPage();
    }
    onPageLastClick() {
        this.params.api.paginationGoToLastPage();
    }

    private calculateScrollFirstAndLastRow() {
        this.scrollRowCount = this.params.api.paginationGetRowCount();
        let rowHeight = this.params.api['gridOptionsWrapper'].gridOptions.context.gridComponent.rowHeight;
        let verticalPixelRangeTop = this.params.api.getVerticalPixelRange().top;
        let verticalPixelRangeBottom = this.params.api.getVerticalPixelRange().bottom;
        this.scrollFirstRow = Math.trunc( verticalPixelRangeTop / rowHeight ) + 1;
        this.scrollLastRow = Math.trunc( verticalPixelRangeBottom / rowHeight ) + 1;
        if ( this.scrollLastRow > this.scrollRowCount ) {
            this.scrollLastRow = this.scrollRowCount;
        }
    }

    constructor(
        private translate: TranslateService ) { }

}