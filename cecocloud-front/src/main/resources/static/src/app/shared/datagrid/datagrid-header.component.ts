import { Component, ViewChild, ElementRef, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { IHeaderGroupAngularComp } from 'ag-grid-angular';
import { TranslateService } from '@ngx-translate/core';
import { Subscription } from 'rxjs';

import { RestapiProfile, RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';
import { DatagridConfig } from './datagrid.component';
import { ScreenSizeService, ScreenSizeChangeEvent } from '../../shared/screen-size.service';

@Component( {
    selector: 'datagrid-header',
    template: `
<div #headerdiv class="datagrid-header" [ngClass]="{'datagrid-header-lov': lovMode, 'datagrid-header-mobile': mobileScreen, 'datagrid-header-desktop': !mobileScreen}">
    <mdc-top-app-bar-row *ngIf="!fullWidthFilter">
        <mdc-top-app-bar-section align="start" [title]="title">
            <button *ngIf="mobileScreen" mdcTopAppBarNavIcon (click)="onButtonBackClick()">
                <mdc-icon>arrow_back</mdc-icon>
            </button>
        </mdc-top-app-bar-section>
        <mdc-top-app-bar-section align="end">
            <button mdc-icon-button class="mdc-icon-button-sm" title="{{'component.datagrid.header.button.refrescar'|translate}}" (click)="onButtonRefreshClick()">
                <mdc-icon>refresh</mdc-icon>
            </button>
            <button mdc-icon-button *ngIf="restapiProfile?.resource.hasCreatePermission" class="mdc-icon-button-sm" title="{{'component.datagrid.header.button.crear'|translate}}" (click)="onButtonCreateClick()">
                <mdc-icon>add</mdc-icon>
            </button>
            <!--button mdc-icon-button class="mdc-icon-button-sm" title="{{'component.datagrid.header.button.importar'|translate}}" (click)="onButtonImportClick()">
                <mdc-icon>get_app</mdc-icon>
            </button-->
            <button mdc-icon-button *ngIf="restapiProfile?.resource.hasDeletePermission" class="mdc-icon-button-sm" [disabled]="!anyRowSelected" title="{{'component.datagrid.header.action.delete'|translate}}" (click)="onButtonDeleteClick()">
                <mdc-icon>delete</mdc-icon>
            </button>
            <!--button mdc-icon-button class="mdc-icon-button-sm">
                <mdc-icon>build</mdc-icon>
            </button-->
            <button mdc-icon-button *ngIf="quickFilterAvailable && mobileScreen" class="mdc-icon-button-sm" (click)="onFilterIconClick()">
                <mdc-icon>search</mdc-icon>
            </button>
            <mat-form-field *ngIf="quickFilterAvailable && !mobileScreen" appearance="outline" style="font-size: 13px; margin-left: 1em; width: 50%; position: relative; top: 6px">
                <input matInput type="text" [ngModel]="quickFilterValue" (ngModelChange)="quickFilterValue = $event" (input)="onQuickFilterChange($event)" (keypress)="onQuickFilterKeypress($event)" />
                <mat-icon matSuffix style="position: relative; top: 4px">search</mat-icon>
            </mat-form-field>
        </mdc-top-app-bar-section>
    </mdc-top-app-bar-row>
    <mdc-top-app-bar-row *ngIf="fullWidthFilter" style="border-top: 1px solid #e2e2e2">
        <mdc-top-app-bar-section>
            <mat-form-field #fullWidthFilterField appearance="outline" style="font-size: 13px; width: 100%; position: relative; top: 6px">
                <input #fullWidthFilterInput matInput type="text" [ngModel]="quickFilterValue" (input)="onQuickFilterChange($event)" (ngModelChange)="quickFilterValue = $event" (blur)="onFilterInputBlur()" (keypress)="onQuickFilterKeypress($event)"/>
                <mat-icon matSuffix style="position: relative; top: 4px">search</mat-icon>
            </mat-form-field>
        </mdc-top-app-bar-section>
    </mdc-top-app-bar-row>
    <!--mdc-top-app-bar-row>
        <mdc-top-app-bar-section align="start">
            <ng-container *ngIf="paginationEnabled">
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
    border-bottom: 1px solid #e2e2e2;
}
.datagrid-header-desktop {
    background-color: #f2f2f2;
    color: rgba(0, 0, 0, 0.54);
}
.datagrid-header-mobile {
    background-color: var(--mdc-theme-primary, #6200ee);
    color: white;
}
.datagrid-header-lov {
    background-color: white;
}
`]
} )
export class DatagridHeaderComponent implements IHeaderGroupAngularComp {

    @Output() quickFilterChange: EventEmitter<any> = new EventEmitter();

    @ViewChild( 'fullWidthFilterInput', { static: false } ) set setFullWidthFilterInput( fullWidthFilterInput: ElementRef ) {
        this.fullWidthFilterInput = fullWidthFilterInput;
        if ( fullWidthFilterInput ) {
            setTimeout(() => {
                fullWidthFilterInput.nativeElement.focus();
            } );
        }
    }

    params: any;
    lovMode: boolean;
    selectionSubscription: Subscription;
    paginationSubscription: Subscription;
    restapiProfile: RestapiProfile;

    title: string;
    quickFilterAvailable: boolean;
    anyRowSelected: boolean;
    paginationEnabled: boolean;
    paginationFirstRow: number;
    paginationLastRow: number;
    paginationRowCount: number;
    paginationCurrentPage: number;
    paginationTotalPages: number;
    paginationFirstPage: boolean;
    paginationLastPage: boolean;
    scrollFirstRow: number;
    scrollLastRow: number;
    scrollRowCount: number;
    mobileScreen: boolean;
    fullWidthFilter: boolean;
    fullWidthFilterInput: ElementRef;
    quickFilterValue: string;

    agInit( params ): void {
        this.params = params;
        this.lovMode = params.context.config.lovMode;
        this.fullWidthFilter = params.context.config.lovMode;
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
        this.paginationEnabled = params.context.gridComponent.gridOptions.paginationEnabled;
        this.paginationSubscription = params.context.gridComponent.paginationSubject.subscribe( event => {
            this.paginationEnabled = params.context.gridComponent.gridOptions.paginationEnabled;
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

    onButtonBackClick() {
        this.router.navigate( ['/'] );
    }
    onButtonRefreshClick() {
        this.params.api['gridOptionsWrapper'].gridOptions.context.gridComponent.refreshInternal();
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

    onQuickFilterKeypress( event ) {
        let keyboardEvent = <KeyboardEvent>event;
        let filteredKeys = ['(', ')', ';', ',', '"', '\'', '=', '~', '<', '>'];
        if ( filteredKeys.indexOf( keyboardEvent.key ) != -1 ) {
            event.preventDefault();
        }
    }
    onQuickFilterChange( event ) {
        this.quickFilterChange.emit( event.target.value );
    }
    onFilterIconClick() {
        this.fullWidthFilter = true;
    }
    onFilterInputBlur() {
        if ( !this.lovMode ) {
            this.fullWidthFilter = false;
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

    calculateScrollFirstAndLastRow() {
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
        private router: Router,
        private translate: TranslateService,
        private screenSizeService: ScreenSizeService ) {
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}