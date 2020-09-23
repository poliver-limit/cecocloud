import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { LlocFeinaGridComponent } from './llocFeina-grid.component';
import { LlocFeinaFormComponent } from './llocFeina-form.component';
import { LlocFeinaService } from './llocFeina.service';
import { OperariEmpresaLlocFeinaService } from './operariEmpresaLlocFeina.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: LlocFeinaGridComponent },
			{ path: 'create', component: LlocFeinaFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: LlocFeinaFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		LlocFeinaGridComponent,
		LlocFeinaFormComponent
	],
	providers: [
		LlocFeinaService,
		OperariEmpresaLlocFeinaService
	]
})
export class LlocFeinaModule { }