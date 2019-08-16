import {
    Component,
    Injector,
    OnInit,
    ComponentFactoryResolver,
    EmbeddedViewRef,
    ComponentFactory,
    ComponentRef,
    ViewRef,
    ElementRef,
    Input,
    Output,
    EventEmitter,
    ViewChild,
    ViewContainerRef,
    ViewChildren,
    ContentChildren,
    QueryList
} from '@angular/core';
import {
    HttpClient,
    HttpParams,
    HttpErrorResponse
} from '@angular/common/http';
import { FormBuilder, FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { MdcTabBar, MdcTabActivatedEvent, MdcDialog, MdcDialogComponent, MdcDialogRef } from '@angular-mdc/web';
import { Resource, ResourceHelper } from 'angular4-hal';

import { GenericResource } from '../restapi/restapi-generic.service';
import { RestapiService } from '../restapi/restapi.service';
import {
    RestapiProfile,
    RestapiResourceInfo,
    RestapiResourceField,
    RestapiResourceGrid
} from '../restapi/restapi-profile';
import { RestapiFieldComponent } from './restapi-field.component';
import { RestapiCustomComponent } from './restapi-custom.component';
import { RestapiFormErrorsDialogComponent } from './restapi-form-errors-dialog.component';

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

@Component( {
    selector: 'restapi-form',
    template: `
    <ng-container>
        <!--mdc-top-app-bar
            class="context-app-bar"
            fixed="true"
            prominent="false"
            dense="false">
            <mdc-top-app-bar-row>
                <mdc-top-app-bar-section
                    align="start"
                    title="{{ id ? 'Modificar' : 'Crear' }} {{ restapiResource?.translateKey | translate }}">
                    <mdc-icon mdcTopAppBarActionItem (click)="onButtonCancelClick()">arrow_back</mdc-icon>
                </mdc-top-app-bar-section>
                <mdc-top-app-bar-section align="end">
                    <mdc-icon mdcTopAppBarActionItem (click)="onButtonSaveClick()">save</mdc-icon>
                </mdc-top-app-bar-section>
            </mdc-top-app-bar-row>
        </mdc-top-app-bar-->
        <div class="page-header">
            <div class="header-first-row">
                <div class="mant-headline" mdcHeadline6>
                    <span class="main">{{ restapiResource?.translateKeyPlural | translate }}</span><span class="current"> / {{description ? description : ('component.restapi.form.header.title.crear' | translate)}}</span>
                </div>
                <div class="mant-error">
                    <button mdc-icon-button *ngIf="restapiError" (click)="onErrorIconClick()" icon="error" class="header-button-small" style="color: #de442c"></button>
                </div>
            </div>
            <div class="header-second-row">
                <div class="mant-actions">
                    <div class="mant-actions-main">
                        <a mdc-button dense secondary (click)="onButtonSaveClick()">
                            <mdc-icon>save_alt</mdc-icon>
                            {{'component.restapi.form.header.button.guardar'|translate}}
                        </a>&nbsp;
                        <a mdc-button dense (click)="onButtonCancelClick()">
                            {{'component.restapi.form.header.button.descartar'|translate}}
                        </a>
                    </div>
                    <div class="mant-actions-selection">
                        <div *ngIf="id" mdcMenuSurfaceAnchor #actionsButton>
                            <button mdc-button dense (click)="actionsMenu.open = !actionsMenu.open">
                                <mdc-icon>settings</mdc-icon>
                                <span mdcButtonLabel>{{'component.restapi.form.header.button.actions'|translate}}</span>
                                <mdc-icon>arrow_drop_down</mdc-icon>
                            </button>
                            <mdc-menu #actionsMenu anchorCorner="bottomStart" quickOpen [anchorElement]="actionsButton" (selected)="onActionSelect($event)">
                                <mdc-list>
                                    <mdc-list-item>{{'component.restapi.form.header.action.delete'|translate}}</mdc-list-item>
                                </mdc-list>
                            </mdc-menu>
                        </div>
                    </div>
                </div>
                <div class="mant-controls">
                    <!--span class="mant-page-info">1 / 100</span>
                    &nbsp;
                    <button mdc-icon-button (click)="onItemDownClick()" [disabled]="hasPrevious" class="header-button-small"><mdc-icon>chevron_left</mdc-icon></button>
                    <button mdc-icon-button (click)="onItemUpClick()" [disabled]="hasNext" class="header-button-small"><mdc-icon>chevron_right</mdc-icon></button-->
                </div>
            </div>
        </div>
        <ng-container *ngTemplateOutlet="formTemplate"></ng-container>
    </ng-container>    
    <ng-template #formTemplate>
        <form [mdcElevation]="5" [formGroup]="formGroup">
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
                                parent: resourceInstancePk,
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
    padding: 1em;
    margin: 1em;
}
#form-content {
    margin-top: 1em;
}
#actions {
    display: flex;
    flex-direction: row-reverse;
}
`, `
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
.header-first-row .mant-error {
    flex-basis: 50%;
    text-align: right;
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
.header-second-row .mant-page-info {
    /*padding: 0 1em;*/
}
.header-button-small {
    position: relative;
    top: 6px;
}
.header-button-small mdc-icon {
    position: relative;
    left: -2px;
}
`]
} )
export class RestapiFormComponent implements OnInit {

