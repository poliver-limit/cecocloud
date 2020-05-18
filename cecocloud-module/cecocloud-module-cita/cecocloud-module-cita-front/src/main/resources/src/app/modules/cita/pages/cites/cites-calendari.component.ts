import { Injectable, Component } from '@angular/core';
import { formatDate } from '@angular/common';
import { Subject } from 'rxjs';
import { HalParam } from '@lagoshny/ngx-hal-client';
import { CalendarDateFormatter, CalendarAngularDateFormatter, DateFormatterParams, CalendarEvent, CalendarEventTimesChangedEvent, CalendarView } from 'angular-calendar';

import { PuntsVendaService } from './puntsVenda.service';
import { CitesService } from './cites.service';

@Injectable()
export class CustomDateFormatter extends CalendarAngularDateFormatter {

	public weekViewHour({ date, locale }: DateFormatterParams): string {
		return formatDate(date, 'HH:mm', locale);
	}

}

@Component({
	template: `
    <bng-header>
		<span>Cites</span>&nbsp;<span>{{ viewDate | calendarDate:(view + 'ViewTitle') }}</span>
		<span class="toolbar-fill"></span>
		<button *ngIf="puntsVenda" mat-icon-button mwlCalendarPreviousView [view]="view" [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>arrow_back_ios</mat-icon></button>
		<button *ngIf="puntsVenda" mat-icon-button mwlCalendarToday [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>my_location</mat-icon></button>
		<button *ngIf="puntsVenda" mat-icon-button mwlCalendarNextView [view]="view" [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>arrow_forward_ios</mat-icon></button>
	</bng-header>
	<mwl-calendar-week-view
		*ngIf="puntsVenda"
		[weekStartsOn]="1"
		[dayStartHour]="9"
		[dayStartMinute]="0"
		[dayEndHour]="20"
		[dayEndMinute]="0"
		[hourSegments]="4"
		[hourSegmentHeight]="100"
    	[viewDate]="viewDate"
    	[events]="events"
    	[refresh]="refresh"
    	(eventClicked)="handleEvent('Clicked', $event.event)"
    	(eventTimesChanged)="eventTimesChanged($event)"></mwl-calendar-week-view>`,
	styles: [`
.toolbar-fill {
	flex: 1 1 auto;
}
`],
	providers: [{
		provide: CalendarDateFormatter,
		useClass: CustomDateFormatter,
	}]
})
export class CitesCalendariComponent {

	startTime: string = '09:00';
	endTime: string = '20:00';
	view: CalendarView = CalendarView.Week;
	viewDate: Date = new Date();
	events: CalendarEvent[] = [];
	refresh: Subject<any> = new Subject();
	puntsVenda: any[];

	onViewDateChange() {
		this.refreshCites(this.puntsVenda[0]);
	}

	handleEvent(action: string, event: CalendarEvent): void {
		console.log('>>> handleEvent');
		/*this.modalData = { event, action };
		this.modal.open(this.modalContent, { size: 'lg' });*/
	}

	eventTimesChanged({ event, newStart, newEnd }: CalendarEventTimesChangedEvent): void {
		console.log('>>> eventTimesChanged');
		this.events = this.events.map((iEvent) => {
			if (iEvent === event) {
				return {
					...event,
					start: newStart,
					end: newEnd,
				};
			}
			return iEvent;
		});
		this.handleEvent('Dropped or resized', event);
	}

	refreshCites(puntVenda: any) {
		this.events = [];
		let dataInicial: string = this.viewDate.toISOString().split('T')[0] + 'T00:00:00';
		let d: Date = new Date();
		d.setDate(this.viewDate.getDate() + 7);
		let dataFinal: string = d.toISOString().split('T')[0] + 'T23:59:59';
		const requestParams: HalParam[] = [];
		requestParams.push({
			key: 'query',
			value: 'puntVenda.codi==' + puntVenda.codi + ';data=ge=' + dataInicial + ';data=le=' + dataFinal
		});
		this.citesService.whenReady().subscribe(() => {
			this.citesService.getAll({params: requestParams}).subscribe(cites => {
				cites.forEach((cita: any) => {
					let start: Date = new Date(cita.data);
					let end: Date = new Date(start.getTime() + puntVenda.citaIntervalMinuts * 60000);
					this.events.push({
						start: start,
						end: end,
						title: cita.llinatges + ', ' + cita.nom
					});
				});
				this.refresh.next();
			});
		});
	}

	constructor(
		public puntsVendaService: PuntsVendaService,
		public citesService: CitesService) {
		const requestParams: HalParam[] = [];
		requestParams.push({
			key: 'query',
			value: 'citaActiva==true'
		});
		this.puntsVendaService.whenReady().subscribe(() => {
			this.puntsVendaService.getAll({params: requestParams}).subscribe(puntsVenda => {
				this.puntsVenda = puntsVenda;
				if (puntsVenda && puntsVenda.length) {
					this.refreshCites(puntsVenda[0]);
				}
			});
		});
	}

}