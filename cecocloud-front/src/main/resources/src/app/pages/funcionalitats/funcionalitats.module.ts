import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { FuncionalitatsGridComponent } from './funcionalitats-grid.component';
import { FuncionalitatsFormComponent } from './funcionalitats-form.component';
import { FuncionalitatsService } from './funcionalitats.service';
import { FuncionalitatsRecursosService } from './funcionalitats-recursos.service';

@NgModule({
	imports: [
		CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		RouterModule.forChild([
			{ path: '', component: FuncionalitatsGridComponent },
			{ path: 'create', component: FuncionalitatsFormComponent, canDeactivate: [BngFormExitGuard] },
			{ path: 'update/:id', component: FuncionalitatsFormComponent, canDeactivate: [BngFormExitGuard] }
		])
	],
	declarations: [
		FuncionalitatsGridComponent,
		FuncionalitatsFormComponent
	],
	providers: [
		FuncionalitatsService,
		FuncionalitatsRecursosService
	]
})
export class FuncionalitatsModule { }