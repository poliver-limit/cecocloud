import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CitesGridComponent } from './cites-grid.component';
import { CitesFormComponent } from './cites-form.component';
import { CitesService } from './cites.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: CitesGridComponent },
			{ path: 'create', component: CitesFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: CitesFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		CitesGridComponent,
		CitesFormComponent
	],
	providers: [
		CitesService
	]
})
export class CitesModule { }