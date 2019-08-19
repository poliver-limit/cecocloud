import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MaterialModule } from '../../shared/material.module';
import { OperarisGridComponent } from './operaris-grid.component';
import { OperarisFormComponent } from './operaris-form.component';
import { OperarisService } from './operaris.service';

@NgModule( {
    imports: [
        CommonModule,
        MantenimentModule,
        MaterialModule,
        RouterModule.forChild( [
            { path: '', component: OperarisGridComponent },
            { path: 'create', component: OperarisFormComponent },
            { path: 'update/:id', component: OperarisFormComponent }
        ] )
    ],
    declarations: [
        OperarisGridComponent,
        OperarisFormComponent
    ],
    providers: [
        OperarisService
    ]
} )
export class OperarisModule {}