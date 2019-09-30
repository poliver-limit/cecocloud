import {
	Component,
	Injector,
	OnInit,
	ComponentFactoryResolver,
	ComponentFactory,
	ComponentRef,
	Input,
	Output,
	EventEmitter,
	ViewChild,
	ViewContainerRef,
	ContentChildren,
	QueryList
} from '@angular/core';
import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MdcTabBar, MdcTabActivatedEvent } from '@angular-mdc/web';
import { Resource, ResourceHelper } from 'angular4-hal';

import { GenericResource } from '../restapi/restapi-generic.service';
import { RestapiService } from '../restapi/restapi.service';
import {
	RestapiProfile,
	RestapiResource,
	RestapiResourceField,
	RestapiResourceGrid
} from '../restapi/restapi-profile';
import { RestapiBaseFieldComponent } from './restapi-base-field.component';
import { RestapiFieldMaterialComponent } from './restapi-field-material.component';
import { RestapiCustomFieldComponent } from './restapi-custom-field.component';
import { RestapiFormExitGuard } from './restapi-form-exit-guard';

export interface FormConfig {
	parent?: any;
	fields?: FormFieldConfig[];
	grids?: FormGridConfig[];
	isButtonSave?: boolean;
	isUpdateShow?: boolean;
}
export interface FormFieldConfig {
	name: string;
	label: string;
}
export interface FormGridConfig {
	name: string;
	label: string;
}

@Component({
	selector: 'restapi-form',
	template: `
    <ng-container>
        <restapi-form-header
            [id]="id"
            [description]="description"
            [restapiResource]="restapiResource"
            [restapiError]="restapiError"
            [anyFieldChanged]="anyFieldChanged"
            (actionCancel)="onHeaderActionCancel()"
            (actionSave)="onHeaderActionSave()"
            (actionUndo)="onHeaderActionUndo()"
            (actionDelete)="onHeaderActionDelete()"></restapi-form-header>
        <ng-container *ngTemplateOutlet="formTemplate"></ng-container>
    </ng-container>    
    <ng-template #formTemplate>
        <form [formGroup]="formGroup" autocomplete="off">
            <button (click)="onHeaderActionSave()" style="display:none"></button>
            <mdc-tab-bar
                #formTabs
                *ngIf="showTabs"
                fixed="true"
                (activated)="onTabChanged($event)">
                <mdc-tab-scroller>
                    <mdc-tab label="Dades"></mdc-tab>
                    <mdc-tab
                        *ngFor="let grid of grids"
                        [label]="getGridLabel(grid)"></mdc-tab>
                </mdc-tab-scroller>
            </mdc-tab-bar>
            <div id="form-content">
                <div [hidden]="activeTab != 0">
                    <ng-template #fieldsContainer></ng-template>
                    <ng-content></ng-content>
                </div>
                <div *ngFor="let grid of grids; index as i">
                    <div *ngIf="activeTab == i + 1">
                        <datagrid
                            datagrid-mant
                            [config]="{
                                resourceName: grid.resourceName,
                                height: 400
                            }"></datagrid>
                    </div>
                </div>
            </div>
        </form>
    </ng-template>`,
	styles: [`
mdc-top-app-bar {
    position: unset;
    display: block;
}
form {
    padding: 1em 2em;
}
#actions {
    display: flex;
    flex-direction: row-reverse;
}
`]
})
export class RestapiFormComponent implements OnInit {

	@Input() config: FormConfig;
	@Input() restapiService: RestapiService<Resource>;
	@Input() restapiLovServices: RestapiService<Resource>[];
	@Input() id: any;
	@Input()
	set data(data: any) {
		this.refrescarFormGroup(data);
	}

	@Output() actionSave: EventEmitter<any> = new EventEmitter();
	@Output() actionCancel: EventEmitter<any> = new EventEmitter();
	@Output() actionDelete: EventEmitter<any> = new EventEmitter();
	@Output() resourceChange: EventEmitter<any> = new EventEmitter();

	@ViewChild('fieldsContainer', { read: ViewContainerRef, static: false }) fieldsContainer: ViewContainerRef;
	@ContentChildren(RestapiCustomFieldComponent) customInputs: QueryList<RestapiCustomFieldComponent>;
	@ViewChild('formTabs', { static: false }) formTabs: MdcTabBar;

	description: string;
	resourceInstance: any;
	restapiResource: RestapiResource;
	formGroup: FormGroup;
	defaultFieldComponentFactory: ComponentFactory<any>;
	inputFields: RestapiBaseFieldComponent[];
	parentFromRoute: any;

