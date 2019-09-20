import { Component, ErrorHandler, Injectable, Injector, Inject, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { HttpErrorResponse } from '@angular/common/http';
import { MdcDialog, MdcDialogRef, MDC_DIALOG_DATA } from '@angular-mdc/web';

@Injectable( {
    providedIn: 'root'
} )
export class DefaultErrorHandler implements ErrorHandler {

    handleError( error: any ) {
        if ( error.message.indexOf( 'ChunkLoadError' ) != -1 || !navigator.onLine ) {
            this.showDialogError( null, 'Error de connexió', error, this.translate.instant( 'error.dialog.no.connexio' ) );
        } else if ( error instanceof HttpErrorResponse ) {
            // Server or connection error happened
            let title = error.error ? error.error.error : error.message;
            let code = error.error ? error.error.status : error.name;
            let message = error.error ? error.error.message : undefined;
            let timestamp = error.error ? error.error.timestamp : undefined;
            let trace = error.error ? error.error.trace : undefined;
            this.showDialogError( code, title, <Error>error, message, timestamp, trace );
        } else {
            this.showDialogError( null, 'Error', error, error.message, error.timestamp, error.stack );
        }
        if (error.stack ) {
            throw error;
        }
    }

    showDialogError( code: string, title: string, error: Error, message?: string, timestamp?: string, stack?: string ) {
        const dialog = this.injector.get( MdcDialog );
        const dialogRef = dialog.open( DefaultErrorDialog, {
            data: {
                code: code,
                title: title,
                message: message,
                stack: stack,
                timestamp: timestamp,
                error: error
            }
        } );
        /*dialogRef.afterClosed().subscribe( result => {
            console.log( result );
        } );*/
    }

    constructor(
        private injector: Injector,
        private translate: TranslateService ) {
    }

}

@Component( {
    template: `
<mdc-dialog class="default-error-dialog">
    <mdc-dialog-container>
        <mdc-dialog-surface>
            <mdc-dialog-title><mdc-icon class="text-icon error">warning</mdc-icon>&nbsp;<span *ngIf="data.code">[{{data.code}}] </span>{{data.title}}</mdc-dialog-title>
            <mdc-dialog-content>
                <mdc-tab-bar *ngIf="tabsCount > 1" (activated)="onActivatedTab($event)" [activeTabIndex]="0" useAutomaticActivation>
                    <mdc-tab-scroller>
                        <mdc-tab id="message" *ngIf="data.message" label="{{'error.dialog.tab.info'|translate}}"></mdc-tab>
                        <mdc-tab id="fields" *ngIf="data.error.error?.errors" label="{{'error.dialog.tab.fields'|translate}}"></mdc-tab>
                        <mdc-tab id="trace" *ngIf="data.stack" label="{{'error.dialog.tab.trace'|translate}}"></mdc-tab>
                    </mdc-tab-scroller>
                </mdc-tab-bar>
                <mdc-list *ngIf="activeTabId == 'message'" twoLine>
                    <p>{{data.message}}</p>
                    <!--mdc-list-item>
                        <mdc-list-item-text [secondaryText]="data.message">{{'error.dialog.field.message'|translate}}</mdc-list-item-text>
                    </mdc-list-item-->
                    <mdc-list-item *ngIf="data.timestamp">
                        <mdc-list-item-text [secondaryText]="data.timestamp">{{'error.dialog.field.timestamp'|translate}}</mdc-list-item-text>
                    </mdc-list-item>
                </mdc-list>
                <mdc-textarea *ngIf="activeTabId == 'trace'" fullwidth rows="8" [value]="data.stack"></mdc-textarea>
                <mdc-list *ngIf="activeTabId == 'fields'" twoLine>
                    <mdc-list-item *ngFor="let fieldError of data.error.error.errors">
                        <mdc-list-item-text secondaryText="{{fieldError.defaultMessage}}">{{fieldError.field}} ({{fieldError.code}})</mdc-list-item-text>
                    </mdc-list-item>
                </mdc-list>
            </mdc-dialog-content>
            <mdc-dialog-actions>
                <button mdcDialogButton mdcDialogAction="close">{{'error.dialog.button.close'|translate}}</button>
            </mdc-dialog-actions>
        </mdc-dialog-surface>
    </mdc-dialog-container>
</mdc-dialog>`,
    styles: [`
mdc-icon.text-icon {
    position: relative;
    top: 6px;
}
mdc-icon.error {
    color: #de442c
}
mdc-textarea {
    margin-top: 16px;
    width: 752px;
}
`]
} )
export class DefaultErrorDialog {

    activeTabId: string;
    tabsCount: number = 0;

    onActivatedTab( event ) {
        this.activeTabId = event.tab.id;
    }

    constructor(
        @Inject( MDC_DIALOG_DATA ) public data: any ) {
        this.data = data;
        if ( data.stack ) {
            this.activeTabId = 'trace';
            this.tabsCount++;
        }
        if ( data.error && data.error.error && data.error.error.errors ) {
            this.activeTabId = 'fields';
            this.tabsCount++;
        }
        if ( data.message ) {
            this.activeTabId = 'message';
            this.tabsCount++;
        }
    }

}