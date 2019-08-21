import { Component, Inject } from '@angular/core';
import { MdcTabBar, MdcTabActivatedEvent, MDC_DIALOG_DATA } from '@angular-mdc/web';

@Component( {
    template: `
<mdc-dialog class="restapi-lov-dialog">
    <mdc-dialog-container>
        <mdc-dialog-surface>
            <mdc-dialog-title><mdc-icon style="color: #de442c">error</mdc-icon> [{{error.status}}] {{error.error}}</mdc-dialog-title>
            <mdc-dialog-content>
                <mdc-tab-bar *ngIf="error.errors" (activated)="onActivatedTab($event)" [activeTabIndex]="0" useAutomaticActivation>
                    <mdc-tab-scroller>
                        <mdc-tab label="Global"></mdc-tab>
                        <mdc-tab label="Camps"></mdc-tab>
                    </mdc-tab-scroller>
                </mdc-tab-bar>
                <div #tabContentGlobal *ngIf="tabIndex === 0">
                    <mdc-list twoLine>
                        <mdc-list-item>
                            <mdc-list-item-text [secondaryText]="error.message">Message</mdc-list-item-text>
                        </mdc-list-item>
                        <mdc-list-item>
                            <mdc-list-item-text [secondaryText]="error.timestamp">Timestamp</mdc-list-item-text>
                        </mdc-list-item>
                        <mdc-list-item>
                            <mdc-list-item-text [secondaryText]="error.trace">Trace</mdc-list-item-text>
                        </mdc-list-item>
                    </mdc-list>
                </div>
                <div #tabContentFields *ngIf="tabIndex === 1">
                    <ul class="list-group">
                        <li class="list-group-item" *ngFor="let fieldError of error.errors">
                            <div class="d-flex w-100 justify-content-between">
                                <h4 class="mb-1">{{fieldError.field}}</h4>
                                <small>{{fieldError.code}}</small>
                            </div>
                            <p class="mb-1 pl-4">
                                {{fieldError.defaultMessage}}
                            </p>
                        </li>
                    </ul>
                </div>
            </mdc-dialog-content>
            <mdc-dialog-actions>
                <button
                    mdcDialogButton
                    mdcDialogAction="close">Tancar</button>
            </mdc-dialog-actions>
        </mdc-dialog-surface>
    </mdc-dialog-container>
</mdc-dialog>`
} )
export class RestapiFormErrorsDialogComponent {

    private error: any;
    private tabIndex: number;

    onActivatedTab( event ) {
        this.tabIndex = event.index;
    }

    constructor( @Inject( MDC_DIALOG_DATA ) public data ) {
        this.error = data.error;
        if ( !data.error.errors ) {
            this.tabIndex = 0;
        }
    }

}