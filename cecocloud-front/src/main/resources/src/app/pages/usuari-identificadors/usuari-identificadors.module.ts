import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';
import { MatTableModule } from '@angular/material';

import { MaterialModule } from '../../shared/material.module';

import { UsuariIdentificadorsService } from './usuari-identificadors.service';
import { UsuariIdentificadorsFormComponent } from './usuari-identificadors-form-component';
import { UsuariIdentificadorsGridComponent, UsuariIdentificadorsAddDialog } from './usuari-identificadors-grid.component';
import { UsuariIdentificadorEmpresaService } from 'src/app/shared/usuari-identificador-empresa.service';
import { PerfilsService } from '../perfils/perfils.service';
import { UsuarisService } from './usuaris.service';
import { EmpresesService } from '../empreses/empreses.service';
import { PerfilUsuariIdentificadorEmpresaService } from 'src/app/shared/funcionalitats-permisos/perfil-usuari-identificador-empresa.service';
import { FuncionalitatsPermisosModule } from 'src/app/shared/funcionalitats-permisos/funcionalitats-permisos.module';

@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		MatTableModule,
		FuncionalitatsPermisosModule,
		RouterModule.forChild([
			{ path: '', component: UsuariIdentificadorsGridComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: UsuariIdentificadorsFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		UsuariIdentificadorsGridComponent,
		UsuariIdentificadorsFormComponent,
		UsuariIdentificadorsAddDialog
	],
	providers: [
		UsuariIdentificadorsService,
		UsuarisService,
		UsuariIdentificadorEmpresaService,
		PerfilsService,
		EmpresesService,
		PerfilUsuariIdentificadorEmpresaService
	],
	entryComponents: [
		UsuariIdentificadorsAddDialog
	]
})
export class UsuariIdentificadorsModule { }