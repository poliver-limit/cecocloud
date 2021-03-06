import { IdentificadorsPermissionService } from './identificadors-permission.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { IdentificadorsGridComponent } from './identificadors-grid.component';
import { IdentificadorsFormComponent } from './identificadors-form.component';
import { IdentificadorsService } from './identificadors.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: IdentificadorsGridComponent },
			{ path: 'create', component: IdentificadorsFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: IdentificadorsFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		IdentificadorsGridComponent,
		IdentificadorsFormComponent
	],
	providers: [
		IdentificadorsService,
		IdentificadorsPermissionService
	]
})
export class IdentificadorsModule { }