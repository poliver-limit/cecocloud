import { Injectable, Component, Inject } from '@angular/core';
import { formatDate } from '@angular/common';
import { Subject } from 'rxjs';
import { HalParam } from '@lagoshny/ngx-hal-client';
import { CalendarDateFormatter, CalendarAngularDateFormatter, DateFormatterParams, CalendarEvent, CalendarView, getWeekViewPeriod } from 'angular-calendar';
import { startOfWeek, endOfWeek } from 'date-fns';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { PuntsVendaService } from './puntsVenda.service';
import { CitesService } from './cites.service';

@Injectable()
export class CustomDateFormatter extends CalendarAngularDateFormatter {

	public weekViewColumnSubHeader({ date, locale }: DateFormatterParams): string {
		return formatDate(date, 'd MMM', locale);
	}

	public weekViewTitle({ date, locale, weekStartsOn, excludeDays, daysInWeek }: DateFormatterParams): string {
		const { viewStart, viewEnd } = getWeekViewPeriod(
		  this.dateAdapter,
		  date,
		  weekStartsOn ? weekStartsOn : 1,
		  excludeDays,
		  daysInWeek
		);
		const format = (dateToFormat: Date, showYear: boolean) =>
		  formatDate(dateToFormat, 'd MMM' + (showYear ? ', yyyy' : ''), locale);
		return `${format(
		  viewStart,
		  viewStart.getUTCFullYear() !== viewEnd.getUTCFullYear()
		)} - ${format(viewEnd, true)}`;
	}

	public weekViewHour({ date, locale }: DateFormatterParams): string {
		return formatDate(date, 'HH:mm', locale);
	}

}

