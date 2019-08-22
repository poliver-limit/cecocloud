import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebMaterialModule } from '../../shared/mdc-web-material.module';
import { EmpresesGridComponent } from './empreses-grid.component';
import { EmpresesFormComponent } from './empreses-form.component';
import { EmpresesService } from './empreses.service';

@NgModule( {
    imports: [
        CommonModule,
        MantenimentModule,
        MdcWebMaterialModule,
        RouterModule.forChild( [
            { path: '', component: EmpresesGridComponent },
            { path: 'create', component: EmpresesFormComponent },
            { path: 'update/:id', component: EmpresesFormComponent }
        ] )
    ],
    declarations: [
        EmpresesGridComponent,
        EmpresesFormComponent
    ],
    providers: [
        EmpresesService
    ]
} )
export class EmpresesModule {}