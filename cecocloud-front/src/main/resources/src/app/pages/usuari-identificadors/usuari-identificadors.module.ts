import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { UsuariIdentificadorsService } from './usuari-identificadors.service';
import { UsuarisService } from './usuaris.service';
import { UsuariIdentificadorsGridComponent, UsuariIdentificadorsAddDialog } from './usuari-identificadors-grid.component';

@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([{
			path: '', component: UsuariIdentificadorsGridComponent, canDeactivate: [BngFormExitGuard]
		}])
	],
	declarations: [
		UsuariIdentificadorsGridComponent,
		UsuariIdentificadorsAddDialog
	],
	providers: [
		UsuariIdentificadorsService,
		UsuarisService
	],
	entryComponents: [
		UsuariIdentificadorsAddDialog
	]
})
export class UsuariIdentificadorsModule { }