import {
    Component,
    Input,
    Output,
    OnInit,
    ViewChild,
    ElementRef,
    EventEmitter,
    HostListener,
    Injector
} from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { HttpParams } from '@angular/common/http';
import {
    GridApi,
    GridOptions,
    ColDef,
    ColGroupDef,
    Column,
    RowNode,
    ValueGetterParams,
    ValueFormatterParams,
    ValueParserParams,
    ValueSetterParams,
    IGetRowsParams
} from 'ag-grid-community/main';
import { Resource, HalParam } from 'angular4-hal';
import { Observable, Subject, Subscription } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { RestapiService } from '../restapi/restapi.service';
import {
    RestapiProfile,
    RestapiResource,
    RestapiResourceField
} from '../restapi/restapi-profile';
import { ScreenSizeService, ScreenSizeChangeEvent } from '../../shared/screen-size.service';
import { DatagridHeaderComponent } from './datagrid-header.component';
import { DatagridLinkCellRenderer } from './datagrid-link-cell-renderer.component';

export interface DatagridConfig {
    parent?: any;
    columns?: DatagridColumn[];
    height?: number;
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
    filterInEachColumn?: boolean;
    pagination?: boolean;
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
<datagrid-header #header (quickFilterChange)="onQuickFilterChange($event)"></datagrid-header>
<ag-grid-angular
    *ngIf="gridOptions"
    [ngClass]="theme"
    [style.height]="styleHeight"
    [gridOptions]="gridOptions"></ag-grid-angular>`
} )
export class DatagridComponent implements OnInit {

    @Input() config: DatagridConfig;
    @Input() restapiService: RestapiService<Resource>;
    @Input() data: any[];

    @Output() headerActionCreate: EventEmitter<any> = new EventEmitter();
    @Output() headerActionDelete: EventEmitter<any> = new EventEmitter();
    @Output() selectionChanged: EventEmitter<any> = new EventEmitter();
    @Output() rowDoubleClicked: EventEmitter<any> = new EventEmitter();

    @ViewChild( 'header', { static: false } ) header: DatagridHeaderComponent;

    // Subjects per a la comunicació entre components
    private selectionSubject = new Subject<any>();
    private paginationSubject = new Subject<any>();
    private scrollSubject = new Subject<any>();

    // Aparença
    private toolbarShown = false;
    private theme = 'ag-theme-material'; // 'ag-theme-balham' o 'ag-theme-material'
    private appHeaderHeight = 64;
    private componentHeaderHeight = 96;
    private lovFixedHeight = 220;
    private headerHeight = 46;
    private rowHeight = 32;
    private styleHeight;
    private marginBottom = 0;
    private styleMarginBottom = this.marginBottom + 'px';
    private rowDetailPadding = 20;

    // Altres
    private gridOptions: GridOptions;
    private hasMantenimentDirective: boolean;
    private quickFilterValue: string;
    private mobileScreen: boolean;

    ngOnInit() {
        this.createGridOptions( this.config ).subscribe(( gridOptions: GridOptions ) => {
            this.gridOptions = gridOptions;
        } );
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
                refreshApi.setDatasource(refreshContext.gridComponent.createDataSource( refreshContext.restapiService ) );
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

    onSelectionChanged( event ) {
        event.context.gridComponent.selectionChanged.emit( event );
        event.context.gridComponent.selectionSubject.next( event );
    }

    onRowDoubleClicked( event ) {
        event.context.gridComponent.rowDoubleClicked.emit( event );
    }

    onPaginationChanged( event ) {
        event.api['gridOptionsWrapper'].gridOptions.context.gridComponent.paginationSubject.next( event );
    }

    onBodyScroll( event ) {
        event.api['gridOptionsWrapper'].gridOptions.context.gridComponent.scrollSubject.next( event );
    }

    createGridOptions(
        gridConfig: DatagridConfig,
        parentGridOptions?: GridOptions ): Observable<GridOptions> {
        let gridOptions: GridOptions = {
            suppressCellSelection: true,
            suppressContextMenu: true,
            stopEditingWhenGridLosesFocus: true,
            enableBrowserTooltips: true,
            overlayLoadingTemplate: '<span class="ag-overlay-loading-center" style="padding-top: 1.5em"><i class="fa fa-cog fa-spin fa-2x fa-fw"></i></span>',
            overlayNoRowsTemplate: '&nbsp;', //'<span style="padding: 10px; border: 2px solid #444; background: #efefef;">' + this.translate.instant( 'datatable.sense.resultats' ) + '</span>',
        }
        let showOverlayLoading = false;
        gridOptions.getRowStyle = gridConfig.rowStyle;
        gridOptions.getRowClass = gridConfig.rowClass;
        gridOptions.enableColResize = gridConfig.resizable;
        gridOptions.suppressRowClickSelection = !gridConfig.lovMode;
        gridOptions.rowSelection = 'single'; // 'multiple';
        gridOptions.rowDeselection = gridConfig.lovMode;
        gridOptions.editType = 'fullRow';
        gridOptions.rowHeight = this.rowHeight;
        gridOptions.headerHeight = this.headerHeight;
        gridOptions.onGridReady = function( event ) {
            /*if ( !gridConfig.staticData ) {
                event.api.showLoadingOverlay();
                if ( event.api.getModel().getRowCount() == 0 ) {
                    showOverlayLoading = true;
                }
            }*/
            let context = event.api['gridOptionsWrapper'].gridOptions.context;
            context.gridComponent.header.agInit( {
                api: event.api,
                context: context
            } );
            event.api.hidePopupMenu();
            event.api.sizeColumnsToFit();
        }
        gridOptions.onModelUpdated = function( event ) {
            event.api.showLoadingOverlay();
            let context = event.api['gridOptionsWrapper'].gridOptions.context;
            /*context.gridComponent.messageService.sendSelection(
                event.api.getSelectedRows() );*/
            if ( context.datasourceParentPk ) {
                delete context.datasourceParentPk;
            }
            event.api.sizeColumnsToFit();
            if ( event.api.getModel().getRowCount() != 0 && !showOverlayLoading ) {
                event.api.hideOverlay();
            } else if ( !showOverlayLoading ) {
                event.api.showNoRowsOverlay();
            }
            if ( showOverlayLoading ) {
                showOverlayLoading = false;
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
            event.api.hideOverlay();
        }
        gridOptions.onGridSizeChanged = function( event ) {
            event.api.sizeColumnsToFit();
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
        gridOptions.onRowSelected = this.onSelectionChanged;
        gridOptions.onPaginationChanged = this.onPaginationChanged;
        gridOptions.onBodyScroll = this.onBodyScroll;
        gridOptions.onRowDoubleClicked = this.onRowDoubleClicked;
        if ( !parentGridOptions && !gridConfig.detailConfig ) {
            if ( gridConfig.height ) {
                this.styleHeight = gridConfig.height + 'px';
            } else {
                let fixedHeight;
                if ( gridConfig.lovMode ) {
                    fixedHeight = this.lovFixedHeight;
                } else {
                    fixedHeight = this.appHeaderHeight + this.componentHeaderHeight;
                }
                fixedHeight += this.marginBottom;
                this.styleHeight = this.sanitizer.bypassSecurityTrustStyle( 'calc(100vh - ' + fixedHeight + 'px)' );
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
        if ( !gridColumns && restapiProfile ) {
            gridColumns = [];
            restapiProfile.resource.fields.forEach( field => {
                let hidden = ( this.config.lovMode ) ? field.hiddenInLov : field.hiddenInGrid;
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
                let cellStyle = { lineHeight: this.rowHeight + 'px' };
                let cellRenderer;
                let cellRendererFramework = DatagridLinkCellRenderer;
                let cellEditorFramework;
                let checkboxSelection = ( index == 0 ) && !datagridConfig.lovMode;
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
                }
                let columnFieldType = ( gridColumn.fieldType ) ? ( gridColumn.fieldType ) : restapiField.type;
                let headerName = columnField;
                if ( restapiField ) {
                    //cellEditorFramework = DatagridRestapiEditorComponent;
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
                    suppressAndOrCondition: false
                };
                let filterFramework;
                let floatingFilterComponentFramework;
                let floatingFilterComponentParams = {
                    suppressFilterButton: gridColumn.suppressFilterButton
                };
                if ( datagridConfig.filterInEachColumn ) {
                    filter = 'agTextColumnFilter';
                    /*if ( restapiField ) {
                        switch ( columnFieldType ) {
                            case 'STRING':
                                filter = 'agTextColumnFilter';
                                filterParams['textFormatter'] = ( val ) => val;
                                break;
                            case 'TEXTAREA':
                                filter = 'agTextColumnFilter';
                                break;
                            case 'LOV':
                                filter = 'agTextColumnFilter';
                                break;
                            case 'COLLECTION':
                                filter = 'agTextColumnFilter';
                                sortable = false;
                                break;
                            case 'INTEGER':
                                filter = 'agNumberColumnFilter';
                                break;
                            case 'FLOAT':
                                filter = 'agNumberColumnFilter';
                                break;
                            case 'BIGDECIMAL':
                                filter = 'agNumberColumnFilter';
                                break;
                            case 'PREU':
                                filter = 'agNumberColumnFilter';
                                break;
                            case 'IMPORT':
                                filter = 'agNumberColumnFilter';
                                break;
                            case 'DATE':
                                filter = 'agDateColumnFilter';
                                break;
                            case 'BOOLEAN':
                                filter = true;
                                filterFramework = DatagridFilterBooleanComponent;
                                floatingFilterComponentFramework = DatagridFilterFloatingBooleanComponent;
                                break;
                            case 'ENUM':
                                filter = true;
                                filterFramework = DatagridFilterEnumComponent;
                                floatingFilterComponentFramework = DatagridFilterFloatingEnumComponent;
                                filterParams['enumValues'] = restapiField.enumValues;
                                floatingFilterComponentParams['enumValues'] = restapiField.enumValues;
                                break;
                            case 'PASSWORD':
                                break;
                        }
                    } else {
                        filter = 'agTextColumnFilter';
                    }*/
                }
                if ( gridColumn.filterable ) {
                    filter = false;
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
                    //checkboxSelection: ( !this.config.lovMode ) ? checkboxSelection : false,
                    checkboxSelection: checkboxSelection,
                    //headerCheckboxSelection: ( !this.config.lovMode ) ? checkboxSelection : false,
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
                let size = params.endRow - params.startRow;
                let page = params.startRow / size;
                let requestParams: HalParam[] = [{
                    key: 'page',
                    value: '' + page
                }];
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
                    let toColumnFilter = function( fieldName: string, filter: any ) {
                        let columnFilter = {
                            fieldName: fieldName
                        };
                        let hasItems = false;
                        if ( filter.condition1 ) {
                            let items = [];
                            let condition1Item = toColumnFilterItem( filter.condition1 );
                            if ( condition1Item ) {
                                items.push( condition1Item );
                            }
                            let condition2Item = toColumnFilterItem( filter.condition2 );
                            if ( condition2Item ) {
                                items.push( condition2Item );
                            }
                            if ( items.length ) {
                                columnFilter['items'] = items;
                                columnFilter['operation'] = filter.operator;
                                hasItems = true;
                            }
                        } else {
                            let item = toColumnFilterItem( filter );
                            if ( item ) {
                                columnFilter['items'] = [item];
                                hasItems = true;
                            }
                        }
                        return ( hasItems ) ? columnFilter : undefined;
                    }
                    let toColumnFilterItem = function( filter: any ) {
                        let value = ( filter.filterType === 'date' ) ? filter.dateFrom : filter.filter;
                        if ( value !== undefined ) {
                            let item = {
                                value: value
                            };
                            switch ( filter.type ) {
                                case 'equals':
                                    item['comparatorType'] = 'EQUAL';
                                    break;
                                case 'notEqual':
                                    item['comparatorType'] = 'NOT_EQUAL';
                                    break;
                                case 'startsWith':
                                    item['comparatorType'] = 'STARTS_WITH';
                                    break;
                                case 'endsWith':
                                    item['comparatorType'] = 'ENDS_WITH';
                                    break;
                                case 'contains':
                                    item['comparatorType'] = 'CONTAINS';
                                    break;
                                case 'notContains':
                                    item['comparatorType'] = 'NOT_CONTAINS';
                                    break;
                                case 'greaterThan':
                                    item['comparatorType'] = 'GREATER_THAN';
                                    break;
                                case 'lessThan':
                                    item['comparatorType'] = 'LESS_THAN';
                                    break;
                                case 'greaterThanOrEqual':
                                    item['comparatorType'] = 'GREATER_THAN_OR_EQUAL';
                                    break;
                                case 'lessThanOrEqual':
                                    item['comparatorType'] = 'LESS_THAN_OR_EQUAL';
                                    break;
                                case 'inRange':
                                    item['comparatorType'] = 'IN_RANGE';
                                    break;
                            }
                            if ( filter.filterType === 'date' ) {
                                if ( filter.dateTo ) {
                                    item['valueTo'] = filter.dateTo;
                                }
                            } else {
                                if ( filter.filterTo ) {
                                    item['valueTo'] = filter.filterTo;
                                }
                            }
                            return item;
                        }
                    }
                    let columnIndex = 0;
                    Object.keys( params.filterModel ).forEach(( key ) => {
                        let columnFilter: any = toColumnFilter( key, params.filterModel[key] );
                        if ( columnFilter ) {
                            requestParams.push( {
                                key: 'columnFilters[' + columnIndex + '].fieldName',
                                value: key
                            } );
                            let itemIndex = 0;
                            columnFilter.items.forEach( function( item: any ) {
                                if ( item ) {
                                    requestParams.push( {
                                        key: 'columnFilters[' + columnIndex + '].items[' + itemIndex + '].comparatorType',
                                        value: item.comparatorType
                                    } );
                                    requestParams.push( {
                                        key: 'columnFilters[' + columnIndex + '].items[' + itemIndex + '].value',
                                        value: item.value
                                    } );
                                    if ( item.valueTo ) {
                                        requestParams.push( {
                                            key: 'columnFilters[' + columnIndex + '].items[' + itemIndex + '].valueTo',
                                            value: item.valueTo
                                        } );
                                    }
                                    itemIndex++;
                                }
                            } );
                            if ( columnFilter.operation ) {
                                requestParams.push( {
                                    key: 'columnFilters[' + columnIndex + '].operation',
                                    value: columnFilter.operation
                                } );
                            }
                            columnIndex++;
                        }
                    } );
                }
                restapiService.getAll( {
                    size: size,
                    params: requestParams
                } ).subscribe(( resources: any ) => {
                    params.context.numElements = restapiService.resourceArray.totalElements;
                    params.successCallback(
                        resources,
                        restapiService.resourceArray.totalElements );
                }, error => {
                    params.failCallback();
                } );
            }
        }
    }

    configPagination(
        gridConfig: DatagridConfig,
        gridOptions: GridOptions ) {
        let paginationEnabled: boolean;
        if ( gridConfig.pagination === undefined ) {
            paginationEnabled = !this.mobileScreen;
        } else {
            paginationEnabled = gridConfig.pagination;
        }
        if ( paginationEnabled ) {
            gridOptions.pagination = true;
            gridOptions.paginationAutoPageSize = true;
            gridOptions.suppressPaginationPanel = true;
        } else {
            gridOptions.pagination = false;
        }
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
                if ( field.lovDescriptionFieldInFront && value[field.lovDescriptionFieldInFront] ) {
                    return value[field.lovDescriptionFieldInFront];
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
                context.restapiResource,
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
            let processedColId = colId;
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
            }
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