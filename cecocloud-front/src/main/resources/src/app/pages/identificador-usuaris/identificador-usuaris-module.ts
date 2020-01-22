import { PerfilsService } from './../perfils/perfils.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { RouterModule } from '@angular/router';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';
import { IdentificadorUsuarisGridComponent, IdentificadorUsuarisAddDialog } from './identificador-usuaris-grid-component';
import { IdentificadorUsuarisService } from './identificador-usuaris-service';
import { UsuarisService } from '../usuaris/usuaris.service';
import { IdentificadorUsuarisFormComponent } from './identificador-usuaris-form-component';
import { UsuariIdentificadorEmpresaService } from 'src/app/shared/usuari-identificador-empresa.service';


@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: IdentificadorUsuarisGridComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: IdentificadorUsuarisFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		IdentificadorUsuarisGridComponent,
		IdentificadorUsuarisFormComponent,
		IdentificadorUsuarisAddDialog
	],
	providers: [
		IdentificadorUsuarisService,
		UsuarisService,
		UsuariIdentificadorEmpresaService,
		PerfilsService
	],
	entryComponents: [
		IdentificadorUsuarisAddDialog
	]
})
export class IdentificadorUsuarisModule { }