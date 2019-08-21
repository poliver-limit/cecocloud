import {
    Component,
    Injector,
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
    RestapiResource,
    RestapiResourceField,
    RestapiResourceGrid
} from '../restapi/restapi-profile';
import { RestapiFormErrorsDialogComponent } from './restapi-form-errors-dialog.component';
import { ScreenSizeService, ScreenSizeChangeEvent } from '../screen-size.service';

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
    selector: 'restapi-form-header',
    template: `
<!--mdc-top-app-bar
    class="context-app-bar"
    fixed="true"
    prominent="false"
    dense="false">
    <mdc-top-app-bar-row>
        <mdc-top-app-bar-section
            align="start"
            title="{{title}}">
            <mdc-icon mdcTopAppBarActionItem (click)="onButtonCancelClick()">arrow_back</mdc-icon>
        </mdc-top-app-bar-section>
        <mdc-top-app-bar-section align="end">
            <mdc-icon mdcTopAppBarActionItem (click)="onButtonSaveClick()">save</mdc-icon>
        </mdc-top-app-bar-section>
    </mdc-top-app-bar-row>
</mdc-top-app-bar-->
<div class="page-header">
    <div class="header-first-row">
        <div class="mant-goback" *ngIf="smallScreen">
            <button mdc-icon-button (click)="onButtonCancelClick()" class="header-button-small"><mdc-icon>arrow_back</mdc-icon></button>
        </div>
        <div class="mant-headline" mdcHeadline6>
            <span class="main">{{ title }}</span><span class="current"> / {{description ? description : ('component.restapi.form.header.title.crear' | translate)}}</span>
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
                    <span mdcButtonLabel>{{'component.restapi.form.header.button.guardar'|translate}}</span>
                </a>&nbsp;
                <a mdc-button dense *ngIf="!smallScreen" (click)="onButtonCancelClick()">
                    <mdc-icon>arrow_back</mdc-icon>
                    <span mdcButtonLabel>{{'component.restapi.form.header.button.descartar'|translate}}</span>
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
        <!--div class="mant-controls">
            <span class="mant-page-info">1 / 100</span>
            &nbsp;
            <button mdc-icon-button (click)="onItemDownClick()" [disabled]="hasPrevious" class="header-button-small"><mdc-icon>chevron_left</mdc-icon></button>
            <button mdc-icon-button (click)="onItemUpClick()" [disabled]="hasNext" class="header-button-small"><mdc-icon>chevron_right</mdc-icon></button>
        </div-->
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
.page-header .header-first-row {
    display: flex;
    padding-top: 8px;
}
.page-header .header-first-row .mant-goback {
    flex-grow: 0;
    margin-right: 6px;
    position: relative;
    top: -6px;
}
.page-header .header-first-row .mant-headline {
    flex-grow: 1;
    color: #999 !important;
}
.page-header .header-first-row .mant-headline span.main {
    color: $mdc-theme-secondary;
}
.page-header .header-first-row .mant-headline span.current {
    color: $mdc-theme-on-surface;
}
.page-header .header-first-row .mant-error {
    text-align: right;
}
.page-header .header-second-row {
    display: flex;
    padding-top: 6px;
}
.page-header .header-second-row .mant-actions {
    flex-grow: 1;
    display: flex;
    justify-content: space-between;
}
.page-header .header-second-row .mant-actions-main {
    flex-grow: 1;
    text-align: left;
}
.page-header .header-second-row .mant-actions-selection {
    flex-grow: 1;
    text-align: right;
}
.page-header .header-second-row .mant-controls {
    flex-grow: 1;
    position: relative;
    top: -5px;
}
.page-header .header-second-row .mant-page-info {
    /*padding: 0 1em;*/
}
.page-header .header-button-small {
    position: relative;
    top: 6px;
}
.page-header .header-button-small mdc-icon {
    position: relative;
    left: -2px;
}
`]
} )
export class RestapiFormHeaderComponent {

    @Input() id: any;
    @Input() description: string;
    @Input()
    set restapiResource( restapiResource: RestapiResource ) {
        if ( restapiResource ) {
            this.title = this.translateKey( restapiResource.translateKeyPlural );
        }
    }
    @Input() restapiError: RestapiResource;

    @Output() actionSave: EventEmitter<any> = new EventEmitter();
    @Output() actionCancel: EventEmitter<any> = new EventEmitter();
    @Output() actionDelete: EventEmitter<any> = new EventEmitter();

    private title: string;
    private smallScreen: boolean = false;

    onButtonSaveClick() {
        this.actionSave.emit();
    }

    onButtonCancelClick() {
        this.actionCancel.emit();
    }

    onActionSelect( event ) {
        if ( event.index == 0 ) {
            this.actionDelete.emit();
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

    translateKey( key: string, params?: any, defaultValue?: string ) {
        let translatedKey = this.translate.instant( key, params );
        if ( defaultValue ) {
            return ( translatedKey !== key ) ? translatedKey : defaultValue;
        } else {
            return translatedKey;
        }
    }

    constructor(
        private translate: TranslateService,
        private dialog: MdcDialog,
        private screenSizeService: ScreenSizeService ) {
        this.smallScreen = this.screenSizeService.isSmall();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.smallScreen = event.small
        } );
    }

}
