import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { OperarisGridComponent, OperarisAddDialog } from './operaris-grid.component';
import { OperarisFormComponent } from './operaris-form.component';
import { OperarisService } from './operaris.service';
import { UsuarisService } from './usuaris.service';

@NgModule({
    imports: [
        CommonModule,
		FormsModule,
		ReactiveFormsModule,
        TranslateModule,
        BngModule,
        MaterialModule,
        RouterModule.forChild([
            { path: '', component: OperarisGridComponent },
            { path: 'create', component: OperarisFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: OperarisFormComponent, canDeactivate: [BngFormExitGuard] }
        ])
    ],
    declarations: [
        OperarisGridComponent,
		OperarisAddDialog,
        OperarisFormComponent
    ],
    providers: [
        OperarisService,
		UsuarisService
    ],
	entryComponents: [
		OperarisAddDialog
	]
})
export class OperarisModule { }