	showTabs: boolean = false;
	activeTab: number = 0;
	grids: RestapiResourceGrid[];
	restapiError: any;
	isButtonSave: boolean;
	isUpdateShow: boolean;
	anyFieldChanged: boolean;

	ngOnInit() {
		if (this.config != undefined) {
			this.isButtonSave = (this.config.isButtonSave != undefined && this.config.isButtonSave);
			this.isUpdateShow = (this.config.isUpdateShow != undefined && this.config.isUpdateShow);
		}
		this.refreshFields();
	}

	onHeaderActionCancel() {
		this.actionCancel.emit();
	}

	onHeaderActionSave() {
		this.resetFieldsValidation();
		let values = {};
		if (this.resourceInstance) {
			values = {
				_links: this.resourceInstance._links,
				id: this.resourceInstance.id
			};
		}
		let formGroupValue = this.formGroup.value;
		for (let property in formGroupValue) {
			if (formGroupValue.hasOwnProperty(property)) {
				values[property] = formGroupValue[property];
			}
		}
		this.restapiResource.fields.forEach(field => {
			if (field.type === 'LOV') {
				if (!values[field.name] || !values[field.name].id) {
					delete values[field.name];
				}
			}
		});
		if (this.isCreacio()) {
			let uri = ResourceHelper.getURL() + this.restapiService['resource'];
			let params = new HttpParams({ fromObject: this.getParent() });
			this.http.post(uri, values, { params: params }).subscribe((resource: Resource) => {
				this.formExitGuard.setModified(false);
				this.actionSave.emit(resource);
			}, errorResponse => {
				this.processErrors(errorResponse);
			});
		} else {
			this.restapiService.update(Object.assign(new GenericResource, values)).subscribe((resource: Resource) => {
				this.refrescarFormGroup(resource);
				this.formExitGuard.setModified(false);
				this.actionSave.emit(resource);
			}, errorResponse => {
				this.processErrors(errorResponse);
			});
		}
	}

	onHeaderActionUndo() {
		if (confirm(this.translateKey('component.restapi.form.undo.confirm'))) {
			this.refreshFields();
		}
	}

	onHeaderActionDelete() {
		let resourceName = this.restapiResource.name;
		let rowData = this.resourceInstance;
		let rowDescription = (this.restapiResource.descriptionField) ? rowData[this.restapiResource.descriptionField] : '#' + rowData.id;
		let confirmTranslated = this.translateKey(
			'component.restapi.form.delete.confirm',
			{ description: resourceName + ' ' + rowDescription });
		if (confirm(confirmTranslated)) {
			this.restapiService.delete(this.resourceInstance).subscribe((resource: Resource) => {
				this.actionDelete.emit(resource);
			});
		}
	}

	refreshFields() {
		if (this.fieldsContainer) {
			this.fieldsContainer.clear();
		}
		this.anyFieldChanged = false;
		this.formExitGuard.setModified(false);
		this.restapiService.whenReady().subscribe((restapiProfile: RestapiProfile) => {
			this.restapiResource = restapiProfile.resource;
			if (this.restapiResource.grids && this.id) {
				this.showTabs = true;
				this.grids = this.restapiResource.grids;
			}
			if (this.id == null) {
				this.restapiService.get(this.restapiService.generateGetParamsWithParent(
					'new',
					this.getParent())).subscribe(
						(resourceInstance: Resource) => {
							this.refrescarFormGroup(resourceInstance);
							this.createInputs(this.restapiResource.fields);
						});
			} else {
				this.restapiService.get(this.restapiService.generateGetParamsWithParent(
					this.id,
					this.getParent())).subscribe(
						(resourceInstance: Resource) => {
							this.refrescarFormGroup(resourceInstance);
							this.createInputs(this.restapiResource.fields);
							this.description = (this.restapiResource.descriptionField) ? resourceInstance[this.restapiResource.descriptionField] : '#' + this.id;
						});
			}
		});
	}

	refrescarFormGroup(resourceInstance?: any) {
		if (resourceInstance) {
			this.resourceInstance = resourceInstance;
		} else {
			this.resourceInstance = {};
		}
		this.resourceChange.emit(this.resourceInstance);
		this.formGroup = this.restapiService.createFormGroup(
			this.resourceInstance,
			this.restapiResource,
			this.isCreacio()
		);
	}

