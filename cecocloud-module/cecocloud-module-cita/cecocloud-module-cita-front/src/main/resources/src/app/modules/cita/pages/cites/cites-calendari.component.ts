import { Injectable, Component, Inject, ViewEncapsulation } from '@angular/core';
import { formatDate } from '@angular/common';
import { Subject } from 'rxjs';
import { HalParam } from '@lagoshny/ngx-hal-client';
import { TranslateService } from '@ngx-translate/core';
import { CalendarDateFormatter, CalendarAngularDateFormatter, DateFormatterParams, CalendarEvent, CalendarView, getWeekViewPeriod } from 'angular-calendar';
import { WeekView, WeekViewHourColumn, WeekViewHour, WeekViewHourSegment }from 'calendar-utils';
import { startOfWeek, endOfWeek } from 'date-fns';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BngFormDialog, BngRestapiProfile } from 'base-angular';

import { CitesFormComponent } from './cites-form.component';
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
		<span>Cites</span>&nbsp;<span>({{viewDate | calendarDate:(view + 'ViewTitle')}})</span>
		<span class="toolbar-fill"></span>
		<button mat-icon-button *ngIf="puntsVenda" (click)="onAddIconClicked()"><mat-icon>add</mat-icon></button>
		<button mat-icon-button mwlCalendarPreviousView [view]="view" [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>arrow_back_ios</mat-icon></button>
		<button mat-icon-button mwlCalendarToday [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>gps_fixed</mat-icon></button>
		<button mat-icon-button mwlCalendarNextView [view]="view" [(viewDate)]="viewDate" (viewDateChange)="onViewDateChange()"><mat-icon>arrow_forward_ios</mat-icon></button>
		<mat-form-field *ngIf="puntsVenda" style="width: 30%; top: 14px; margin: 0 1em">
			<mat-select [(value)]="puntVendaSelectedId" (selectionChange)="refreshCites()">
				<mat-option *ngFor="let puntVenda of puntsVenda" [value]="puntVenda.id">{{puntVenda.nom}}</mat-option>
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
    	(eventClicked)="onEventClicked($event.event)"
		(hourSegmentClicked)="onHourSegmentClicked($event.date)"
		(beforeViewRender)="onBeforeViewRender($event)"></mwl-calendar-week-view>`,
	styles: [`
.toolbar-fill {
	flex: 1 1 auto;
}
.cal-day-selected, .cal-day-selected:hover {
	background-color: #bbb !important;
}
`],
	providers: [{
		provide: CalendarDateFormatter,
		useClass: CustomDateFormatter,
	}],
	encapsulation: ViewEncapsulation.None
})
export class CitesCalendariComponent {

	view: CalendarView = CalendarView.Week;
	weekView: WeekView;
	viewDate: Date = new Date();
	weekStartsOn: number = 1;
	dayStartHour: number;
	dayStartMinute: number;
	dayEndHour: number;
	dayEndMinute: number;
	events: CalendarEvent[] = [];
	refresh: Subject<any> = new Subject();
	puntsVenda: any[];
	puntVendaSelectedId: string;
	showCalendar: boolean;
	selectedDateTime: Date;

	onViewDateChange() {
		this.refreshCites();
	}

	onAddIconClicked(): void {
		this.citesService.whenReady().subscribe((citesProfile: BngRestapiProfile) => {
			let puntVenda = this.puntsVenda.find(puntVenda => {return puntVenda.id === this.puntVendaSelectedId});
			this.dialog.open(BngFormDialog, {
				width: '60%',
				data: {
					//id: id,
					externalFormComponent: CitesFormComponent,
					fixedData: {
						data: this.selectedDateTime,
						puntVenda: {
							id: puntVenda.id,
							description: puntVenda.nom
						}
					},
					resource: citesProfile.resource,
					readOnlyStateEnabled: false
				}
			}).afterClosed().subscribe(data => {
				if (data && data.resource) {
					this.refresh.next();
				}
			});
		});
	}

	onEventClicked(event: CalendarEvent): void {
		this.dialog.open(CitesCalendariDetailDialog, {
			width: '600px',
			data: { cita: event.meta }
		});
	}

	onHourSegmentClicked(date: Date): void {
		if (this.selectedDateTime && this.selectedDateTime.getTime() == date.getTime()) {
			delete this.selectedDateTime;
		} else {
			this.selectedDateTime = date;
		}
		this.processSelectionChanges();
	}

	onBeforeViewRender(weekView: WeekView) {
		this.weekView = weekView;
	}

	private processSelectionChanges() {
		let selectedDateNoTime: Date;
		if (this.selectedDateTime) {
			selectedDateNoTime = new Date(this.selectedDateTime.getTime());
			selectedDateNoTime.setHours(0, 0, 0, 0);
		}
		this.weekView.hourColumns.forEach((hourColumn: WeekViewHourColumn) => {
			hourColumn.hours.forEach((hour: WeekViewHour) => {
				hour.segments.forEach((hourSegment: WeekViewHourSegment) => {
					delete hourSegment.cssClass;
					if (this.selectedDateTime && hourColumn.date.getTime() === selectedDateNoTime.getTime() && hourSegment.date.getTime() === this.selectedDateTime.getTime()) {
						hourSegment.cssClass = 'cal-day-selected';
					}
				});
			});
		});
	}

	refreshCites() {
		this.showCalendar = false;
		let puntVenda = this.puntsVenda.find(puntVenda => {return puntVenda.id === this.puntVendaSelectedId});
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
					this.puntVendaSelectedId = puntsVenda[0].id;
					this.refreshCites();
				}
			});
		});
	}

}

@Component({
	template: `
<h1 mat-dialog-title>{{'page.cita.calendari.detail.dialog.titol' | translate}}</h1>
<div mat-dialog-content>
	<h2 class="mat-headline mat-elevation-z4" style="text-align:center;padding:1em 0" [ngStyle]="{'background-color': (cita.anulacioData) ? '#fae3e3': '#d1e8ff'}">
		{{cita.data | date:'HH:mm'}} {{cita.llinatges + ', ' + cita.nom}}
		<span *ngIf="cita.anulacioData" style="color:red"><br/>{{'page.cita.calendari.detail.dialog.cancelada' | translate}}</span>
	</h2>
	<mat-list role="list">
		<mat-list-item role="listitem">
			<mat-icon>event</mat-icon>&nbsp;{{cita.data | date}} {{cita.data | date:'HH:mm'}}
			<span *ngIf="cita.anulacioData">&nbsp;({{'page.cita.calendari.detail.dialog.cancelacio.data' | translate}} {{cita.anulacioData | date}} {{cita.anulacioData | date:'HH:mm'}})</span>
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
<div mat-dialog-actions style="justify-content:flex-end">
	<button mat-button (click)="onCancelButtonClick()">{{'page.cita.calendari.detail.dialog.tancar' | translate}}</button>
	<button *ngIf="!cita.anulacioData" mat-raised-button color="warn" (click)="onAnularButtonClick()" style="float:right">{{ 'page.cita.calendari.detail.dialog.anular' | translate }}</button>
</div>
`,
})
export class CitesCalendariDetailDialog {

	cita: any;

	onCancelButtonClick(): void {
		this.dialogRef.close();
	}

	onAnularButtonClick() {
		let confirmMessageTranslated: string = this.translateKey('page.cita.calendari.detail.dialog.anular.confirm');
		if (confirm(confirmMessageTranslated)) {
			this.citesService.cancel(this.cita.id).subscribe((cita: any) => {
				this.cita = cita;
			});
		}
	}

	translateKey(key: string, params?: any, defaultValue?: string) {
		let translatedKey = this.translate.instant(key, params);
		if (defaultValue) {
			return (translatedKey !== key) ? translatedKey : defaultValue;
		} else {
			return translatedKey;
		}
	}

	constructor(
		public dialogRef: MatDialogRef<CitesCalendariDetailDialog>,
		@Inject(MAT_DIALOG_DATA) public data: any,
		private translate: TranslateService,
		public citesService: CitesService) {
		this.cita = data.cita;
	}

}