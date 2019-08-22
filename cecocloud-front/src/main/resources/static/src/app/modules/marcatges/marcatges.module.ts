import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebMaterialModule } from '../../shared/mdc-web-material.module';
import { MarcatgesGridComponent } from './marcatges-grid.component';
import { MarcatgesFormComponent } from './marcatges-form.component';
import { MarcatgesService } from './marcatges.service';

@NgModule( {
    imports: [
        CommonModule,
        MdcWebMaterialModule,
        MantenimentModule,
        RouterModule.forChild( [
            { path: '', component: MarcatgesGridComponent },
            { path: 'create', component: MarcatgesFormComponent },
            { path: 'update/:id', component: MarcatgesFormComponent }
        ] )
    ],
    declarations: [
        MarcatgesGridComponent,
        MarcatgesFormComponent
    ],
    providers: [
        MarcatgesService
    ]
} )
export class MarcatgesModule {}