import { Component, ErrorHandler, Injectable, Injector, Inject } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { MdcDialog, MdcDialogRef, MDC_DIALOG_DATA } from '@angular-mdc/web';

@Injectable( {
    providedIn: 'root'
} )
export class DefaultErrorHandler implements ErrorHandler {

    handleError( error: Error ) {
        let title;
        if ( error instanceof HttpErrorResponse ) {
            // Server or connection error happened
            if ( !navigator.onLine ) {
                title = 'No Internet Connection';
            } else {
                title = error.error ? error.error.error : error.message;
            }
            let code = error.error ? error.error.status : error.name;
            let message = error.error ? error.error.message : undefined;
            let timestamp = error.error ? error.error.timestamp : undefined;
            let trace = error.error ? error.error.trace : undefined;
            this.showDialogError( code, title, error, message, timestamp, trace );
        } else {
            // Handle Client Error (Angular Error, ReferenceError...)
            if ( !navigator.onLine ) {
                title = 'No Internet Connection';
            } else {
                title = error.message ? error.message : error.toString();
            }
            this.showDialogError( error.name, title, error, null, null, error.stack );
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

    constructor( private injector: Injector ) { }

}

@Component( {
    template: `
<mdc-dialog class="default-error-dialog">
    <mdc-dialog-container>
        <mdc-dialog-surface>
            <mdc-dialog-title><mdc-icon class="text-icon error">warning</mdc-icon> [{{data.code}}] {{data.title}}</mdc-dialog-title>
            <mdc-dialog-content>
                <mdc-tab-bar (activated)="onActivatedTab($event)" [activeTabIndex]="0" useAutomaticActivation>
                    <mdc-tab-scroller>
                        <mdc-tab id="message" *ngIf="data.message" label="{{'error.dialog.tab.info'|translate}}"></mdc-tab>
                        <mdc-tab id="fields" *ngIf="data.error.error.errors" label="{{'error.dialog.tab.fields'|translate}}"></mdc-tab>
                        <mdc-tab id="trace" *ngIf="data.stack" label="{{'error.dialog.tab.trace'|translate}}"></mdc-tab>
                    </mdc-tab-scroller>
                </mdc-tab-bar>
                <mdc-list *ngIf="activeTabId == 'message'" twoLine>
                    <mdc-list-item>
                        <mdc-list-item-text [secondaryText]="data.message">{{'error.dialog.field.message'|translate}}</mdc-list-item-text>
                    </mdc-list-item>
                    <mdc-list-item>
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

    private activeTabId: string;

    onActivatedTab( event ) {
        this.activeTabId = event.tab.id;
    }

    constructor(
        @Inject( MDC_DIALOG_DATA ) private data: any ) {
        this.data = data;
    }

}