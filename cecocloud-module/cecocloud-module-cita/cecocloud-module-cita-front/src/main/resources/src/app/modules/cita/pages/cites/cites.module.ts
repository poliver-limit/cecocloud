import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { CalendarModule } from 'angular-calendar';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CitesCalendariComponent, CitesCalendariDetailDialog } from './cites-calendari.component';
import { CitesGridComponent } from './cites-grid.component';
import { CitesFormComponent } from './cites-form.component';
import { PuntsVendaService } from './puntsVenda.service';
import { CitesService } from './cites.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		CalendarModule,
		RouterModule.forChild([
			{ path: '', component: CitesCalendariComponent },
			{ path: 'create', component: CitesFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: CitesFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		CitesCalendariComponent,
		CitesGridComponent,
		CitesFormComponent,
		CitesCalendariDetailDialog
	],
	providers: [
		PuntsVendaService,
		CitesService
	],
	entryComponents: [
		CitesCalendariDetailDialog
	]
})
export class CitesModule { }