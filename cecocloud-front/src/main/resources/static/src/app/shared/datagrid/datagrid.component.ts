import { Component, Input, Output, OnInit, ViewChild, ElementRef, EventEmitter, HostListener, Injector } from '@angular/core';
import { DomSanitizer, SafeStyle } from '@angular/platform-browser';
import { FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { HttpParams } from '@angular/common/http';
import { GridApi, GridOptions, ColGroupDef, RowNode, ValueGetterParams, ValueFormatterParams, ValueParserParams, ValueSetterParams, IGetRowsParams } from 'ag-grid-community/main';
import { Resource, HalParam } from 'angular4-hal';
import { Observable, Subject } from 'rxjs';

import { RestapiService } from '../restapi/restapi.service';
import { RestapiProfile, RestapiResource, RestapiResourceField } from '../restapi/restapi-profile';
import { ScreenSizeService, ScreenSizeChangeEvent } from '../../shared/screen-size.service';
import { DatagridHeaderComponent } from './datagrid-header.component';
import { DatagridLinkCellRenderer } from './datagrid-link-cell-renderer.component';
import { DatagridRestapiEditorComponent } from './datagrid-restapi-editor.component';
import { DatagridRestapiFilterComponent } from './datagrid-restapi-filter.component';
import { DatagridRestapiFloatingFilterComponent } from './datagrid-restapi-floating-filter.component';

export interface DatagridConfig {
    mode?: string;
    parent?: any;
    columns?: DatagridColumn[];
    height?: number;
    adjustHeight?: boolean;
    editable?: boolean;
    staticData?: boolean;
    lovMode?: boolean;
    detailConfig?: DatagridConfig;
    dataAttribute?: string;
    restapiService?: RestapiService<Resource>;
    rowStyle?: any;
    rowClass?: any;
    resizable?: boolean;
    additionalFilter?: any;
    columnFiltersEnabled?: boolean;
    paginationEnabled?: boolean;
}
export interface DatagridColumn {
    field?: string;
    width?: number;
    editable?: any;
    sortable?: boolean;
    sort?: string;
    fieldType?: string;
    tooltip?: Function;
    tooltipField?: string;
    cellClass?: any;
    cellRenderer?: any;
    filterable?: boolean;
    suppressFilterButton?: boolean;
}

@Component( {
    selector: 'datagrid',
    template: `
<div #datagridfull style="position:relative">
	<mat-spinner
		#spinner
		*ngIf="showLoading"
		[diameter]="spinnerDiameter"
		style="position:absolute;top:50%;left:50%;transform:translate(-50%, -50%);z-index:1"></mat-spinner>
	<div #norows *ngIf="!showLoading && showNoRows && !formMode" style="position:absolute;top:50%;left:50%;transform:translate(-50%, -50%);text-align:center;z-index:1">
		<div><mdc-icon style="font-size:100px; color: rgba(0, 0, 0, 0.18)">block</mdc-icon></div>
		<div style="color: rgba(0, 0, 0, 0.18)">{{'component.datagrid.no.rows'|translate}}</div>
	</div>
	<datagrid-header #header (quickFilterChange)="onQuickFilterChange($event)"></datagrid-header>
	<ag-grid-angular
		*ngIf="gridOptions"
		[ngClass]="theme"
		[style.height]="styleHeight"
		[gridOptions]="gridOptions"></ag-grid-angular>
	<div *ngIf="config.mode === 'form'">
		<button mat-button (click)="onAddButtonClick()">
			<mat-icon>add</mat-icon>
			Nova fila
		</button>
	</div>
</div>
`
} )
export class DatagridComponent implements OnInit {

    @Input() config: DatagridConfig;
    @Input() restapiService: RestapiService<Resource>;
    @Input() data: any[];

    @Output() headerActionCreate: EventEmitter<any> = new EventEmitter();
    @Output() headerActionDelete: EventEmitter<any> = new EventEmitter();
    @Output() selectionChanged: EventEmitter<any> = new EventEmitter();
    @Output() rowClicked: EventEmitter<any> = new EventEmitter();
    @Output() rowDoubleClicked: EventEmitter<any> = new EventEmitter();

    @ViewChild( 'header', { static: false } ) headerComponent: DatagridHeaderComponent;
    @ViewChild( 'header', { read: ElementRef, static: false } ) headerElementRef: ElementRef;
    @ViewChild( 'datagridfull', { read: ElementRef, static: false } ) datagridfullElementRef: ElementRef;

    // Subjects per a la comunicació entre components
    selectionSubject = new Subject<any>();
    paginationSubject = new Subject<any>();
    scrollSubject = new Subject<any>();

    // Aparença
    toolbarShown: boolean = false;
    theme: string = 'ag-theme-material'; // 'ag-theme-balham' o 'ag-theme-material'
    appHeaderHeight: number = 64;
    componentHeaderHeight: number = 65;
    lovFixedHeight: number = 220;
    headerHeight: number = 46;
    rowHeight: number = 36; // balham = 32;
    styleHeight: SafeStyle;
    marginBottom: number = 0;
    styleMarginBottom: string = this.marginBottom + 'px';
    rowDetailPadding: number = 20;
    spinnerDiameter: number = 50;

    // Altres
    gridOptions: GridOptions;
    hasMantenimentDirective: boolean;
    showLoading: boolean;
    showNoRows: boolean;
    quickFilterValue: string;
    mobileScreen: boolean;
	formMode: boolean;

    ngOnInit() {
        this.createGridOptions( this.config ).subscribe(( gridOptions: GridOptions ) => {
            this.gridOptions = gridOptions;
        } );
		this.formMode = this.config.mode && this.config.mode.toLowerCase() === 'form';
    }

    public refresh( additionalFilter?: any ) {
        if ( additionalFilter ) {
            this.config.additionalFilter = additionalFilter;
        }
        this.refreshInternal();
    }
    public refreshInternal( api?: GridApi ) {
        let refreshApi = ( api ) ? api : this.gridOptions.api;
        if ( refreshApi ) {
            let refreshContext = refreshApi['gridOptionsWrapper'].gridOptions.context;
            let refreshConfig = refreshContext.config;
            let parentPk = refreshContext.gridComponent.getParentPk( refreshApi );
            refreshContext.gridComponent.configPagination( refreshConfig, refreshContext.gridComponent.gridOptions );
            if ( refreshConfig.detailConfig && refreshContext.isRoot ) {
                refreshContext.gridComponent.refreshDetailRowData( refreshContext.restapiService, parentPk ).subscribe( resources => {
                    refreshApi.setRowData( resources );
                } );
            } else {
                refreshContext.datasourceParentPk = parentPk;
                refreshContext.gridComponent.showLoadingOverlay();
                refreshApi.setDatasource( refreshContext.gridComponent.createDataSource( refreshContext.restapiService ) );
            }
        }
    }

    public refreshRow( api: GridApi, rowNode: RowNode, data: any ) {
        let context = api['gridOptionsWrapper'].gridOptions.context;
        rowNode.setData( data );
        api.flashCells( { rowNodes: [rowNode] } );
        api.redrawRows( {
            rowNodes: [rowNode]
        } );
        //context.gridComponent.messageService.sendRowEditError( { api: api } );
        context.gridComponent.refreshParentRow( api );
    }

    public mantenimentConfig() {
        this.hasMantenimentDirective = true;
    }

    onQuickFilterChange( value ) {
        this.quickFilterValue = value;
        this.refreshInternal();
    }

	/*onNewElementClicked( api: GridApi, context: any ) {
        if ( context.config.onDatagridActionCreate ) {
            context.config.onDatagridActionCreate( context );
        }
        if ( !context.config.readOnly ) {
            if ( context.config.editable ) {
                let editActive = context.gridComponent.getFromApiContext( api, 'editActive' );
                if ( !editActive ) {
                    context.gridComponent.setInApiContext( api, 'editIsCreate', true );
                    let parentPk = context.gridComponent.getParentPk( api );
                    let getParams = context.restapiService.generateGetParamsWithParent( 'new', parentPk );
                    context.restapiService.get( getParams ).subscribe(( resource: Resource ) => {
                        api.updateRowData( {
                            addIndex: 0,
                            add: [resource]
                        } );
                        context.gridComponent.startEditing( api, context, 0 );
                        context.gridComponent.refreshDetailRowsHeight( api );
                    } );
                }
            } else {
                let outputParams: DatagridEventParams = {
                    resourceName: context.resourceName,
                    parentPk: this.config.parent
                }
                this.actionCreate.emit( outputParams );
            }
        }
    }*/

	onSelectionChanged( event ) {
        event.context.gridComponent.selectionChanged.emit( event );
        event.context.gridComponent.selectionSubject.next( event );
    }

    onRowClicked( event ) {
		if ( event.context.config.editable ) {
			let editActive = event.context.gridComponent.getFromApiContext( event.api, 'editActive' );
            if ( !editActive ) {
                if ( !event.context.gridComponent.gridOptions.suppressClickEdit ) {
                    event.context.gridComponent.setInApiContext( event.api, 'editIsUpdate', true );
                    event.context.gridComponent.startEditing( event.api, event.context, event.rowIndex );
                }
            }
		}
        event.context.gridComponent.rowClicked.emit( event );
    }

    onRowDoubleClicked( event ) {
        event.context.gridComponent.rowDoubleClicked.emit( event );
    }

	onAddButtonClick() {
        if ( this.config.editable ) {
			let api = this.gridOptions.api;
            let editActive = this.getFromApiContext( api, 'editActive' );
            if ( !editActive ) {
                this.setInApiContext( api, 'editIsCreate', true );
                /*let getParams = context.restapiService.generateGetParamsWithParent( 'new', parentPk );
                context.restapiService.get( getParams ).subscribe(( resource: Resource ) => {
                    api.updateRowData( {
                        addIndex: 0,
                        add: [resource]
                    } );
                    context.gridComponent.startEditing( api, context, 0 );
                    context.gridComponent.refreshDetailRowsHeight( api );
                } );*/
				this.startEditing( api, undefined, 0 );
                this.refreshDetailRowsHeight( api );
            }
        }
	}

    onPaginationChanged( event ) {
        event.api['gridOptionsWrapper'].gridOptions.context.gridComponent.paginationSubject.next( event );
    }

    onBodyScroll( event ) {
        event.api['gridOptionsWrapper'].gridOptions.context.gridComponent.scrollSubject.next( event );
    }

    onRowEditingStarted( event ) {
        event.context.gridComponent.setInApiContext( event.api, 'editDataHasChanged', false );
        event.context.gridComponent.setInApiContext( event.api, 'editActive', true );
        /*event.context.gridComponent.messageService.sendRowEdit( {
            api: event.api,
            row: event.node,
            editing: true
        } );*/
    }
    onRowValueChanged( event ) {
        let editDataHasChanged = event.context.gridComponent.getFromApiContext( event.api, 'editDataHasChanged' );
        if ( editDataHasChanged ) {
            let editIsCreate = event.context.gridComponent.getFromApiContext( event.api, 'editIsCreate' );
            let editInitialRowDataSaved = event.context.gridComponent.getFromApiContext( event.api, 'editInitialRowData' );
            let editRowIndexSaved = event.context.gridComponent.getFromApiContext( event.api, 'editRowIndex' );
            let errorFunction = function( error ) {
                event.context.gridComponent.setInApiContext( event.api, 'editInitialRowData', editInitialRowDataSaved );
                event.context.gridComponent.setInApiContext( event.api, 'editRowIndex', editRowIndexSaved );
                event.context.gridComponent.setInApiContext( event.api, 'editError', error );
                if ( editIsCreate ) {
                    event.context.gridComponent.setInApiContext( event.api, 'editIsCreate', true );
                } else {
                    event.context.gridComponent.setInApiContext( event.api, 'editIsUpdate', true );
                }
                event.context.gridComponent.startEditing( event.api, event.context, event.node.rowIndex );
                let rowDataForUpdate = Object.assign( {}, event.context.gridComponent.getFromApiContext( event.api, 'editInitialRowData' ) );
                event.node.setData( rowDataForUpdate );
                console.log( '>>> Error', error );
                /*event.context.gridComponent.messageService.sendRowEditError( {
                    api: event.api,
                    error: error.error
                } );*/
            }
            if ( editIsCreate ) {
                let createUrl = event.context.restapiService.getApiUrl( true );
                let postParams = new HttpParams( /*{ fromObject: parentPk }*/ );
                event.context.restapiService.getHttpClient().post( createUrl, event.data, { params: postParams } ).subscribe(( resource: Resource ) => {
                    /*event.context.gridComponent.messageService.sendRowEditError( { api: event.api } );*/
                    event.context.gridComponent.refreshParentRow( event.api );
                    event.context.gridComponent.refreshInternal( event.api );
                }, error => errorFunction( error ) );
            } else {
                event.context.gridComponent.removeFromApiContext( event.api, 'editRowIndex' );
                event.context.gridComponent.getResourceDataWithLinks( event.data, event.api, event.context ).subscribe( dataWithLinks => {
                    event.context.restapiService.update( dataWithLinks ).subscribe(( resource: Resource ) => {
                        event.node.setData( resource );
                        event.api.flashCells( { rowNodes: [event.node] } );
                        event.api.redrawRows( {
                            rowNodes: [event.node]
                        } );
                        /*event.context.gridComponent.messageService.sendRowEditError( { api: event.api } );*/
                        event.context.gridComponent.refreshParentRow( event.api );
                    }, error => errorFunction( error ) );
                } );
            }
        }
    }
    onRowEditingStopped( event ) {
        let editIsCreate = event.context.gridComponent.getFromApiContext( event.api, 'editIsCreate' );
        let editDataHasChanged = event.context.gridComponent.getFromApiContext( event.api, 'editDataHasChanged' );
        if ( editIsCreate && !editDataHasChanged ) {
            event.context.gridComponent.removeFromApiContext( event.api, 'editIsCreate' );
            let parentGridApi = event.context.gridComponent.getFromApiContext(
                event.api,
                'parentGridApi' );
            if ( event.context.config.detailConfig || parentGridApi ) {
                let firstRow = event.api.getDisplayedRowAtIndex( 0 );
                event.api.updateRowData( {
                    remove: [firstRow.data]
                } );
                event.context.gridComponent.refreshDetailRowsHeight( event.api );
            } else {
                event.context.gridComponent.refreshInternal( event.api );
            }
        }
        event.context.gridComponent.removeFromApiContext( event.api, 'editInitialRowData' );
        event.context.gridComponent.removeFromApiContext( event.api, 'editRowIndex' );
        event.context.gridComponent.removeFromApiContext( event.api, 'editActive' );
        event.context.gridComponent.removeFromApiContext( event.api, 'editIsCreate' );
        event.context.gridComponent.removeFromApiContext( event.api, 'editIsUpdate' );
        /*event.context.gridComponent.messageService.sendRowEditError( { api: event.api } );
        event.context.gridComponent.messageService.sendRowEdit( {
            api: event.api,
            row: event.node,
            editing: false
        } );*/
    }

    createGridOptions(
        gridConfig: DatagridConfig,
        parentGridOptions?: GridOptions ): Observable<GridOptions> {
        let gridOptions: GridOptions = {
            suppressCellSelection: true,
            suppressContextMenu: true,
            stopEditingWhenGridLosesFocus: false,
            enableBrowserTooltips: true,
            floatingFilter: !this.mobileScreen && gridConfig.columnFiltersEnabled,
            overlayNoRowsTemplate: 'No hi ha res...' //'<span style="padding: 10px; border: 2px solid #444; background: #efefef;">' + this.translate.instant( 'datatable.sense.resultats' ) + '</span>',
        }
        gridOptions.getRowStyle = gridConfig.rowStyle;
        gridOptions.getRowClass = gridConfig.rowClass;
        gridOptions.enableColResize = gridConfig.resizable;
		let lovMode = gridConfig.mode && gridConfig.mode.toLowerCase() === 'lov';
		let formMode = gridConfig.mode && gridConfig.mode.toLowerCase() === 'form';
		if ( !formMode ) {
        	gridOptions.rowSelection = 'single'; // 'single' o 'multiple';
		}
        gridOptions.rowDeselection = lovMode;
	    gridOptions.suppressRowClickSelection = formMode ? true : !lovMode;
        gridOptions.editType = 'fullRow';
        gridOptions.rowHeight = this.rowHeight;
        gridOptions.headerHeight = this.headerHeight;
        gridOptions.onGridReady = function( event ) {
            let context = event.api['gridOptionsWrapper'].gridOptions.context;
            context.gridComponent.showLoadingOverlay();
            context.gridComponent.headerComponent.agInit( {
                api: event.api,
                context: context
            } );
            /* Recalcula l'alçada de la capçalera amb els floatig filters */
            /* Només pel tema material design */
            let headerContainerElement: HTMLElement = event.api['gridPanel'].headerRootComp.eHeaderContainer;
            if ( headerContainerElement.children.length == 2 ) {
                let headerElement: HTMLElement = event.api['gridPanel'].headerRootComp.eGui;
                headerElement.style.height = this.headerHeight * 2 + 'px';
                headerElement.style.minHeight = this.headerHeight * 2 + 'px';
                ( headerContainerElement.lastChild as HTMLElement ).style.height = this.headerHeight + 'px';
            }
            /* */
            event.api.hidePopupMenu();
            event.api.sizeColumnsToFit();
        }
        gridOptions.onModelUpdated = function( event ) {
            let context = event.api['gridOptionsWrapper'].gridOptions.context;
            if ( context.datasourceParentPk ) {
                delete context.datasourceParentPk;
            }
            event.api.sizeColumnsToFit();
            context.gridComponent.hideLoadingOverlay();
            if ( event.api.paginationGetRowCount() ) {
                context.gridComponent.showNoRows = false;
            } else {
                context.gridComponent.showNoRows = true;
            }
        }
        gridOptions.onFirstDataRendered = function( event ) {
            let context = event.api['gridOptionsWrapper'].gridOptions.context;
            let parentGridApi = context.gridComponent.getFromApiContext( event.api, 'parentGridApi' );
            if ( parentGridApi ) {
                let refreshDetailHeights = context.gridComponent.getFromApiContext( parentGridApi, 'refreshDetailHeights' );
                if ( refreshDetailHeights ) {
                    context.gridComponent.refreshDetailRowsHeight( parentGridApi );
                    context.gridComponent.removeFromApiContext( parentGridApi, 'refreshDetailHeights' );
                }
            }
        }
        gridOptions.onRowDataChanged = function( event ) {
            let context = event.api['gridOptionsWrapper'].gridOptions.context;
            context.gridComponent.hideLoadingOverlay();
        }
        gridOptions.onGridSizeChanged = function( event ) {
            event.api.sizeColumnsToFit();
        }
        gridOptions.onSortChanged = function( event ) {
            let context = event.api['gridOptionsWrapper'].gridOptions.context;
            context.gridComponent.showLoadingOverlay();
        }
        gridOptions.onFilterChanged = function( event ) {
            let context = event.api['gridOptionsWrapper'].gridOptions.context;
            context.gridComponent.showLoadingOverlay();
        }
        gridOptions.getRowHeight = function( params ) {
            let context = params.api['gridOptionsWrapper'].gridOptions.context;
            let rowHeight = 28;
            let resourceName = params.context.config.resourceName;
            // let id = params.data.codi;
            if ( params.node.detail ) {
                let minHeight = 157;
                let detailDataAttribute = params.context.detailDataAttribute;
                let details = ( params.data ) ? params.data[detailDataAttribute] : null;
                let headerHeight = this.matenimentHeaderHeight;
                let rowHeight = 28;
                let numRows = ( details ) ? details.length : 0;
                let padding = params.context.gridComponent.rowDetailPadding;
                let detailRowHeight = headerHeight + rowHeight * numRows + padding * 2;
                return ( detailRowHeight > minHeight ) ? detailRowHeight : minHeight;
            } else {
                return rowHeight;
            }
        }
        let restapiService = ( gridConfig.restapiService ) ? gridConfig.restapiService : this.restapiService;
        gridOptions.context = {
            gridComponent: this,
            config: gridConfig,
            restapiService: restapiService,
            isRoot: !parentGridOptions
        }
        if ( parentGridOptions ) {
            parentGridOptions.context.detailRestapiService = restapiService;
        }
        gridOptions.onRowEditingStarted = this.onRowEditingStarted;
        gridOptions.onRowEditingStopped = this.onRowEditingStopped;
        gridOptions.onRowValueChanged = this.onRowValueChanged;
        gridOptions.onRowSelected = this.onSelectionChanged;
        gridOptions.onPaginationChanged = this.onPaginationChanged;
        gridOptions.onBodyScroll = this.onBodyScroll;
        gridOptions.onRowClicked = this.onRowClicked;
        gridOptions.onRowDoubleClicked = this.onRowDoubleClicked;
        if ( !parentGridOptions && !gridConfig.detailConfig ) {
            if ( gridConfig.adjustHeight === undefined || gridConfig.adjustHeight ) {
				let lovMode = gridConfig.mode && gridConfig.mode.toLowerCase() === 'lov';
                let fixedHeight;
                if ( lovMode ) {
                    fixedHeight = this.lovFixedHeight;
                } else {
                    fixedHeight = ( this.mobileScreen ) ? this.componentHeaderHeight : this.appHeaderHeight + this.componentHeaderHeight;
                }
                fixedHeight += this.marginBottom;
                this.styleHeight = this.sanitizer.bypassSecurityTrustStyle( 'calc(100vh - ' + fixedHeight + 'px)' );
            } else if ( gridConfig.height ) {
                this.styleHeight = gridConfig.height + 'px';
            } else {
                // Sense restriccio d'alçada
                gridOptions.domLayout = 'autoHeight';
                //api.setDomLayout()
                //this.styleHeight = 200 + 'px';
            }
        }
        if ( gridConfig.detailConfig ) {
            gridOptions.masterDetail = true;
            gridOptions.context.detailDataAttribute = gridConfig.detailConfig.dataAttribute;
            gridOptions.onRowGroupOpened = function( event ) {
                let resourceName = event.context.config.resourceName;
                let isCloseEvent = true;
                let detailRowId;
                event.api.forEachDetailGridInfo( detailGridInfo => {
                    let rowId = detailGridInfo.id.split( '_' )[1];
                    let detailRowNode = event.api.getRowNode( rowId );
                    if ( detailRowNode.rowIndex === event.node.rowIndex ) {
                        isCloseEvent = false;
                        detailRowId = detailGridInfo.id;
                        event.context.gridComponent.setInApiContext(
                            detailGridInfo.api,
                            'detailRowId',
                            detailRowId );
                        event.context.gridComponent.setInApiContext(
                            detailGridInfo.api,
                            'parentPk',
                            event.data.pk );
                        event.context.gridComponent.setInApiContext(
                            detailGridInfo.api,
                            'parentRowId',
                            event.node.id );
                        event.context.datasourceParentPk = event.data.pk;
                    }
                    event.context.gridComponent.setInApiContext(
                        detailGridInfo.api,
                        'parentGridApi',
                        event.api );
                } );
                if ( !isCloseEvent ) {
                    // Refresca alçada detall obert
                    if ( event.context.config.staticData ) {
                        event.context.gridComponent.refreshDetailRowsHeight( event.api );
                    } else {
                        event.context.gridComponent.setInApiContext( event.api, 'refreshDetailHeights', true );
                    }
                } else {
                    // Refresca alçades del grid pare nomes quan es tanca el detall
                    let parentGridApi = event.context.gridComponent.getFromApiContext(
                        event.api,
                        'parentGridApi' );
                    if ( parentGridApi ) {
                        event.context.gridComponent.refreshDetailRowsHeight( parentGridApi );
                    }
                }
            }
            gridOptions.isRowMaster = function( data ) {
                if ( gridConfig.detailConfig.staticData ) {
                    let dataAttribute = gridConfig.detailConfig.dataAttribute;
                    return ( data && data[dataAttribute] && data[dataAttribute].length > 0 );
                } else {
                    return true;
                }
            };
            this.createGridOptions( gridConfig.detailConfig, gridOptions ).subscribe(( detailGridOptions: GridOptions ) => {
                // 75,139,194
                gridOptions.detailCellRendererParams = {
                    detailGridOptions: detailGridOptions,
                    getDetailRowData: function( params ): any {
                        if ( gridConfig.detailConfig.staticData ) {
                            params.successCallback( params.data[gridConfig.detailConfig.dataAttribute] );
                        } else {
                            let gridApi = params.node.gridApi;
                            let context = gridApi['gridOptionsWrapper'].gridOptions.context;
                            context.gridComponent.refreshDetailRowData( context.detailRestapiService, params.data.pk ).subscribe( resources => {
                                params.successCallback( resources );
                                if ( resources.length === 0 ) {
                                    let parentGridApi = context.gridComponent.getFromApiContext( gridApi, 'parentGridApi' );
                                    if ( parentGridApi ) {
                                        context.gridComponent.refreshDetailRowsHeight( parentGridApi );
                                    }
                                }
                            } );
                        }
                    }
                };
            } );
        }
        return new Observable(( observer ) => {
            restapiService.whenReady().subscribe(( restapiProfile: RestapiProfile ) => {
                gridOptions.context.restapiProfile = restapiProfile;
                gridOptions.columnDefs = this.createColumnDefs( gridConfig, restapiProfile );
                if ( parentGridOptions || gridConfig.detailConfig ) {
                    gridOptions.domLayout = 'autoHeight';
                    if ( !parentGridOptions ) {
                        this.refreshDetailRowData( restapiService, gridConfig.parent ).subscribe( resources => {
                            if ( gridOptions.api ) {
                                gridOptions.api.setRowData( resources );
                            } else {
                                gridOptions.rowData = resources;
                            }
                        } );
                    }
                } else {
                    gridOptions.rowModelType = 'infinite';
                    this.configPagination( gridConfig, gridOptions );
                    gridOptions.context.datasourceParentPk = gridConfig.parent;
                    gridOptions.datasource = this.createDataSource( restapiService );
                }
                observer.next( gridOptions );
                observer.complete();
            } );
        } );
    }

    createColumnDefs(
        datagridConfig: DatagridConfig,
        restapiProfile: RestapiProfile ): ColGroupDef[] {
        let columnDefs = [];
        let gridColumns = datagridConfig.columns;
		let lovMode = datagridConfig.mode && datagridConfig.mode.toLowerCase() === 'lov';
		let formMode = datagridConfig.mode && datagridConfig.mode.toLowerCase() === 'form';
        if ( !gridColumns && restapiProfile ) {
            gridColumns = [];
            restapiProfile.resource.fields.forEach( field => {
                let hidden = ( lovMode ) ? field.hiddenInLov : field.hiddenInGrid;
                if ( !hidden ) {
                    gridColumns.push( {
                        field: field.name
                    } );
                }
            } );
        }
        if ( gridColumns ) {
            gridColumns.forEach(( gridColumn: DatagridColumn, index: number ) => {
                let restapiField;
                if ( restapiProfile ) {
                    restapiProfile.resource.fields.forEach( field => {
                        if ( gridColumn.field === field.name ) {
                            restapiField = field;
                        }
                    } );
                }
                let isModificable = restapiProfile.resource.hasUpdatePermission || restapiProfile.resource.hasDeletePermission;
                let cellStyle = { lineHeight: this.rowHeight + 'px' };
                let cellRenderer;
                let cellRendererFramework;
                let cellRendererParams;
                let checkboxSelection = ( index == 0 ) && !lovMode && !formMode;
                if ( !isModificable ) {
                    checkboxSelection = false;
                }
                let columnField = gridColumn.field;
                let columnEditable: any;
                let tooltip = ( gridColumn.tooltip ) ? gridColumn.tooltip : undefined;
                let tooltipField: string = ( gridColumn.tooltipField ) ? gridColumn.tooltipField : undefined;
                let sortable: boolean = ( gridColumn.sortable === undefined ) ? true : gridColumn.sortable;
                if ( datagridConfig.editable ) {
                    columnEditable = function( params ) {
                        let editIsCreate = params.context.gridComponent.getFromApiContext( params.api, 'editIsCreate' );
                        let editable = false;
                        if ( editIsCreate ) {
                            editable = !restapiField.disabledForCreate;
                        } else {
                            editable = !restapiField.disabledForUpdate;
                        }
                        if ( editable && gridColumn.hasOwnProperty( 'editable' ) ) {
                            if ( typeof gridColumn.editable === 'function' ) {
                                return gridColumn.editable( params );
                            } else {
                                return gridColumn.editable;
                            }
                        } else {
                            return editable;
                        }
                    };
                } else {
                    cellRendererFramework = DatagridLinkCellRenderer;
                    cellRendererParams = {
                        linkActive: this.hasMantenimentDirective && isModificable
                    };
                }
                let columnFieldType = ( gridColumn.fieldType ) ? ( gridColumn.fieldType ) : restapiField.type;
                let headerName = columnField;
                let cellEditorFramework;
                if ( restapiField ) {
                    cellEditorFramework = DatagridRestapiEditorComponent;
                    if ( columnFieldType === 'BIGDECIMAL' || columnFieldType === 'INTEGER' || columnFieldType === 'FLOAT' ) {
                        cellStyle['textAlign'] = 'right';
                    }
                    let headerTranslated = this.translate.instant( restapiField.translateKey );
                    if ( headerTranslated !== restapiField.translateKey ) {
                        headerName = headerTranslated;
                    }
                }
                if ( index == 0 ) {
                    //checkboxSelection = ( this.config.checkboxSelection != undefined ) ? this.config.checkboxSelection : false;
                    if ( datagridConfig.detailConfig ) {
                        cellRenderer = 'agGroupCellRenderer';
                    }
                }
                let filter;
                let filterParams = {
                    suppressAndOrCondition: false,
                    restapiField: restapiField
                };
                let filterFramework;
                let floatingFilterComponentFramework;
                let floatingFilterComponentParams = {
                    suppressFilterButton: gridColumn.suppressFilterButton,
                    restapiField: restapiField
                };
                if ( datagridConfig.columnFiltersEnabled ) {
                    filter = true;
                    filterFramework = DatagridRestapiFilterComponent;
                    floatingFilterComponentFramework = DatagridRestapiFloatingFilterComponent;
                }
                columnDefs.push( {
                    field: columnField,
                    headerName: headerName,
                    sortable: sortable,
                    sort: gridColumn.sort,
                    editable: columnEditable,
                    cellEditorFramework: cellEditorFramework,
                    valueGetter: this.valueGetter,
                    valueFormatter: this.valueFormatter,
                    valueSetter: this.valueSetter,
                    valueParser: this.valueParser,
                    cellStyle: cellStyle,
                    cellClass: gridColumn.cellClass,
                    cellRenderer: ( cellRenderer !== undefined ) ? cellRenderer : gridColumn.cellRenderer,
                    cellRendererFramework: cellRendererFramework,
                    cellRendererParams: cellRendererParams,
                    //checkboxSelection: ( !lovMode ) ? checkboxSelection : false,
                    checkboxSelection: checkboxSelection,
                    //headerCheckboxSelection: ( !lovMode ) ? checkboxSelection : false,
                    suppressMenu: true,
                    filter: ( filter ) ? filter : false,
                    filterFramework: filterFramework,
                    filterParams: filterParams,
                    floatingFilterComponentFramework: floatingFilterComponentFramework,
                    floatingFilterComponentParams: floatingFilterComponentParams,
                    tooltipField: tooltipField,
                    tooltip: tooltip,
                    width: ( gridColumn.width ) ? gridColumn.width : null
                } );
            } );
        }
        if ( this.toolbarShown ) {
            return <ColGroupDef[]>[{
                headerGroupComponentFramework: DatagridHeaderComponent,
                children: columnDefs
            }];
        } else {
            return columnDefs;
        }
    }

    createDataSource( restapiService: RestapiService<Resource> ) {
        return {
            getRows: ( params: IGetRowsParams ) => {
                this.showLoadingOverlay();
                let requestParams: HalParam[] = [];
                let size;
                if ( params.context.config.paginationEnabled === undefined || params.context.config.paginationEnabled ) {
                    size = params.endRow - params.startRow;
                    let page = params.startRow / size;
                    requestParams.push( {
                        key: 'page',
                        value: '' + page
                    } );
                }
                params.sortModel.forEach( sortModel => {
                    requestParams.push( {
                        key: 'sort',
                        value: sortModel.colId + ',' + sortModel.sort
                    } );
                } );
                let additionalFilter = params.context.config.additionalFilter;
                if ( additionalFilter ) {
                    RestapiService.transformToHalParams( additionalFilter ).forEach( function( halParam: HalParam ) {
                        requestParams.push( halParam );
                    } );
                }
                if ( params.context.gridComponent.quickFilterValue ) {
                    requestParams.push( {
                        key: 'quickFilter',
                        value: params.context.gridComponent.quickFilterValue
                    } );
                }
                if ( params.filterModel && Object.keys( params.filterModel ).length ) {
                    let filterModelToRsqlQuery = function( key, filterModel ) {
                        let operation = filterModel.operation;
                        let type = filterModel.type;
                        let value = filterModel.value;
                        let additionalPath = filterModel.additionalPath;
                        let rsql = key + ( additionalPath ? '.' + additionalPath : '' );
                        switch ( operation ) {
                            case 'EQUAL':
                                rsql += '==' + value;
                                break;
                            case 'NOT_EQUAL':
                                rsql += '!=' + value;
                                break;
                            case 'STARTS_WITH':
                                rsql += '==*' + value;
                                break;
                            case 'ENDS_WITH':
                                rsql += '==' + value + '*';
                                break;
                            case 'CONTAINS':
                                rsql += '==*' + value + '*';
                                break;
                            case 'NOT_CONTAINS':
                                rsql += '!=*' + value + '*';
                                break;
                            case 'GREATER_THAN':
                                rsql += '>' + value;
                                break;
                            case 'LESS_THAN':
                                rsql += '<' + value;
                                break;
                            case 'GREATER_THAN_OR_EQUAL':
                                rsql += '>=' + value;
                                break;
                            case 'LESS_THAN_OR_EQUAL':
                                rsql += '<=' + value;
                                break;
                            case 'IN':
                                rsql += '=in=' + value;
                                break;
                            case 'NOT_IN':
                                rsql += '=out=' + value;
                                break;
                            case 'BETWEEN':
                                rsql = '(' + rsql + '>=' + value + ';' + key + '<=' + filterModel.additionalValue + ')';
                                break;
                        }
                        return rsql;
                    };
                    let rsqlQuery = '';
                    Object.keys( params.filterModel ).forEach(( key ) => {
                        if ( rsqlQuery ) {
                            rsqlQuery += ';';
                        }
                        if ( params.filterModel[key].value ) {
                            rsqlQuery += filterModelToRsqlQuery( key, params.filterModel[key] );
                        }
                    } );
                    if ( rsqlQuery ) {
                        requestParams.push( {
                            key: 'query',
                            value: rsqlQuery
                        } );
                    }
                }
                restapiService.getAll( {
                    size: size,
                    params: requestParams
                } ).subscribe(( resources: any ) => {
                    let totalElements: any = restapiService.resourceArray.totalElements;
                    if (typeof totalElements === "function") {
                        totalElements = totalElements();
                    }
                    params.context.numElements = totalElements;
                    params.successCallback( resources, totalElements );
                }, () => {
                    params.failCallback();
                } );
            }
        }
    }

    configPagination(
        gridConfig: DatagridConfig,
        gridOptions: GridOptions ) {
        let paginationEnabled: boolean;
        if ( gridConfig.paginationEnabled === undefined ) {
			let lovMode = gridConfig.mode && gridConfig.mode.toLowerCase() === 'lov';
            paginationEnabled = !this.mobileScreen && !lovMode;
        } else {
            paginationEnabled = gridConfig.paginationEnabled;
        }
        if ( paginationEnabled ) {
            gridOptions.paginationAutoPageSize = true;
        } else {
            gridOptions.suppressPaginationPanel = true;
        }
        gridOptions.pagination = paginationEnabled;
    }

    valueGetter( params: ValueGetterParams ) {
        return ( params.data ) ? params.data[params.column.getColId()] : undefined;
    }
    valueFormatter( params: ValueFormatterParams ) {
        let field: RestapiResourceField = params.context.gridComponent.getRestapiFieldForColumn(
            params.context.restapiProfile.resource,
            params.column.getColId() );
        if ( field ) {
            if ( field.multiple ) {
                if ( params.value && params.value instanceof Array ) {
                    let descriptionFull = '';
                    let first = true;
                    params.value.forEach(( item: any ) => {
                        if ( !first ) {
                            descriptionFull += ', ';
                        }
                        descriptionFull += params.context.gridComponent.valueFormatterSingle( field, item );
                        first = false;
                    } );
                    return descriptionFull;
                }
            } else {
                return params.context.gridComponent.valueFormatterSingle( field, params.value );
            }
        }
        return params.value;
    }
    valueFormatterSingle( field: RestapiResourceField, value: any ) {
        if ( field.type === 'DATE' || field.type === 'DATETIME' ) {
            if ( value ) {
                return this.formatDate( value, ( field.type === 'DATETIME' ) );
            } else {
                return undefined;
            }
        } else if ( field.type === 'BIGDECIMAL' ) {
            if ( !value && value != 0 ) {
                return '';
            }
            let n = 2;
            let x = 3;
            let s = '.';
            let c = ',';
            let dataValue = ( value || value == 0 ) ? value : 0;
            let re = '\\d(?=(\\d{' + ( x || 3 ) + '})+' + ( n > 0 ? '\\D' : '$' ) + ')', num = Number( dataValue ).toFixed( Math.max( 0, ~~n ) );
            return ( ( c ? num.replace( '.', c ) : num ).replace( new RegExp( re, 'g' ), '$&' + ( s || ',' ) ) );
        } else if ( field.type === 'BOOLEAN' ) {
            if ( typeof value === 'string' ) {
                return ( value == 'true' ) ? 'Si' : 'No';
            } else {
                return ( value ) ? 'Si' : 'No';
            }
        } else if ( field.type === 'LOV' ) {
            if ( value ) {
                if ( field.lovGenericResource ) {
                    return value['description'];
                } else if ( field.lovDescriptionField ) {
                    return value[field.lovDescriptionField];
                } else {
                    return field.lovResourceName + "_" + value.id;
                }
            } else {
                return null;
            }
        }
        return value;
    }
    formatDate( value: string, isTimestamp?: boolean ) {
        let dateSeparator = '/';
        let timeSeparator = ':';
        let dateValue = new Date( value );
        if ( isTimestamp ) {
            return this.numberWithPadding( dateValue.getDate(), 2 ) + dateSeparator +
                ( this.numberWithPadding( dateValue.getMonth() + 1, 2 ) ) + dateSeparator +
                dateValue.getFullYear() + " " +
                this.numberWithPadding( dateValue.getHours(), 2 ) + timeSeparator +
                this.numberWithPadding( dateValue.getMinutes(), 2 ) + timeSeparator +
                this.numberWithPadding( dateValue.getSeconds(), 2 );
        } else {
            return this.numberWithPadding( dateValue.getDate(), 2 ) + dateSeparator +
                ( this.numberWithPadding( dateValue.getMonth() + 1, 2 ) ) + dateSeparator +
                dateValue.getFullYear();
        }
    }
    numberWithPadding( n, width, z?) {
        z = z || '0';
        n = n + '';
        return n.length >= width ? n : new Array( width - n.length + 1 ).join( z ) + n;
    }
    valueParser( params: ValueParserParams ) {
        let field: RestapiResourceField = params.context.gridComponent.getRestapiFieldForColumn(
            params.context.restapiResource,
            params.column.getColId() );
        if ( field && field.type !== 'LOV' ) {
            if ( params.newValue === '' ) {
                return null;
            } else {
                return params.newValue;
            }
        } else {
            return params.newValue;
        }
    }
    valueSetter( params: ValueSetterParams ): boolean {
        let field: RestapiResourceField = params.context.gridComponent.getRestapiFieldForColumn(
            params.context.restapiResource,
            params.column.getColId() );
        if ( field && field.type === 'LOV' ) {
            let oldValueId = ( params.oldValue ) ? params.oldValue.id : null;
            let newValueId = ( params.newValue ) ? params.newValue.id : null;
            if ( oldValueId !== newValueId ) {
                if ( newValueId ) {
                    params.data[params.column.getColId()] = params.newValue;
                } else {
                    delete params.data[params.column.getColId()];
                }
                params.context.gridComponent.setInApiContext( params.api, 'editDataHasChanged', true );
                return true;
            } else {
                return false
            }
        } else if ( params.oldValue !== params.newValue ) {
            params.data[params.column.getColId()] = params.newValue;
            params.context.gridComponent.setInApiContext( params.api, 'editDataHasChanged', true );
            return true;
        } else {
            return false;
        }
    }

    getRestapiFieldForColumn( restapiResource: RestapiResource, colId: string ): RestapiResourceField {
        let restapiField;
        if ( restapiResource ) {
            restapiResource.fields.forEach( field => {
                if ( colId === field.name ) {
                    restapiField = field;
                }
            } );
        }
        return restapiField;
    }
    getEditFormGroup( rowIndex: number, api: GridApi, context: any ): FormGroup {
        let editIsCreate = context.gridComponent.getFromApiContext( api, 'editIsCreate' );
        let contextRowIndex = context.gridComponent.getFromApiContext( api, 'editRowIndex' );
        if ( rowIndex !== contextRowIndex ) {
            let rowData = api.getDisplayedRowAtIndex( rowIndex ).data;
            let formGroup = context.restapiService.createFormGroup(
                rowData,
                context.restapiProfile.resource,
                editIsCreate );
            context.gridComponent.setInApiContext( api, 'editFormGroup', formGroup );
            context.gridComponent.setInApiContext( api, 'editInitialRowData', Object.assign( {}, rowData ) );
            context.gridComponent.setInApiContext( api, 'editRowIndex', rowIndex );
        }
        return context.gridComponent.getFromApiContext( api, 'editFormGroup' );
    }
    startEditing(
        api: GridApi,
        context: any,
        rowIndex?: number,
        colId?: string ) {
        let allColumns = api['gridOptionsWrapper'].columnApi.getAllColumns();
        if ( allColumns && allColumns.length ) {
            let rowNode = ( rowIndex !== undefined ) ? api.getDisplayedRowAtIndex( rowIndex ) : api.getSelectedNodes()[0];
			let processedColId = allColumns[0].getColId();
            /*let processedColId = colId;
            if ( !processedColId ) {
                let editIsCreate = context.gridComponent.getFromApiContext( api, 'editIsCreate' );
                let colIndex = 0;
                let field;
                let fieldDisabled = false;
                do {
                    processedColId = allColumns[colIndex++].getColId();
                    field = this.getRestapiFieldForColumn( context.restapiResource, processedColId );
                    fieldDisabled = ( editIsCreate ) ? field.disabledForCreate : field.disabledForUpdate;
                } while ( fieldDisabled && colIndex < allColumns.length );
                if ( colIndex == allColumns.length ) {
                    processedColId = allColumns[0].getColId();
                }
            }*/
            api.startEditingCell( {
                rowIndex: rowNode.rowIndex,
                colKey: processedColId
            } );
        }
    }

    refreshDetailRowsHeight( api: GridApi, additionalHeight?: number ) {
        // additionalHeight: -14 o 1
        let context = api['gridOptionsWrapper'].gridOptions.context;
        let detailRowId = context.gridComponent.getFromApiContext( api, 'detailRowId' );
        context.gridComponent.removeFromApiContext( api, 'detailRowId' );
        api.forEachDetailGridInfo( detailGridInfo => {
            if ( !detailRowId || ( detailRowId && detailRowId === detailGridInfo.id ) ) {
                let detailContext = detailGridInfo.api['gridOptionsWrapper'].gridOptions.context;
                let padding = detailContext.gridComponent.rowDetailPadding;
                let gridPanelNativeElement = detailGridInfo.api['gridPanel']['eGui'];
                let gridPanelHeight = gridPanelNativeElement.offsetHeight + padding * 2 + ( additionalHeight ? additionalHeight : 1 );
                let rowId = detailGridInfo.id.split( '_' )[1];
                let detailNode = api.getRowNode( rowId ).detailNode;
                detailNode.setRowHeight( gridPanelHeight );
                api.onRowHeightChanged();
            }
        } );
        let parentGridApi = context.gridComponent.getFromApiContext(
            api,
            'parentGridApi' );
        if ( parentGridApi ) {
            context.gridComponent.refreshDetailRowsHeight( parentGridApi );
        }
    }

    getParentPk( api: GridApi ): any {
        let context = api['gridOptionsWrapper'].gridOptions.context;
        let parentGridApi = context.gridComponent.getFromApiContext( api, 'parentGridApi' );
        if ( parentGridApi ) {
            return context.gridComponent.getFromApiContext( api, 'parentPk' );
        } else {
            return context.gridComponent.config.parent;
        }
    }

    refreshDetailRowData( restapiService: RestapiService<Resource>, parent?: any ): Observable<Resource[]> {
        return new Observable(( observer ) => {
            restapiService.getAll( {
                size: 1000,
                params: RestapiService.transformToHalParams( parent )
            } ).subscribe(( resources: Resource[] ) => {
                observer.next( resources );
                observer.complete();
            } );
        } );
    }

    getResourceDataWithLinks( data: any, api: GridApi, context: any ): Observable<any> {
        let parentPk = context.gridComponent.getParentPk( api );
        return new Observable(( observer ) => {
            if ( data._links ) {
                observer.next( data );
                observer.complete();
            } else {
                let getParams = context.restapiService.generateGetParamsWithParent( data.id, parentPk );
                context.restapiService.get( getParams ).subscribe(( resource: Resource ) => {
                    observer.next( Object.assign( data, { _links: resource._links } ) );
                    observer.complete();
                } );
            }
        } );
    }

    refreshParentRow( api: GridApi ) {
        let context = api['gridOptionsWrapper'].gridOptions.context;
        if ( context.config.refreshParentRow ) {
            let parentGridApi = context.gridComponent.getFromApiContext( api, 'parentGridApi' );
            let parentRowId = context.gridComponent.getFromApiContext( api, 'parentRowId' );
            let parentRow = parentGridApi.getRowNode( parentRowId );
            let parentContext = parentGridApi['gridOptionsWrapper'].gridOptions.context;
            let parentPk = parentContext.gridComponent.getParentPk( parentGridApi );
            let getParams = parentContext.restapiService.generateGetParamsWithParent( parentRow.data.id, parentPk );
            parentContext.restapiService.get( getParams ).subscribe(( resource: Resource ) => {
                parentRow.setData( resource );
                parentGridApi.redrawRows( {
                    rowNodes: [parentRow]
                } );
                parentGridApi.flashCells( { rowNodes: [parentRow] } );
                if ( parentContext.config.refreshParentRow ) {
                    context.gridComponent.refreshParentRow( parentGridApi );
                }
            } );
        }
    }

    gridReadyListener( event ) {
        //this.gridReady.emit( event );
    }

    isSameApi( sourceApi: GridApi, targetApi: GridApi ) {
        let sourceContext = sourceApi['gridOptionsWrapper'].gridOptions.context;
        let sourceResourceName = sourceContext.config.resourceName;
        let sourceParentPk = sourceContext.gridComponent.getParentPk( sourceApi );
        let sourceId = sourceResourceName + '#' + ( sourceParentPk ? JSON.stringify( sourceParentPk ) : '' );
        let targetContext = targetApi['gridOptionsWrapper'].gridOptions.context;
        let targetResourceName = targetContext.config.resourceName;
        let targetParentPk = targetContext.gridComponent.getParentPk( targetApi );
        let targetId = targetResourceName + '#' + ( targetParentPk ? JSON.stringify( targetParentPk ) : '' );
        return sourceId === targetId;
    }

    getFromApiContext( api: GridApi, attribute: string ): any {
        if ( api['context'] ) {
            return api['context'][attribute];
        } else {
            return undefined;
        }
    }
    setInApiContext( api: GridApi, attribute: string, value: any ) {
        if ( !api['context'] ) {
            api['context'] = {}
        }
        api['context'][attribute] = value;
    }
    removeFromApiContext( api: GridApi, attribute: string ) {
        if ( api['context'] ) {
            delete api['context'][attribute];
        }
    }

    showLoadingOverlay() {
        this.showLoading = true;
    }
    hideLoadingOverlay() {
        this.showLoading = false;
    }

    @HostListener( 'window:resize', ['$event'] )
    onWindowResize( event ) {
        if ( !this.config.detailConfig ) {
            this.refreshInternal();
        }
    }

    constructor(
        private injector: Injector,
        private translate: TranslateService,
        private sanitizer: DomSanitizer,
        private screenSizeService: ScreenSizeService ) {
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}