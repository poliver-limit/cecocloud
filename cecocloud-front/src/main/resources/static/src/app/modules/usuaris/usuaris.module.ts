import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MantenimentModule } from '../../shared/manteniment.module';
import { MdcWebModule } from '../../shared/mdc-web.module';
import { UsuarisGridComponent } from './usuaris-grid.component';
import { UsuarisFormComponent } from './usuaris-form.component';
import { UsuarisService } from './usuaris.service';

@NgModule( {
    imports: [
        CommonModule,
        MdcWebModule,
        MantenimentModule,
        RouterModule.forChild( [
            { path: '', component: UsuarisGridComponent },
            { path: 'create', component: UsuarisFormComponent },
            { path: 'update/:id', component: UsuarisFormComponent }
        ] )
    ],
    declarations: [
        UsuarisGridComponent,
        UsuarisFormComponent
    ],
    providers: [
        UsuarisService
    ]
} )
export class UsuarisModule {}