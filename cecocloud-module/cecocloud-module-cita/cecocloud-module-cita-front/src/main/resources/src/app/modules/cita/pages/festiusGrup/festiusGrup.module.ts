import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { FestiusGrupGridComponent } from './festiusGrup-grid.component';
import { FestiusGrupFormComponent } from './festiusGrup-form.component';
import { FestiusGrupService } from './festiusGrup.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: FestiusGrupGridComponent },
			{ path: 'create', component: FestiusGrupFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: FestiusGrupFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		FestiusGrupGridComponent,
		FestiusGrupFormComponent
	],
	providers: [
		FestiusGrupService
	]
})
export class FestiusGrupModule { }