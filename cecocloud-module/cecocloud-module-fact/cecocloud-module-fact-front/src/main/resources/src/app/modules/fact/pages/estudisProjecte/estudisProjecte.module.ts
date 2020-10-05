import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { EstudisProjecteGridComponent } from './estudisProjecte-grid.component';
import { EstudisProjecteFormComponent } from './estudisProjecte-form.component';
import { EstudisProjecteService } from './estudisProjecte.service';
import { EmpresesFactFormModule } from '../empresesFact/empresesFact-form.module';
import { DivisesFormModule } from '../divises/divises-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        EmpresesFactFormModule,
        DivisesFormModule,
        RouterModule.forChild( [
            { path: '', component: EstudisProjecteGridComponent },
            { path: 'create', component: EstudisProjecteFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: EstudisProjecteFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        EstudisProjecteGridComponent,
        EstudisProjecteFormComponent
    ],
    providers: [
        EstudisProjecteService
    ]
} )
export class EstudisProjecteModule {}