    @Input() config: FormConfig;
    @Input() restapiService: RestapiService<Resource>;
    @Input() restapiLovServices: RestapiService<Resource>[];
    @Input() id: any;
    @Input()
    set data( data: any ) {
        this.refrescarFormGroup( data );
    }

    @Output() actionSave: EventEmitter<any> = new EventEmitter();
    @Output() actionDelete: EventEmitter<any> = new EventEmitter();
    @Output() actionCancel: EventEmitter<any> = new EventEmitter();
    @Output() resourceChange: EventEmitter<any> = new EventEmitter();

    @ViewChild( 'fieldsContainer', { read: ViewContainerRef, static: false } ) fieldsContainer: ViewContainerRef;
    @ContentChildren( RestapiCustomComponent ) customInputs: QueryList<RestapiCustomComponent>;
    @ViewChild( 'formTabs', { static: false } ) formTabs: MdcTabBar;

    private description: string;
    private resourceInstance: any;
    private resourceInstancePk: any;
    private restapiResource: RestapiResourceInfo;
    private formGroup: FormGroup;
    private inputComponentFactory: ComponentFactory<RestapiFieldComponent>;
    private inputFields: RestapiFieldComponent[];
    private parentFromRoute: any;

    private showTabs: boolean = false;
    private activeTab: number = 0;
    private grids: RestapiResourceGrid[];
    private restapiError: any;
    private isButtonSave: boolean;
    private isUpdateShow: boolean;

    ngOnInit() {
        if ( this.config != undefined ) {
            this.isButtonSave = ( this.config.isButtonSave != undefined && this.config.isButtonSave );
            this.isUpdateShow = ( this.config.isUpdateShow != undefined && this.config.isUpdateShow );
        }
        this.refreshFields();
    }

    onButtonSaveClick() {
        this.resetFieldsValidation();
        let values = {};
        if ( this.resourceInstance ) {
            values = {
                _links: this.resourceInstance._links,
                id: this.resourceInstance.id
            };
        }
        let formGroupValue = this.formGroup.value;
        for ( let property in formGroupValue ) {
            if ( formGroupValue.hasOwnProperty( property ) ) {
                values[property] = formGroupValue[property];
            }
        }
        this.restapiResource.fields.forEach( field => {
            if ( field.type === 'DATETIME' ) {
                let offsetInHours = -( new Date().getTimezoneOffset() / 60 );
                let timezoneOffsetNegative = offsetInHours < 0;
                if ( timezoneOffsetNegative ) {
                    offsetInHours = -offsetInHours;
                }
                let timezoneOffsetStr = ( timezoneOffsetNegative ? '-' : '+' ) + (( offsetInHours < 10 ) ? '0' + offsetInHours : '' + offsetInHours) + ':00';
                values[field.name] = values[field.name] + timezoneOffsetStr;
            } else if ( field.type === 'LOV' ) {
                if ( !values[field.name] || !values[field.name].id ) {
                    delete values[field.name];
                }
            }
        } );
        if ( this.isCreacio() ) {
            let uri = ResourceHelper.getURL() + this.restapiService['resource'];
            let params = new HttpParams( { fromObject: this.getParent() } );
            this.http.post( uri, values, { params: params } ).subscribe(( resource: Resource ) => {
                this.actionSave.emit( resource );
            }, errorResponse => {
                this.processErrors( errorResponse );
            } );
        } else {
            this.restapiService.update( Object.assign( new GenericResource, values ) ).subscribe(( resource: Resource ) => {
                this.refrescarFormGroup( resource );
                this.actionSave.emit( resource );
            }, errorResponse => {
                this.processErrors( errorResponse );
            } );
        }
    }

    onButtonCancelClick() {
        this.actionCancel.emit();
    }

    onActionSelect( event ) {
        if ( event.index == 0 ) {
            let resourceName = this.restapiResource.name;
            let rowData = this.resourceInstance;
            let rowDescription = ( this.restapiResource.descriptionField ) ? rowData[this.restapiResource.descriptionField] : '[id:' + rowData.id + ']';
            let confirmTranslated = this.translateKey(
                'component.restapi.form.delete.confirm',
                { description: resourceName + ' ' + rowDescription } );
            if ( confirm( confirmTranslated ) ) {
                this.restapiService.delete( this.resourceInstance ).subscribe(( resource: Resource ) => {
                    this.actionDelete.emit( resource );
                }/*, errorResponse => {
                    this.processSaveErrors( errorResponse );
                }*/ );
            }
        }
    }

    onErrorIconClick() {
        this.dialog.open( RestapiFormErrorsDialogComponent, {
            escapeToClose: true,
            clickOutsideToClose: true,
            data: {
                error: this.restapiError
            }
        } );
    }

    onItemDownClick() {
        console.log( '>>> onItemDownClick' )
    }
    onItemUpClick() {
        console.log( '>>> onItemUpClick' )
    }

