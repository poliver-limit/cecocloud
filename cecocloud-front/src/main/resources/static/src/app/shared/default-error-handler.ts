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
            this.showError( code, title, error, message, timestamp, trace );
        } else {
            // Handle Client Error (Angular Error, ReferenceError...)
            if ( !navigator.onLine ) {
                title = 'No Internet Connection';
            } else {
                title = error.message ? error.message : error.toString();
            }
            this.showError( error.name, title, error, null, null, error.stack );
            throw error;
        }
    }

    showError( code: string, title: string, error: Error, message?: string, timestamp?: string, stack?: string ) {
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
<mdc-dialog>
  <mdc-dialog-container>
    <mdc-dialog-surface>
      <mdc-dialog-title>[{{data.code}}] {{data.title}}</mdc-dialog-title>
      <mdc-dialog-content>
        <p>{{data.message}}</p>
      </mdc-dialog-content>
      <mdc-dialog-actions>
        <button mdcDialogButton mdcDialogAction="close">Tancar</button>
      </mdc-dialog-actions>
    </mdc-dialog-surface>
  </mdc-dialog-container>
</mdc-dialog>`
} )
export class DefaultErrorDialog {

    constructor(
        @Inject( MDC_DIALOG_DATA ) private data: any ) {
        this.data = data;
    }

}