@Component({
	template: `
    <bng-header>
		<span>Cites</span>&nbsp;
		<span class="toolbar-fill"></span>
		<button *ngIf="puntsVenda" mat-icon-button mwlCalendarPreviousView [view]="view" [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>arrow_back_ios</mat-icon></button>
		<span>{{ viewDate | calendarDate:(view + 'ViewTitle') }}</span>
		<button *ngIf="puntsVenda" mat-icon-button mwlCalendarToday [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>gps_fixed</mat-icon></button>
		<button *ngIf="puntsVenda" mat-icon-button mwlCalendarNextView [view]="view" [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>arrow_forward_ios</mat-icon></button>
		<mat-form-field *ngIf="puntsVenda" style="width: 30%; top: 14px; margin-left: 1em">
			<mat-select [(value)]="puntVendaSelectedCodi" (selectionChange)="refreshCites()">
				<mat-option *ngFor="let puntVenda of puntsVenda" [value]="puntVenda.codi">{{puntVenda.nom}}</mat-option>
			</mat-select>
		</mat-form-field>
	</bng-header>
	<mwl-calendar-week-view
		*ngIf="showCalendar"
		[weekStartsOn]="weekStartsOn"
		[dayStartHour]="dayStartHour"
		[dayStartMinute]="dayStartMinute"
		[dayEndHour]="dayEndHour"
		[dayEndMinute]="dayEndMinute"
		[hourSegments]="4"
		[hourSegmentHeight]="100"
    	[viewDate]="viewDate"
    	[events]="events"
    	[refresh]="refresh"
    	(eventClicked)="handleEvent('Clicked', $event.event)"></mwl-calendar-week-view>`,
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

	view: CalendarView = CalendarView.Week;
	viewDate: Date = new Date();
	weekStartsOn: number = 1;
	dayStartHour: number;
	dayStartMinute: number;
	dayEndHour: number;
	dayEndMinute: number;
	events: CalendarEvent[] = [];
	refresh: Subject<any> = new Subject();
	puntsVenda: any[];
	puntVendaSelectedCodi: string;
	showCalendar: boolean;

	onViewDateChange() {
		this.refreshCites();
	}

	handleEvent(action: string, event: CalendarEvent): void {
		/*const dialogRef = */this.dialog.open(CitesCalendariDetailDialog, {
			width: '600px',
			data: { cita: event.meta }
		});
		/*dialogRef.afterClosed().subscribe(result => {
			console.log('The dialog was closed');
			this.animal = result;
		});*/
		/*this.modalData = { event, action };
		this.modal.open(this.modalContent, { size: 'lg' });*/
	}

	refreshCites() {
		this.showCalendar = false;
		let puntVenda = this.puntsVenda.find(puntVenda => {return puntVenda.codi === this.puntVendaSelectedCodi});
		let dataInici: Date = startOfWeek(this.viewDate, { weekStartsOn: <any>this.weekStartsOn });
		let dataFi: Date = endOfWeek(this.viewDate, { weekStartsOn: <any>this.weekStartsOn })
		this.events = [];
		this.puntsVendaService.rangHorari(puntVenda.id, dataInici, dataFi).subscribe((rang: any) => {
			if (rang && rang.horaInici) {
				this.dayStartHour = parseInt(rang.horaInici.split(':')[0]);
				this.dayStartMinute = parseInt(rang.horaInici.split(':')[1]);
			}
			if (rang && rang.horaFi) {
				this.dayEndHour = parseInt(rang.horaFi.split(':')[0]);
				this.dayEndMinute = parseInt(rang.horaFi.split(':')[1]);
			}
			const requestParams: HalParam[] = [];
			let dataInicial: string = dataInici.toISOString().split('T')[0] + 'T00:00:00';
			let dataFinal: string = dataFi.toISOString().split('T')[0] + 'T23:59:59';
			requestParams.push({
				key: 'query',
				value: 'puntVenda.codi==' + puntVenda.codi + ';data=ge=' + dataInicial + ';data=le=' + dataFinal
			});
			this.citesService.whenReady().subscribe(() => {
				this.citesService.getAll({ params: requestParams }).subscribe(cites => {
					cites.forEach((cita: any) => {
						let start: Date = new Date(cita.data);
						let end: Date = new Date(start.getTime() + puntVenda.citaIntervalMinuts * 60000);
						let hora: string = new Date(cita.data).toTimeString().split(' ')[0];
						let event: CalendarEvent = {
							start: start,
							end: end,
							title: hora.substring(0, hora.lastIndexOf(':')) + ' ' + cita.llinatges + ', ' + cita.nom,
							meta: cita
						};
						if (cita.anulacioData) {
							event.color =  {
								primary: '#ad2121',
								secondary: '#fae3e3'
							};
						}
						this.events.push(event);
					});
					//this.refresh.next();
					this.showCalendar = true;
				});
			});
		});
	}

	constructor(
		public puntsVendaService: PuntsVendaService,
		public citesService: CitesService,
		public dialog: MatDialog) {
		const requestParams: HalParam[] = [];
		requestParams.push({
			key: 'query',
			value: 'citaActiva==true'
		});
		this.puntsVendaService.whenReady().subscribe(() => {
			this.puntsVendaService.getAll({ params: requestParams }).subscribe((puntsVenda: any) => {
				this.puntsVenda = puntsVenda;
				if (puntsVenda && puntsVenda.length) {
					this.puntVendaSelectedCodi = puntsVenda[0].codi;
					this.refreshCites();
				}
			});
		});
	}

}

@Component({
	template: `
<h1 mat-dialog-title>{{'page.cita.calendari.dialog.titol' | translate}}</h1>
<div mat-dialog-content>
	<h2 class="mat-headline mat-elevation-z4" style="text-align:center;padding:1em 0" [ngStyle]="{'background-color': (cita.anulacioData) ? '#fae3e3': '#d1e8ff'}">
		{{cita.data | date:'HH:mm'}} {{cita.llinatges + ', ' + cita.nom}}
		<span *ngIf="cita.anulacioData" style="color:red"><br/>{{'page.cita.calendari.dialog.cancelada' | translate}}</span>
	</h2>
	<mat-list role="list">
		<mat-list-item role="listitem">
			<mat-icon>event</mat-icon>&nbsp;{{cita.data | date}} {{cita.data | date:'HH:mm'}}
			<span *ngIf="cita.anulacioData">&nbsp;({{'page.cita.calendari.dialog.cancelacio.data' | translate}} {{cita.anulacioData | date}} {{cita.anulacioData | date:'HH:mm'}})</span>
		</mat-list-item>
		<mat-list-item role="listitem">
			<mat-icon>person</mat-icon>&nbsp;{{cita.llinatges + ', ' + cita.nom}}
		</mat-list-item>
		<mat-list-item role="listitem">
			<mat-icon>phone</mat-icon>&nbsp;{{cita.telefon}}
		</mat-list-item>
		<mat-list-item role="listitem">
			<mat-icon>alternate_email</mat-icon>&nbsp;{{cita.email}}
		</mat-list-item>
		<mat-list-item role="listitem">
			<mat-icon>vpn_key</mat-icon>&nbsp;{{cita.codi}}
		</mat-list-item>
	</mat-list>
</div>
<div mat-dialog-actions style="justify-content:space-between">
	<button mat-raised-button (click)="onCancelButtonClick()">{{'page.cita.calendari.dialog.tancar' | translate}}</button>
</div>
`,
})
export class CitesCalendariDetailDialog {

	cita: any;

	onCancelButtonClick(): void {
		this.dialogRef.close();
	}

	constructor(
		public dialogRef: MatDialogRef<CitesCalendariDetailDialog>,
		@Inject(MAT_DIALOG_DATA) public data: any) {
		this.cita = data.cita;
	}

}