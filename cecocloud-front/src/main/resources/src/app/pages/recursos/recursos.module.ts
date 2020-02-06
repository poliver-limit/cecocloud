import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { RecursosGridComponent } from './recursos-grid.component';
import { RecursosFormComponent } from './recursos-form.component';
import { RecursosService } from './recursos.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: RecursosGridComponent },
			{ path: 'create', component: RecursosFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: RecursosFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		RecursosGridComponent,
		RecursosFormComponent
	],
	providers: [
		RecursosService
	]
})
export class RecursosModule { }