import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebModule } from '../../shared/mdc-web.module';
import { AngularMaterialModule } from '../../shared/angular-material.module';
import { RestapiFormExitGuard } from '../../shared/restapi-form/restapi-form-exit-guard';
import { UsuarisGridComponent } from './usuaris-grid.component';
import { UsuarisFormComponent } from './usuaris-form.component';
import { UsuarisContrasenyaFieldComponent, UsuarisContrasenyaDialog } from './usuaris-contrasenya-field.component';
import { UsuarisService } from './usuaris.service';

@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		ReactiveFormsModule,
		TranslateModule,
		MdcWebModule,
		AngularMaterialModule,
		MantenimentModule,
		RouterModule.forChild([
			{ path: '', component: UsuarisGridComponent },
			{ path: 'create', component: UsuarisFormComponent, canDeactivate: [RestapiFormExitGuard] },
			{ path: 'update/:id', component: UsuarisFormComponent, canDeactivate: [RestapiFormExitGuard] }
		])
	],
	declarations: [
		UsuarisGridComponent,
		UsuarisFormComponent,
		UsuarisContrasenyaFieldComponent,
		UsuarisContrasenyaDialog
	],
	providers: [
		UsuarisService
	],
	entryComponents: [
		UsuarisContrasenyaDialog
	]
})
export class UsuarisModule { }