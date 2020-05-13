import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { PuntsVendaGridComponent } from './puntsVenda-grid.component';
import { PuntsVendaFormComponent } from './puntsVenda-form.component';
import { PuntsVendaService } from './puntsVenda.service';
import { PuntVendaHorarisService } from './puntVendaHoraris.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: PuntsVendaGridComponent },
			{ path: 'create', component: PuntsVendaFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: PuntsVendaFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		PuntsVendaGridComponent,
		PuntsVendaFormComponent
	],
	providers: [
		PuntsVendaService,
		PuntVendaHorarisService
	]
})
export class PuntsVendaModule { }