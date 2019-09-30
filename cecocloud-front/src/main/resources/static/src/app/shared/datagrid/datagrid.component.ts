import { Component, Input, Output, OnInit, ViewChild, ElementRef, EventEmitter, HostListener } from '@angular/core';
import { DomSanitizer, SafeStyle } from '@angular/platform-browser';
import { FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { GridApi, GridOptions, ColGroupDef, RowNode, ValueGetterParams, ValueFormatterParams, ValueParserParams, ValueSetterParams, IGetRowsParams, PaginationChangedEvent, BodyScrollEvent, RowEditingStartedEvent, RowValueChangedEvent, RowEditingStoppedEvent, SelectionChangedEvent, RowClickedEvent, RowDoubleClickedEvent } from 'ag-grid-community/main';
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
import { DatagridActionsRendererComponent } from './datagrid-actions-renderer.component';

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

@Component({
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
	<form autocomplete="off">
		<ag-grid-angular
			*ngIf="gridOptions"
			[ngClass]="theme"
			[style.height]="styleHeight"
			[gridOptions]="gridOptions"></ag-grid-angular>
	</form>
	<div *ngIf="config.mode === 'form'" style="margin-top: .4em">
		<button mat-button (click)="onAddRowButtonClick()">
			<mat-icon>add</mat-icon>
			Nova fila
		</button>
	</div>
</div>`
})
export class DatagridComponent implements OnInit {

	@Input() config: DatagridConfig;
	@Input() restapiService: RestapiService<Resource>;
	@Input() data: any[];

	@Output() headerActionCreate: EventEmitter<any> = new EventEmitter();
	@Output() headerActionDelete: EventEmitter<any> = new EventEmitter();
	@Output() selectionChanged: EventEmitter<any> = new EventEmitter();
	@Output() rowClicked: EventEmitter<any> = new EventEmitter();
	@Output() rowDoubleClicked: EventEmitter<any> = new EventEmitter();

	@ViewChild('header', { static: false }) headerComponent: DatagridHeaderComponent;
	@ViewChild('header', { read: ElementRef, static: false }) headerElementRef: ElementRef;
	@ViewChild('datagridfull', { read: ElementRef, static: false }) datagridfullElementRef: ElementRef;

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
	currentEditingRow: any;

	ngOnInit() {
		this.createGridOptions(this.config).subscribe((gridOptions: GridOptions) => {
			this.gridOptions = gridOptions;
		});
		this.formMode = this.config.mode && this.config.mode.toLowerCase() === 'form';
	}

	public refresh(additionalFilter?: any) {
		if (additionalFilter) {
			this.config.additionalFilter = additionalFilter;
		}
		this.refreshInternal();
	}
	public refreshInternal(api?: GridApi) {
		let refreshApi = (api) ? api : this.gridOptions.api;
		if (refreshApi) {
			let refreshContext = refreshApi['getOptionsContext']();
			refreshApi['getDatagridComponent']().configPagination(refreshContext.config, refreshApi['getDatagridComponent']().gridOptions);
			if (refreshContext.config.detailConfig && refreshContext.isRoot) {
				refreshApi['getDatagridComponent']().refreshDetailRowData(refreshContext.restapiService).subscribe((resources: Resource[]) => {
					refreshApi.setRowData(resources);
				});
			} else {
				refreshApi['getDatagridComponent']().showLoadingOverlay();
				refreshApi.setDatasource(
					refreshApi['getDatagridComponent']().createDataSource(refreshContext.restapiService));
			}
		}
	}

	public refreshRow(api: GridApi, rowNode: RowNode, data: any) {
		rowNode.setData(data);
		api.flashCells({ rowNodes: [rowNode] });
		api.redrawRows({
			rowNodes: [rowNode]
		});
		api['getDatagridComponent']().refreshParentRow(api);
	}

	public mantenimentConfig() {
		this.hasMantenimentDirective = true;
	}

	onQuickFilterChange(value: string) {
		this.quickFilterValue = value;
		this.refreshInternal();
	}

	onSelectionChanged(event: SelectionChangedEvent) {
		event.api['getDatagridComponent']().selectionChanged.emit(event);
		event.api['getDatagridComponent']().selectionSubject.next(event);
	}

	onPaginationChanged(event: PaginationChangedEvent) {
		if (event.api['getDatagridComponent']) {
			event.api['getDatagridComponent']().paginationSubject.next(event);
		}
	}

	onBodyScroll(event: BodyScrollEvent) {
		event.api['getDatagridComponent']().scrollSubject.next(event);
	}

	onRowClicked(event: RowClickedEvent) {
		event.api['getDatagridComponent']().rowClicked.emit(event);
	}

	onRowDoubleClicked(event: RowDoubleClickedEvent) {
		event.api['getDatagridComponent']().rowDoubleClicked.emit(event);
	}

	onRowActionClicked(api: GridApi, action: string, rowIndex: number) {
		if (action == 'delete') {
			let rowNode: RowNode = api.getDisplayedRowAtIndex(rowIndex);
			this.restapiService.delete(rowNode.data).subscribe(() => {
				rowNode.setData({});
				api.flashCells({ rowNodes: [rowNode] });
				this.refreshInternal(api);
			}, (error: any) => {
				console.log('>>> Error', error);
			});
		}
	}

	onAddRowButtonClick() {
		if (this.config.editable) {
			let api = this.gridOptions.api;
			let editActive = api['getFromApiContext']('editActive');
			if (editActive === undefined || !editActive) {
				let getParams = this.restapiService.generateGetParamsWithParent('new', this.config.parent);
				this.restapiService.get(getParams).subscribe((resource: Resource) => {
					let newRowIndex = api.getLastDisplayedRow() + 1;
					api.updateRowData({
						addIndex: newRowIndex,
						add: [resource]
					});
					this.startEditing(api, newRowIndex);
				});
			} else {
				api.stopEditing();
				//let currentRowIndex = api.getEditingCells()[0].rowIndex;
				//this.startEditing(api, currentRowIndex);
			}
		}
	}

	onRowEditingStarted(event: RowEditingStartedEvent) {
		//console.log('>>> onRowEditingStarted')
		event.api['getDatagridComponent']().currentEditingRow = event.api['gridPanel'].eCenterContainer.childNodes[event.rowIndex];
		event.api['setInApiContext']('editDataHasChanged', false);
		event.api['setInApiContext']('editActive', true);
	}
	onRowEditingStopped(event: RowEditingStoppedEvent) {
		//console.log('>>> onRowEditingStopped')
		let editIsCreate = event.data.id === undefined;
		let editDataHasChanged = event.api['getFromApiContext']('editDataHasChanged');
		if (editIsCreate && !editDataHasChanged) {
			event.api['removeFromApiContext']('editIsCreate');
			let parentGridApi = event.api['getFromApiContext']('parentGridApi');
			if (event.context.config.detailConfig || parentGridApi) {
				let newRow: RowNode = event.api.getDisplayedRowAtIndex(event.api.getLastDisplayedRow());
				event.api.updateRowData({
					remove: [newRow.data]
				});
				event.api['getDatagridComponent']().refreshDetailRowsHeight(event.api);
			} else {
				event.api['getDatagridComponent']().refreshInternal(event.api);
			}
		}
		event.api['removeFromApiContext']('editInitialRowData');
		event.api['removeFromApiContext']('editRowIndex');
		event.api['removeFromApiContext']('editActive');
		event.api['getDatagridComponent']().currentEditingRow = undefined;
	}
	onRowValueChanged(event: RowValueChangedEvent) {
		//console.log('>>> onRowValueChanged')
		let editDataHasChanged = event.api['getFromApiContext']('editDataHasChanged');
		if (editDataHasChanged) {
			let editIsCreate = event.data.id === undefined;
			let editInitialRowDataSaved = event.api['getFromApiContext']('editInitialRowData');
			let editRowIndexSaved = event.api['getFromApiContext']('editRowIndex');
			let successFunction = function(rowNode: RowNode, resource: Resource) {
				//console.log('>>> successFunction', rowNode, resource);
				rowNode.setData(resource);
				event.api.redrawRows({
					rowNodes: [rowNode]
				});
				event.api.flashCells({ rowNodes: [rowNode] });
				event.api['getDatagridComponent']().refreshInternal(event.api);
				event.api['getDatagridComponent']().refreshParentRow(event.api);
			};
			let errorFunction = function(rowNode: RowNode, error: Error) {
				console.log('>>> errorFunction', rowNode, error);
				event.api['setInApiContext']('editInitialRowData', editInitialRowDataSaved);
				event.api['setInApiContext']('editRowIndex', editRowIndexSaved);
				event.api['setInApiContext']('editError', error);
				event.api['getDatagridComponent']().startEditing(event.api, rowNode.rowIndex);
				let rowDataForUpdate = Object.assign({}, event.api['getFromApiContext']('editInitialRowData'));
				rowNode.setData(rowDataForUpdate);
			};
			if (editIsCreate) {
				event.api['getFromOptionsContext']('restapiService').create(event.data).subscribe(
					(resource: Resource) => successFunction(event.node, resource),
					(error: Error) => errorFunction(event.node, error));
			} else {
				event.api['removeFromApiContext']('editRowIndex');
				event.api['getFromOptionsContext']('restapiService').update(event.data).subscribe(
					(resource: Resource) => successFunction(event.node, resource),
					(error: Error) => errorFunction(event.node, error));
			}
		}
	}

	createGridOptions(
		gridConfig: DatagridConfig,
		parentGridOptions?: GridOptions): Observable<GridOptions> {
		let gridOptions: GridOptions = {
			suppressHorizontalScroll: true,
			suppressCellSelection: true,
			suppressContextMenu: true,
			stopEditingWhenGridLosesFocus: false,
			enableBrowserTooltips: true,
			floatingFilter: !this.mobileScreen && gridConfig.columnFiltersEnabled
		}
		gridOptions.getRowStyle = gridConfig.rowStyle;
		gridOptions.getRowClass = gridConfig.rowClass;
		gridOptions.enableColResize = gridConfig.resizable;
		let lovMode = gridConfig.mode && gridConfig.mode.toLowerCase() === 'lov';
		let formMode = gridConfig.mode && gridConfig.mode.toLowerCase() === 'form';
		if (!formMode) {
			gridOptions.rowSelection = 'single'; // 'single' o 'multiple';
		}
		gridOptions.rowDeselection = lovMode;
		gridOptions.suppressRowClickSelection = formMode ? true : !lovMode;
		if (gridConfig.editable) {
			gridOptions.editType = 'fullRow';
			gridOptions.singleClickEdit = true;
			//gridOptions.stopEditingWhenGridLosesFocus = true;
		} else {
			gridOptions.suppressClickEdit = true;
		}
		gridOptions.singleClickEdit = true
		gridOptions.rowHeight = this.rowHeight;
		gridOptions.headerHeight = this.headerHeight;
		gridOptions.onFirstDataRendered = function(event) {
			event.api['getFromApiContext'] = function(attribute: string): any {
				//console.log('>>> getFromApiContext', attribute, this['datagridApiContext'])
				if (this['datagridApiContext']) {
					return this['datagridApiContext'][attribute];
				}
			}
			event.api['setInApiContext'] = function(attribute: string, value: any) {
				//console.log('>>> setInApiContext', attribute, value, this['datagridApiContext'])
				if (!this['datagridApiContext']) {
					this['datagridApiContext'] = {}
				}
				this['datagridApiContext'][attribute] = value;
			}
			event.api['removeFromApiContext'] = function(attribute: string) {
				//console.log('>>> removeFromApiContext', attribute, this['datagridApiContext'])
				if (this['datagridApiContext']) {
					delete this['datagridApiContext'][attribute];
				}
			}
			event.api['getDatagridComponent'] = function(): DatagridComponent {
				return this['gridOptionsWrapper'].gridOptions.context['datagridComponent'];
			}
			event.api['getOptionsContext'] = function(): any {
				return this['gridOptionsWrapper'].gridOptions.context;
			}
			event.api['getFromOptionsContext'] = function(attribute: string): any {
				return this['gridOptionsWrapper'].gridOptions.context[attribute];
			}
			let parentGridApi = event.api['getFromApiContext']('parentGridApi');
			if (parentGridApi) {
				let refreshDetailHeights = parentGridApi['getFromApiContext']('refreshDetailHeights');
				if (refreshDetailHeights) {
					event.api['getDatagridComponent']().refreshDetailRowsHeight(parentGridApi);
					parentGridApi['removeFromApiContext']('refreshDetailHeights');
				}
			}
		}
		gridOptions.onGridReady = function(event) {
			event.api['getDatagridComponent']().showLoadingOverlay();
			event.api['getDatagridComponent']().headerComponent.agInit({
				api: event.api,
				context: event.api['getOptionsContext']()
			});
			/* Recalcula l'alçada de la capçalera amb els floatig filters */
			/* Només pel tema material design */
			let headerContainerElement: HTMLElement = event.api['gridPanel'].headerRootComp.eHeaderContainer;
			if (headerContainerElement.children.length == 2) {
				let headerElement: HTMLElement = event.api['gridPanel'].headerRootComp.eGui;
				headerElement.style.height = this.headerHeight * 2 + 'px';
				headerElement.style.minHeight = this.headerHeight * 2 + 'px';
				(headerContainerElement.lastChild as HTMLElement).style.height = this.headerHeight + 'px';
			}
			/* */
			event.api.hidePopupMenu();
			event.api.sizeColumnsToFit();
		}
		gridOptions.onModelUpdated = function(event) {
			event.api.sizeColumnsToFit();
			event.api['getDatagridComponent']().hideLoadingOverlay();
			if (event.api.paginationGetRowCount()) {
				event.api['getDatagridComponent']().showNoRows = false;
			} else {
				event.api['getDatagridComponent']().showNoRows = true;
			}
		}
		gridOptions.onRowDataChanged = function(event) {
			event.api['getDatagridComponent']().hideLoadingOverlay();
		}
		gridOptions.onGridSizeChanged = function(event) {
			event.api.sizeColumnsToFit();
		}
		gridOptions.onSortChanged = function(event) {
			event.api['getDatagridComponent']().showLoadingOverlay();
		}
		gridOptions.onFilterChanged = function(event) {
			event.api['getDatagridComponent']().showLoadingOverlay();
		}
		gridOptions.getRowHeight = function(params: any) {
			let rowHeight = params.api['getDatagridComponent']().rowHeight;
			if (params.node.detail) {
				let minHeight = 157;
				let detailDataAttribute = params.api['getFromOptionsContext']('detailDataAttribute');
				let details = (params.data) ? params.data[detailDataAttribute] : null;
				let headerHeight = this.matenimentHeaderHeight;
				let numRows = (details) ? details.length : 0;
				let padding = params.api['getDatagridComponent']().rowDetailPadding;
				let detailRowHeight = headerHeight + rowHeight * numRows + padding * 2;
				return (detailRowHeight > minHeight) ? detailRowHeight : minHeight;
			} else {
				return rowHeight;
			}
		}
		let restapiService = (gridConfig.restapiService) ? gridConfig.restapiService : this.restapiService;
		gridOptions.context = {
			datagridComponent: this,
			config: gridConfig,
			restapiService: restapiService,
			isRoot: !parentGridOptions
		}
		if (parentGridOptions) {
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
		if (!parentGridOptions && !gridConfig.detailConfig) {
			if (gridConfig.adjustHeight === undefined || gridConfig.adjustHeight) {
				let lovMode = gridConfig.mode && gridConfig.mode.toLowerCase() === 'lov';
				let fixedHeight: number;
				if (lovMode) {
					fixedHeight = this.lovFixedHeight;
				} else {
					fixedHeight = (this.mobileScreen) ? this.componentHeaderHeight : this.appHeaderHeight + this.componentHeaderHeight;
				}
				fixedHeight += this.marginBottom;
				this.styleHeight = this.sanitizer.bypassSecurityTrustStyle('calc(100vh - ' + fixedHeight + 'px)');
			} else if (gridConfig.height) {
				this.styleHeight = gridConfig.height + 'px';
			} else {
				gridOptions.domLayout = 'autoHeight';
			}
		}
		if (gridConfig.detailConfig) {
			gridOptions.masterDetail = true;
			gridOptions.context.detailDataAttribute = gridConfig.detailConfig.dataAttribute;
			gridOptions.onRowGroupOpened = function(event) {
				let isCloseEvent = true;
				let detailRowId: any;
				event.api.forEachDetailGridInfo(detailGridInfo => {
					let rowId = detailGridInfo.id.split('_')[1];
					let detailRowNode = event.api.getRowNode(rowId);
					if (detailRowNode.rowIndex === event.node.rowIndex) {
						isCloseEvent = false;
						detailRowId = detailGridInfo.id;
						detailGridInfo.api['setInApiContext']('detailRowId', detailRowId);
						detailGridInfo.api['setInApiContext']('parentRowId', event.node.id);
					}
					detailGridInfo.api['setInApiContext']('parentGridApi', event.api);
				});
				if (!isCloseEvent) {
					// Refresca alçada detall obert
					if (event.context.config.staticData) {
						event.api['getDatagridComponent']().refreshDetailRowsHeight(event.api);
					} else {
						event.api['setInApiContext']('refreshDetailHeights', true);
					}
				} else {
					// Refresca alçades del grid pare nomes quan es tanca el detall
					let parentGridApi = event.api['getFromApiContext']('parentGridApi');
					if (parentGridApi) {
						event.api['getDatagridComponent']().refreshDetailRowsHeight(parentGridApi);
					}
				}
			}
			gridOptions.isRowMaster = function(data) {
				if (gridConfig.detailConfig.staticData) {
					let dataAttribute = gridConfig.detailConfig.dataAttribute;
					return (data && data[dataAttribute] && data[dataAttribute].length > 0);
				} else {
					return true;
				}
			};
			this.createGridOptions(gridConfig.detailConfig, gridOptions).subscribe((detailGridOptions: GridOptions) => {
				// 75,139,194
				gridOptions.detailCellRendererParams = {
					detailGridOptions: detailGridOptions,
					getDetailRowData: function(params: any): any {
						if (gridConfig.detailConfig.staticData) {
							params.successCallback(params.data[gridConfig.detailConfig.dataAttribute]);
						} else {
							let gridApi = params.node.gridApi;
							gridApi['getDatagridComponent']().refreshDetailRowData(gridApi['getFromOptionsContext']('detailRestapiService'), params.data.pk).subscribe((resources: Resource[]) => {
								params.successCallback(resources);
								if (resources.length === 0) {
									let parentGridApi = gridApi['getFromApiContext']('parentGridApi');
									if (parentGridApi) {
										gridApi['getDatagridComponent']().refreshDetailRowsHeight(parentGridApi);
									}
								}
							});
						}
					}
				};
			});
		}
		return new Observable((observer) => {
			restapiService.whenReady().subscribe((restapiProfile: RestapiProfile) => {
				gridOptions.context.restapiProfile = restapiProfile;
				gridOptions.columnDefs = this.createColumnDefs(gridConfig, restapiProfile);
				if (parentGridOptions || gridConfig.detailConfig) {
					gridOptions.domLayout = 'autoHeight';
					if (!parentGridOptions) {
						this.refreshDetailRowData(restapiService, gridConfig.parent).subscribe(resources => {
							if (gridOptions.api) {
								gridOptions.api.setRowData(resources);
							} else {
								gridOptions.rowData = resources;
							}
						});
					}
				} else {
					gridOptions.rowModelType = 'infinite';
					this.configPagination(gridConfig, gridOptions);
					gridOptions.datasource = this.createDataSource(restapiService);
				}
				observer.next(gridOptions);
				observer.complete();
			});
		});
	}

	createColumnDefs(
		datagridConfig: DatagridConfig,
		restapiProfile: RestapiProfile): ColGroupDef[] {
		let columnDefs = [];
		let gridColumns = datagridConfig.columns;
		let lovMode = datagridConfig.mode && datagridConfig.mode.toLowerCase() === 'lov';
		let formMode = datagridConfig.mode && datagridConfig.mode.toLowerCase() === 'form';
		if (!gridColumns && restapiProfile) {
			gridColumns = [];
			restapiProfile.resource.fields.forEach((field: RestapiResourceField) => {
				let hidden = (lovMode) ? field.hiddenInLov : field.hiddenInGrid;
				if (!hidden) {
					gridColumns.push({
						field: field.name
					});
				}
			});
		}
		if (gridColumns) {
			gridColumns.forEach((gridColumn: DatagridColumn, index: number) => {
				let restapiField: RestapiResourceField;
				if (restapiProfile) {
					restapiProfile.resource.fields.forEach((field: RestapiResourceField) => {
						if (gridColumn.field === field.name) {
							restapiField = field;
						}
					});
				}
				let isModificable = restapiProfile.resource.hasUpdatePermission || restapiProfile.resource.hasDeletePermission;
				let cellStyle = { lineHeight: this.rowHeight + 'px' };
				let cellRenderer: any;
				let cellRendererFramework: any;
				let cellRendererParams: any;
				let checkboxSelection = (index == 0) && !lovMode && !formMode;
				if (!isModificable) {
					checkboxSelection = false;
				}
				let columnField = gridColumn.field;
				let columnEditable: any;
				let tooltip = (gridColumn.tooltip) ? gridColumn.tooltip : undefined;
				let tooltipField: string = (gridColumn.tooltipField) ? gridColumn.tooltipField : undefined;
				let sortable: boolean = (gridColumn.sortable === undefined) ? true : gridColumn.sortable;
				if (datagridConfig.editable) {
					columnEditable = function(params: any) {
						let editIsCreate = params.api['getFromApiContext']('editIsCreate');
						let editable = false;
						if (editIsCreate) {
							editable = !restapiField.disabledForCreate;
						} else {
							editable = !restapiField.disabledForUpdate;
						}
						if (editable && gridColumn.hasOwnProperty('editable')) {
							if (typeof gridColumn.editable === 'function') {
								return gridColumn.editable(params);
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
				let columnFieldType = (gridColumn.fieldType) ? (gridColumn.fieldType) : restapiField.type;
				let headerName = columnField;
				let cellEditorFramework: any;
				if (restapiField) {
					cellEditorFramework = DatagridRestapiEditorComponent;
					if (columnFieldType === 'BIGDECIMAL' || columnFieldType === 'INTEGER' || columnFieldType === 'FLOAT') {
						cellStyle['textAlign'] = 'right';
					}
					let headerTranslated = this.translate.instant(restapiField.translateKey);
					if (headerTranslated !== restapiField.translateKey) {
						headerName = headerTranslated;
					}
				}
				if (index == 0) {
					//checkboxSelection = ( this.config.checkboxSelection != undefined ) ? this.config.checkboxSelection : false;
					if (datagridConfig.detailConfig) {
						cellRenderer = 'agGroupCellRenderer';
					}
				}
				let filter: any;
				let filterParams = {
					suppressAndOrCondition: false,
					restapiField: restapiField
				};
				let filterFramework: any;
				let floatingFilterComponentFramework: any;
				let floatingFilterComponentParams = {
					suppressFilterButton: gridColumn.suppressFilterButton,
					restapiField: restapiField
				};
				if (restapiField && datagridConfig.columnFiltersEnabled) {
					if (restapiField.type !== 'GEOPOS') {
						filter = true;
						filterFramework = DatagridRestapiFilterComponent;
						floatingFilterComponentFramework = DatagridRestapiFloatingFilterComponent;
					}
				}
				columnDefs.push({
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
					cellRenderer: (cellRenderer !== undefined) ? cellRenderer : gridColumn.cellRenderer,
					cellRendererFramework: cellRendererFramework,
					cellRendererParams: cellRendererParams,
					//checkboxSelection: ( !lovMode ) ? checkboxSelection : false,
					checkboxSelection: checkboxSelection,
					//headerCheckboxSelection: ( !lovMode ) ? checkboxSelection : false,
					suppressMenu: true,
					filter: (filter) ? filter : false,
					filterFramework: filterFramework,
					filterParams: filterParams,
					floatingFilterComponentFramework: floatingFilterComponentFramework,
					floatingFilterComponentParams: floatingFilterComponentParams,
					tooltipField: tooltipField,
					tooltip: tooltip,
					width: (gridColumn.width) ? gridColumn.width : null
				});
			});
		}
		if (formMode) {
			columnDefs.push({
				width: this.rowHeight,
				cellRendererFramework: DatagridActionsRendererComponent,
				cellRendererParams: {
				}
			});
		}
		if (this.toolbarShown) {
			return <ColGroupDef[]>[{
				headerGroupComponentFramework: DatagridHeaderComponent,
				children: columnDefs
			}];
		} else {
			return columnDefs;
		}
	}

	createDataSource(restapiService: RestapiService<Resource>) {
		return {
			getRows: (params: IGetRowsParams) => {
				this.showLoadingOverlay();
				let requestParams: HalParam[] = [];
				let size: number;
				if (this.config.paginationEnabled === undefined || this.config.paginationEnabled) {
					size = params.endRow - params.startRow;
					let page = params.startRow / size;
					requestParams.push({
						key: 'page',
						value: '' + page
					});
				}
				params.sortModel.forEach((sortModel: any) => {
					requestParams.push({
						key: 'sort',
						value: sortModel.colId + ',' + sortModel.sort
					});
				});
				let additionalFilter = this.config.additionalFilter;
				if (additionalFilter) {
					RestapiService.transformToHalParams(additionalFilter).forEach(function(halParam: HalParam) {
						requestParams.push(halParam);
					});
				}
				if (this.quickFilterValue) {
					requestParams.push({
						key: 'quickFilter',
						value: this.quickFilterValue
					});
				}
				if (params.filterModel && Object.keys(params.filterModel).length) {
					let filterModelToRsqlQuery = function(key: any, filterModel: any) {
						let operation = filterModel.operation;
						let value = filterModel.value;
						let additionalPath = filterModel.additionalPath;
						let rsql = key + (additionalPath ? '.' + additionalPath : '');
						switch (operation) {
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
					Object.keys(params.filterModel).forEach((key) => {
						if (rsqlQuery) {
							rsqlQuery += ';';
						}
						if (params.filterModel[key].value) {
							rsqlQuery += filterModelToRsqlQuery(key, params.filterModel[key]);
						}
					});
					if (rsqlQuery) {
						requestParams.push({
							key: 'query',
							value: rsqlQuery
						});
					}
				}
				restapiService.getAll({
					size: size,
					params: requestParams
				}).subscribe((resources: any) => {
					let totalElements: any = restapiService.resourceArray.totalElements;
					if (typeof totalElements === "function") {
						totalElements = totalElements();
					}
					params.context.numElements = totalElements;
					params.successCallback(resources, totalElements);
				}, () => {
					params.failCallback();
				});
			}
		}
	}

	configPagination(
		gridConfig: DatagridConfig,
		gridOptions: GridOptions) {
		let paginationEnabled: boolean;
		if (gridConfig.paginationEnabled === undefined) {
			let lovMode = gridConfig.mode && gridConfig.mode.toLowerCase() === 'lov';
			paginationEnabled = !this.mobileScreen && !lovMode;
		} else {
			paginationEnabled = gridConfig.paginationEnabled;
		}
		if (paginationEnabled) {
			gridOptions.paginationAutoPageSize = true;
		} else {
			gridOptions.suppressPaginationPanel = true;
		}
		gridOptions.pagination = paginationEnabled;
	}

	valueGetter(params: ValueGetterParams) {
		return (params.data) ? params.data[params.column.getColId()] : undefined;
	}
	valueFormatter(params: ValueFormatterParams) {
		let field: RestapiResourceField = params.api['getDatagridComponent']().getRestapiFieldForColumn(
			params.api,
			params.column.getColId());
		if (field) {
			if (field.multiple) {
				if (params.value && params.value instanceof Array) {
					let descriptionFull = '';
					let first = true;
					params.value.forEach((item: any) => {
						if (!first) {
							descriptionFull += ', ';
						}
						descriptionFull += params.api['getDatagridComponent']().valueFormatterSingle(field, item);
						first = false;
					});
					return descriptionFull;
				}
			} else {
				return params.api['getDatagridComponent']().valueFormatterSingle(field, params.value);
			}
		}
		return params.value;
	}
	valueFormatterSingle(field: RestapiResourceField, value: any) {
		if (field.type === 'DATE' || field.type === 'DATETIME') {
			if (value) {
				return this.formatDate(value, (field.type === 'DATETIME'));
			} else {
				return undefined;
			}
		} else if (field.type === 'BIGDECIMAL') {
			if (!value && value != 0) {
				return '';
			}
			let n = 2;
			let x = 3;
			let s = '.';
			let c = ',';
			let dataValue = (value || value == 0) ? value : 0;
			let re = '\\d(?=(\\d{' + (x || 3) + '})+' + (n > 0 ? '\\D' : '$') + ')', num = Number(dataValue).toFixed(Math.max(0, ~~n));
			return ((c ? num.replace('.', c) : num).replace(new RegExp(re, 'g'), '$&' + (s || ',')));
		} else if (field.type === 'BOOLEAN') {
			if (typeof value === 'string') {
				return (value == 'true') ? this.translate.instant('component.datagrid.boolean.si') : this.translate.instant('component.datagrid.boolean.no');
			} else {
				return (value) ? this.translate.instant('component.datagrid.boolean.si') : this.translate.instant('component.datagrid.boolean.no');
			}
		} else if (field.type === 'LOV') {
			if (value) {
				if (field.lovGenericResource) {
					return value['description'];
				} else if (field.lovDescriptionField) {
					return value[field.lovDescriptionField];
				} else {
					return field.lovResourceName + "_" + value.id;
				}
			} else {
				return null;
			}
		} else if (field.type === 'GEOPOS' && value) {
			return (value.latitude || '') + ', ' + (value.longitude || '');
		}
		return value;
	}
	formatDate(value: string, isTimestamp?: boolean) {
		let dateSeparator = '/';
		let timeSeparator = ':';
		let dateValue = new Date(value);
		if (isTimestamp) {
			return this.numberWithPadding(dateValue.getDate(), 2) + dateSeparator +
				(this.numberWithPadding(dateValue.getMonth() + 1, 2)) + dateSeparator +
				dateValue.getFullYear() + " " +
				this.numberWithPadding(dateValue.getHours(), 2) + timeSeparator +
				this.numberWithPadding(dateValue.getMinutes(), 2) + timeSeparator +
				this.numberWithPadding(dateValue.getSeconds(), 2);
		} else {
			return this.numberWithPadding(dateValue.getDate(), 2) + dateSeparator +
				(this.numberWithPadding(dateValue.getMonth() + 1, 2)) + dateSeparator +
				dateValue.getFullYear();
		}
	}
	numberWithPadding(n: any, width: number, z?: string) {
		z = z || '0';
		n = n + '';
		return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
	}
	valueParser(params: ValueParserParams) {
		let field: RestapiResourceField = params.api['getDatagridComponent']().getRestapiFieldForColumn(
			params.api,
			params.column.getColId());
		if (field && field.type !== 'LOV') {
			if (params.newValue === '') {
				return null;
			} else {
				return params.newValue;
			}
		} else {
			return params.newValue;
		}
	}
	valueSetter(params: ValueSetterParams): boolean {
		let field: RestapiResourceField = params.api['getDatagridComponent']().getRestapiFieldForColumn(
			params.api,
			params.column.getColId());
		if (field && field.type === 'LOV') {
			let oldValueId = (params.oldValue) ? params.oldValue.id : null;
			let newValueId = (params.newValue) ? params.newValue.id : null;
			if (oldValueId !== newValueId) {
				if (newValueId) {
					params.data[params.column.getColId()] = params.newValue;
				} else {
					delete params.data[params.column.getColId()];
				}
				params.api['setInApiContext']('editDataHasChanged', true);
				return true;
			} else {
				return false
			}
		} else if (params.oldValue !== params.newValue) {
			params.data[params.column.getColId()] = params.newValue;
			params.api['setInApiContext']('editDataHasChanged', true);
			return true;
		} else {
			return false;
		}
	}

	getEditFormGroup(api: GridApi, rowIndex: number): FormGroup {
		let editIsCreate = api['getFromApiContext']('editIsCreate');
		let contextRowIndex = api['getFromApiContext']('editRowIndex');
		if (rowIndex !== contextRowIndex) {
			let rowData = api.getDisplayedRowAtIndex(rowIndex).data;
			let formGroup = api['getFromOptionsContext']('restapiService').createFormGroup(
				rowData,
				api['getFromOptionsContext']('restapiProfile').resource,
				editIsCreate);
			api['setInApiContext']('editFormGroup', formGroup);
			api['setInApiContext']('editInitialRowData', Object.assign({}, rowData));
			api['setInApiContext']('editRowIndex', rowIndex);
		}
		return api['getFromApiContext']('editFormGroup');
	}

	startEditing(
		api: GridApi,
		rowIndex: number,
		colId?: string) {
		let allColumns = api['gridOptionsWrapper'].columnApi.getAllColumns();
		if (allColumns && allColumns.length) {
			let rowNode = api.getDisplayedRowAtIndex(rowIndex);
			//let processedColId = allColumns[0].getColId();
			let processedColId = colId;
			if (!processedColId) {
				let editIsCreate = rowNode.data.id === undefined;
				let colIndex = 0;
				let fieldDisabled = false;
				do {
					processedColId = allColumns[colIndex++].getColId();
					let field = this.getRestapiFieldForColumn(api, processedColId);
					fieldDisabled = (editIsCreate) ? field.disabledForCreate : field.disabledForUpdate;
				} while (fieldDisabled && colIndex < allColumns.length);
				if (colIndex == allColumns.length) {
					processedColId = allColumns[0].getColId();
				}
			}
			api.startEditingCell({
				rowIndex: rowNode.rowIndex,
				colKey: processedColId
			});
		}
	}

	getRestapiFieldForColumn(api: GridApi, colId: string): RestapiResourceField {
		let restapiResource: RestapiResource = api['getFromOptionsContext']('restapiProfile').resource;
		let restapiField: RestapiResourceField;
		if (restapiResource) {
			restapiResource.fields.forEach(field => {
				if (colId === field.name) {
					restapiField = field;
				}
			});
		}
		return restapiField;
	}

	refreshDetailRowsHeight(api: GridApi, additionalHeight?: number) {
		// additionalHeight: -14 o 1
		let detailRowId = api['getFromApiContext']('detailRowId');
		api['removeFromApiContext']('detailRowId');
		api.forEachDetailGridInfo(detailGridInfo => {
			if (!detailRowId || (detailRowId && detailRowId === detailGridInfo.id)) {
				let padding = detailGridInfo.api['getDatagridComponent']().rowDetailPadding;
				let gridPanelNativeElement = detailGridInfo.api['gridPanel']['eGui'];
				let gridPanelHeight = gridPanelNativeElement.offsetHeight + padding * 2 + (additionalHeight ? additionalHeight : 1);
				let rowId = detailGridInfo.id.split('_')[1];
				let detailNode = api.getRowNode(rowId).detailNode;
				detailNode.setRowHeight(gridPanelHeight);
				api.onRowHeightChanged();
			}
		});
		let parentGridApi = api['getFromApiContext']('parentGridApi');
		if (parentGridApi) {
			api['getDatagridComponent']().refreshDetailRowsHeight(parentGridApi);
		}
	}

	refreshDetailRowData(restapiService: RestapiService<Resource>, parent?: any): Observable<Resource[]> {
		return new Observable((observer) => {
			restapiService.getAll({
				size: 1000,
				params: RestapiService.transformToHalParams(parent)
			}).subscribe((resources: Resource[]) => {
				observer.next(resources);
				observer.complete();
			});
		});
	}

	getResourceDataWithLinks(data: any, api: GridApi): Observable<any> {
		return new Observable((observer) => {
			if (data._links) {
				observer.next(data);
				observer.complete();
			} else {
				let parent = api['getDatagridComponent']().config.parent;
				let getParams = api['getFromOptionsContext']('restapiService').generateGetParamsWithParent(data.id, parent);
				api['getFromOptionsContext']('restapiService').get(getParams).subscribe((resource: Resource) => {
					observer.next(Object.assign(data, { _links: resource._links }));
					observer.complete();
				});
			}
		});
	}

	refreshParentRow(api: GridApi) {
		if (api['getFromOptionsContext']('config').refreshParentRow) {
			let parentGridApi = api['getFromApiContext']('parentGridApi');
			let parentRowId = api['getFromApiContext']('parentRowId');
			let parentRow = parentGridApi.getRowNode(parentRowId);
			let restapiService = parentGridApi['getFromOptionsContext']('restapiService');
			let getParams = restapiService.generateGetParamsWithParent(parentRow.data.id);
			restapiService.get(getParams).subscribe((resource: Resource) => {
				parentRow.setData(resource);
				parentGridApi.redrawRows({
					rowNodes: [parentRow]
				});
				parentGridApi.flashCells({ rowNodes: [parentRow] });
				if (parentGridApi['getFromOptionsContext']('config').refreshParentRow) {
					api['getDatagridComponent']().refreshParentRow(parentGridApi);
				}
			});
		}
	}

	showLoadingOverlay() {
		this.showLoading = true;
	}
	hideLoadingOverlay() {
		this.showLoading = false;
	}

	@HostListener('window:resize')
	onWindowResize() {
		if (!this.config.detailConfig) {
			this.refreshInternal();
		}
	}
	@HostListener('document:click', ['$event'])
	onDocumentClick(event: Event) {
		let isOutsideEditingRow = false;
		if (this.currentEditingRow) {
			isOutsideEditingRow = !this.currentEditingRow.contains(event.target);
		}
		let targetClassName = event.target['className'];
		if (isOutsideEditingRow && this.gridOptions && this.gridOptions.api) {
			let isInputDesplegableClick = targetClassName.indexOf('mat-option') != -1 || targetClassName.indexOf('mat-calendar') != -1;
			if (!isInputDesplegableClick) {
				this.gridOptions.api.stopEditing();
			}
		}
	}

	constructor(
		private translate: TranslateService,
		private sanitizer: DomSanitizer,
		private screenSizeService: ScreenSizeService) {
		this.mobileScreen = this.screenSizeService.isMobile();
		this.screenSizeService.getScreenSizeChangeSubject().subscribe((event: ScreenSizeChangeEvent) => {
			this.mobileScreen = event.mobile
		});
	}

}