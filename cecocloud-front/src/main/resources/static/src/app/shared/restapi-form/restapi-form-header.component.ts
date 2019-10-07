import { Component, Input, Output, EventEmitter } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

import { RestapiResource } from '../restapi/restapi-profile';
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
<div class="form-header" [ngClass]="{'form-header-mobile': mobileScreen, 'form-header-desktop': !mobileScreen}">
    <mdc-top-app-bar-row>
        <mdc-top-app-bar-section align="start" >
            <button mdcTopAppBarNavIcon (click)="onButtonCancelClick()">
                <mdc-icon>arrow_back</mdc-icon>
            </button>
            <button mdc-icon-button *ngIf="restapiError" class="mdc-icon-button-sm" (click)="onErrorIconClick()" style="color:#de442c">
                <mdc-icon>warning</mdc-icon>
            </button>
            <span class="header-title" *ngIf="title">{{title}} / {{id ? ('component.restapi.form.header.title.modificar' | translate) : ('component.restapi.form.header.title.crear' | translate)}}</span>
        </mdc-top-app-bar-section>
        <mdc-top-app-bar-section align="end">
            <button mdc-icon-button
                *ngIf="hasSavePermission"
                title="{{'component.restapi.form.header.button.guardar'|translate}}"
                class="mdc-icon-button-sm"
                (click)="onButtonSaveClick()">
                <mdc-icon>save_alt</mdc-icon>
            </button>
            <button mdc-icon-button
                *ngIf="hasSavePermission"
                title="{{'component.restapi.form.header.button.desfer'|translate}}"
                class="mdc-icon-button-sm"
                [disabled]="!anyFieldChanged"
                (click)="onButtonUndoClick()">
                <mdc-icon>undo</mdc-icon>
            </button>
            <button mdc-icon-button 
                *ngIf="id && hasDeletePermission"
                title="{{'component.restapi.form.header.action.delete'|translate}}"
                class="mdc-icon-button-sm"
                (click)="onButtonDeleteClick()">
                <mdc-icon>delete</mdc-icon>
            </button>
        </mdc-top-app-bar-section>
    </mdc-top-app-bar-row>
</div>
`,
    styles: [`
.form-header {
    border-bottom: 1px solid #e2e2e2;
}
.form-header-desktop {
    background-color: #f2f2f2;
    color: rgba(0, 0, 0, 0.54);
}
.form-header-mobile {
    background-color: var(--mdc-theme-primary, #6200ee);
    color: white;
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
            this.hasCreatePermission = restapiResource.hasCreatePermission;
            this.hasReadPermission = restapiResource.hasReadPermission;
            this.hasUpdatePermission = restapiResource.hasUpdatePermission;
            this.hasDeletePermission = restapiResource.hasDeletePermission;
            this.hasSavePermission = ( this.id ) ? restapiResource.hasUpdatePermission : restapiResource.hasCreatePermission;
        }
    }
    @Input() restapiError: Error;
    @Input() anyFieldChanged: boolean;

    @Output() actionSave: EventEmitter<any> = new EventEmitter();
    @Output() actionCancel: EventEmitter<any> = new EventEmitter();
    @Output() actionUndo: EventEmitter<any> = new EventEmitter();
    @Output() actionDelete: EventEmitter<any> = new EventEmitter();

    title: string;
    hasCreatePermission: boolean;
    hasReadPermission: boolean;
    hasUpdatePermission: boolean;
    hasDeletePermission: boolean;
    hasSavePermission: boolean;
    mobileScreen: boolean;

    onButtonCancelClick() {
        this.actionCancel.emit();
    }

    onButtonSaveClick() {
        this.actionSave.emit();
    }

    onButtonUndoClick() {
        this.actionUndo.emit();
    }

    onButtonDeleteClick() {
        this.actionDelete.emit();
    }

    onActionSelect( event: any ) {
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
        private screenSizeService: ScreenSizeService,
        private defaultErrorHandler: DefaultErrorHandler ) {
        this.mobileScreen = this.screenSizeService.isMobile();
        this.screenSizeService.getScreenSizeChangeSubject().subscribe(( event: ScreenSizeChangeEvent ) => {
            this.mobileScreen = event.mobile
        } );
    }

}
