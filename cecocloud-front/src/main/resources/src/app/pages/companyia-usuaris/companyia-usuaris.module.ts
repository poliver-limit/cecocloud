import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { RouterModule } from '@angular/router';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { CompanyiaUsuarisGridComponent, CompanyiaUsuarisAddDialog } from './companyia-usuaris-grid.component';
import { CompanyiaUsuarisService } from './companyia-usuaris.service';
import { UsuarisService } from './usuaris.service';

@NgModule( {
    imports: [
        CommonModule,
		FormsModule,
        ReactiveFormsModule,
		TranslateModule,
        BngModule,
		MaterialModule,
        RouterModule.forChild([
            { path: '', component: CompanyiaUsuarisGridComponent, canDeactivate: [BngFormExitGuard] }
        ])
    ],
    declarations: [
        CompanyiaUsuarisGridComponent,
		CompanyiaUsuarisAddDialog
    ],
    providers: [
        CompanyiaUsuarisService,
		UsuarisService
    ],
	entryComponents: [
		CompanyiaUsuarisAddDialog
	]
} )
export class CompanyiaUsuarisModule {}