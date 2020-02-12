import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';
import { MatTableModule } from '@angular/material';

import { MaterialModule } from '../../shared/material.module';

import { UsuariIdentificadorService } from './usuari-identificador.service';
import { UsuariIdentificadorEmpresaService } from './usuari-identificador-empresa.service';
import { UsuariService } from './usuari.service';
import { EmpresaService } from './empresa.service';
import { PerfilService } from './perfil.service';
import { PerfilUsuariIdentificadorEmpresaService } from './perfil-usuari-identificador-empresa.service';
import { UsuariIdentificadorsFormComponent } from './usuari-identificadors-form-component';
import { UsuariIdentificadorsGridComponent, UsuariIdentificadorsAddDialog } from './usuari-identificadors-grid.component';
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
		UsuariIdentificadorService,
		UsuariIdentificadorEmpresaService,
		UsuariService,
		EmpresaService,
		PerfilService,
		PerfilUsuariIdentificadorEmpresaService
	],
	entryComponents: [
		UsuariIdentificadorsAddDialog
	]
})
export class UsuariIdentificadorsModule { }