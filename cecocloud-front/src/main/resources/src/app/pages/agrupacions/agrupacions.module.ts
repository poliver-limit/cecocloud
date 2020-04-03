import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { AgrupacionsGridComponent } from './agrupacions-grid.component';
import { AgrupacionsFormComponent } from './agrupacions-form.component';
import { AgrupacionsService } from './agrupacions.service';
import { AgrupacionsFuncionalitatsService } from './agrupacions-funcionalitats.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: AgrupacionsGridComponent },
			{ path: 'create', component: AgrupacionsFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: AgrupacionsFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		AgrupacionsGridComponent,
		AgrupacionsFormComponent
	],
	providers: [
		AgrupacionsService,
		AgrupacionsFuncionalitatsService
	]
})
export class AgrupacionsModule { }