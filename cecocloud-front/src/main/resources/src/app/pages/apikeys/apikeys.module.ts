import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { ApikeysGridComponent } from './apikeys-grid.component';
import { ApikeysFormComponent } from './apikeys-form.component';
import { ApikeysService } from './apikeys.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: ApikeysGridComponent },
			{ path: 'create', component: ApikeysFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: ApikeysFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		ApikeysGridComponent,
		ApikeysFormComponent
	],
	providers: [
		ApikeysService
	]
})
export class ApikeysModule { }