	createInputs(fields: RestapiResourceField[]) {
		this.inputFields = [];
		if (fields && fields.length) {
			fields.forEach((field: RestapiResourceField) => {
				if (!field.hiddenInForm) {
					let inputRef: ComponentRef<RestapiBaseFieldComponent>;
					if (this.customInputs && this.customInputs.length) {
						let customInput: RestapiCustomFieldComponent = this.customInputs
							.toArray()
							.find(function(customInput: RestapiCustomFieldComponent) {
								return customInput.name === field.name;
							});
						if (customInput) {
							let customField: RestapiBaseFieldComponent = customInput.getContentField()
							if (!customField) {
								inputRef = this.defaultFieldComponentFactory.create(this.injector);
								customInput.contentRef.clear();
								customInput.contentRef.insert(inputRef.hostView);
								inputRef.instance.change.subscribe((newValue: any) => {
									customInput.fieldChange.emit(newValue);
								});
								inputRef.instance.click.subscribe((event: Event) => {
									customInput.fieldClick.emit(event);
								});
							} else {
								this.configureBaseFieldComponent(customField, field);
								this.inputFields.push(customField);
							}
						}
					} else {
						inputRef = this.fieldsContainer.createComponent(
							this.defaultFieldComponentFactory
						);
					}
					if (inputRef) {
						this.configureBaseFieldComponent(inputRef.instance, field);
						this.inputFields.push(inputRef.instance);
					}
				}
			});
			if (this.inputFields) {
				setTimeout(() => {
					this.inputFields[0].focus();
				})
			}
		}
	}

	configureBaseFieldComponent(fieldComponent: RestapiBaseFieldComponent, field: RestapiResourceField) {
		fieldComponent.fieldName = field.name;
		fieldComponent.formGroup = this.formGroup;
		fieldComponent.restapiResource = this.restapiResource;
		fieldComponent.resourceInstance = this.resourceInstance;
		fieldComponent.hideLabel = false;
		fieldComponent.change.subscribe(() => {
			this.anyFieldChanged = true;
			this.formExitGuard.setModified(true);
		});
	}

	processErrors(errorResponse: HttpErrorResponse) {
		if (errorResponse.error.errors) {
			for (let error of errorResponse.error.errors) {
				this.inputFields.forEach((inputField: RestapiBaseFieldComponent) => {
					if (inputField.fieldName === error.field) {
						let fieldErrors = {};
						let defaultErrorMessage = error.defaultMessage ? error.defaultMessage : error.code;
						fieldErrors[error.code] = this.translateKey('error.validation.contraint.' + error.code, undefined, defaultErrorMessage);
						inputField.setErrors(fieldErrors);
					}
				});
			}
			let isFirst = true;
			this.inputFields.forEach((inputField: RestapiBaseFieldComponent) => {
				if (isFirst) {
					inputField.focus();
					isFirst = false;
				}
			});
			this.restapiError = errorResponse;
		} else {
			throw errorResponse;
		}
	}
	resetFieldsValidation() {
		this.inputFields.forEach((inputField: RestapiBaseFieldComponent) => {
			inputField.setErrors({});
		});
	}

	getParent() {
		if (this.config && this.config.parent) {
			return this.config.parent;
		} else {
			return this.parentFromRoute;
		}
	}

	getGridLabel(grid: RestapiResourceGrid) {
		let label: string;
		if (this.config.grids) {
			this.config.grids.forEach(configGrid => {
				if (configGrid.name === grid.name) {
					label = configGrid.label;
				}
			});
		}
		return label ? label : grid.name;
	}

	onTabChanged(event: MdcTabActivatedEvent): void {
		this.activeTab = event.index;
	}

	public isCreacio(): boolean {
		return this.id == null;
	}
	public setParentFromRoute(parentFromRoute: any) {
		this.parentFromRoute = parentFromRoute;
	}

	translateKey(key: string, params?: any, defaultValue?: string) {
		let translatedKey = this.translate.instant(key, params);
		if (defaultValue) {
			return (translatedKey !== key) ? translatedKey : defaultValue;
		} else {
			return translatedKey;
		}
	}

	constructor(
		private factoryResolver: ComponentFactoryResolver,
		private formBuilder: FormBuilder,
		private injector: Injector,
		private http: HttpClient,
		private translate: TranslateService,
		private formExitGuard: RestapiFormExitGuard) {
		this.defaultFieldComponentFactory = this.factoryResolver.resolveComponentFactory(
			//RestapiFieldMdcwebComponent
			RestapiFieldMaterialComponent
		);
		this.formGroup = this.formBuilder.group({});
	}

}