    refreshFields() {
        this.restapiService.whenReady().subscribe(( restapiProfile: RestapiProfile ) => {
            this.restapiResource = restapiProfile.resourceInfo;
            if ( this.restapiResource.grids && this.id ) {
                this.showTabs = true;
                this.grids = this.restapiResource.grids;
            }
            if ( this.id == null ) {
                this.restapiService.get( this.restapiService.generateGetParamsWithParent(
                    'new',
                    this.getParent() ) ).subscribe(
                    ( resourceInstance: Resource ) => {
                        this.refrescarFormGroup( resourceInstance );
                        this.createInputs( this.restapiResource.fields );
                    } );
            } else {
                this.restapiService.get( this.restapiService.generateGetParamsWithParent(
                    this.id,
                    this.getParent() ) ).subscribe(
                    ( resourceInstance: Resource ) => {
                        this.refrescarFormGroup( resourceInstance );
                        this.createInputs( this.restapiResource.fields );
                        this.description = ( this.restapiResource.descriptionField ) ? resourceInstance[this.restapiResource.descriptionField] : '[id:' + this.id + ']';
                    } );
            }
        } );
    }
    createInputs( fields: RestapiResourceField[] ) {
        this.inputFields = [];
        if ( fields && fields.length ) {
            fields.forEach( field => {
                if ( !field.hiddenInForm ) {
                    let inputRef: ComponentRef<RestapiFieldComponent>;
                    if ( this.customInputs && this.customInputs.length ) {
                        let customInput = this.customInputs
                            .toArray()
                            .find( function( customInput ) {
                                return customInput.fieldName === field.name;
                            } );
                        if ( customInput ) {
                            inputRef = this.inputComponentFactory.create( this.injector );
                            customInput.contentRef.clear();
                            customInput.contentRef.insert( inputRef.hostView );
                            inputRef.instance.change.subscribe( newValue => {
                                customInput.fieldChange.emit( newValue );
                            } );
                            inputRef.instance.click.subscribe( event => {
                                customInput.fieldClick.emit( event );
                            } );
                        }
                    } else {
                        inputRef = this.fieldsContainer.createComponent(
                            this.inputComponentFactory
                        );
                    }
                    if ( inputRef ) {
                        inputRef.instance.field = field;
                        inputRef.instance.resource = this.restapiResource;
                        inputRef.instance.formGroup = this.formGroup;
                        if ( this.config.fields ) {
                            this.config.fields.forEach( fieldConfig => {
                                if ( fieldConfig.name === field.name ) {
                                    inputRef.instance.label = fieldConfig.label;
                                }
                            } );
                        }
                        this.inputFields.push( inputRef.instance );
                    }
                }
            } );
        }
    }

    refrescarFormGroup( resourceInstance?: any ) {
        if ( resourceInstance ) {
            this.resourceInstance = resourceInstance;
            this.resourceInstancePk = resourceInstance.pk;
        } else {
            this.resourceInstance = {};
        }
        this.resourceChange.emit( this.resourceInstance );
        this.formGroup = this.restapiService.createFormGroup(
            this.resourceInstance,
            this.restapiResource,
            this.isCreacio()
        );
    }

    processErrors( errorResponse: HttpErrorResponse ) {
        if ( errorResponse.error.errors ) {
            for ( let error of errorResponse.error.errors ) {
                this.inputFields.forEach( inputField => {
                    if ( inputField.field.name === error.field ) {
                        inputField.setValid( false, error.defaultMessage );
                    }
                } );
            }
            let isFirst = true;
            this.inputFields.forEach( inputField => {
                if ( isFirst ) {
                    inputField.focus();
                    isFirst = false;
                }
            } );
            this.restapiError = errorResponse.error;
        } else {
            throw errorResponse;
        }
    }
    resetFieldsValidation() {
        this.inputFields.forEach( inputField => {
            inputField.resetValidation();
        } );
    }

    getParent() {
        if ( this.config && this.config.parent ) {
            return this.config.parent;
        } else {
            return this.parentFromRoute;
        }
    }

    getGridLabel( grid: RestapiResourceGrid ) {
        let label;
        if ( this.config.grids ) {
            this.config.grids.forEach( configGrid => {
                if ( configGrid.name === grid.name ) {
                    label = configGrid.label;
                }
            } );
        }
        return label ? label : grid.name;
    }

    onTabChanged( event: MdcTabActivatedEvent ): void {
        this.activeTab = event.index;
    }

    public isCreacio(): boolean {
        return this.id == null;
    }
    public setParentFromRoute( parentFromRoute: any ) {
        this.parentFromRoute = parentFromRoute;
    }

    translateKey( key: string, params?: any, defaultValue?: string ) {
        let translatedKey = this.translate.instant( key, params );
        if ( defaultValue ) {
            return ( translatedKey !== key ) ? translatedKey : defaultValue;
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
        private dialog: MdcDialog ) {
        this.inputComponentFactory = this.factoryResolver.resolveComponentFactory(
            RestapiFieldComponent
        );
        this.formGroup = this.formBuilder.group( {} );
    }

}
