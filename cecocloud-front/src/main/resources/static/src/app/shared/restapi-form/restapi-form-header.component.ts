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
import { DefaultErrorHandler } from '../default-error-handler';
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
<div class="form-header">
    <mdc-top-app-bar-row>
        <mdc-top-app-bar-section align="start" >
            <button mdcTopAppBarNavIcon (click)="onButtonCancelClick()">
                <mdc-icon>arrow_back</mdc-icon>
            </button>
            <button mdc-icon-button *ngIf="restapiError" class="mdc-icon-button-sm" (click)="onErrorIconClick()" style="color:#de442c">
                <mdc-icon>warning</mdc-icon>
            </button>
            <span class="header-title">{{title}}: {{description ? description : ('component.restapi.form.header.title.crear' | translate)}}</span>
        </mdc-top-app-bar-section>
        <mdc-top-app-bar-section align="end">
            <button mdc-icon-button class="mdc-icon-button-sm" title="{{'component.restapi.form.header.button.guardar'|translate}}" (click)="onButtonSaveClick()">
                <mdc-icon>save_alt</mdc-icon>
            </button>
            <button mdc-icon-button class="mdc-icon-button-sm" *ngIf="id" title="{{'component.restapi.form.header.action.delete'|translate}}" (click)="onButtonDeleteClick()">
                <mdc-icon>delete</mdc-icon>
            </button>
        </mdc-top-app-bar-section>
    </mdc-top-app-bar-row>
</div>
`,
    styles: [`
.form-header {
    background-color: #f2f2f2;
    color: rgba(0, 0, 0, 0.54);
    border-bottom: 1px solid #e2e2e2;
}
.header-title {
    font-size: 1.25rem;
    line-height: 2rem;
    font-weight: 500;
    letter-spacing: 0.0125em;
}
`]
} )
export class RestapiFormHeaderComponent {

    @Input() id: any;
    @Input() description: string;
    @Input()
    set restapiResource( restapiResource: RestapiResource ) {
        if ( restapiResource ) {
            this.title = this.translateKey( restapiResource.translateKey );
        }
    }
    @Input() restapiError: Error;

    @Output() actionSave: EventEmitter<any> = new EventEmitter();
    @Output() actionCancel: EventEmitter<any> = new EventEmitter();
    @Output() actionDelete: EventEmitter<any> = new EventEmitter();

    private title: string;
    private mobileScreen;

    onButtonSaveClick() {
        this.actionSave.emit();
    }

    onButtonCancelClick() {
        this.actionCancel.emit();
    }

    onButtonDeleteClick() {
        this.actionDelete.emit();
    }

    onActionSelect( event ) {
        if ( event.index == 0 ) {
            this.actionDelete.emit();
        }
    }

    onErrorIconClick() {
        this.defaultErrorHandler.handleError( this.restapiError );
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
        private screenSizeService: ScreenSizeService,
        private defaultErrorHandler: DefaultErrorHandler ) {
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}
