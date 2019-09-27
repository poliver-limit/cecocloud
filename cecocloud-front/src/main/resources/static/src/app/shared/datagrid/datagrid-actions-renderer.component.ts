import { Component } from '@angular/core';
import { ICellRendererAngularComp } from "ag-grid-angular";

@Component({
	template: `
	<button *ngFor="let action of actions" mdc-icon-button class="mdc-icon-button-xs" (click)="onActionClick($event, action.name)" style="position: relative;left: -22px;">
        <mdc-icon>{{action.icon}}</mdc-icon>
    </button>`
})
export class DatagridActionsRendererComponent implements ICellRendererAngularComp {

	params: any;
	actions: any[] = [{
		name: 'delete',
		icon: 'delete'
	}];

	agInit(params: any): void {
		this.params = params;
	}

	refresh(): boolean {
		return false;
	}

	onActionClick(event: Event, actionName: string) {
		event.stopPropagation();
		event.preventDefault();
		this.params.api['gridOptionsWrapper'].gridOptions.context.gridComponent.onRowActionClicked(
			this.params.api,
			actionName,
			this.params.rowIndex);
	}

}