import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { PressupostosGridComponent } from './pressupostos-grid.component';
import { PressupostosFormComponent } from './pressupostos-form.component';

import { PressupostosService } from './pressupostos.service';

import { PressupostosFormModule } from './pressupostos-form.module';

import { PressupostosLiniaService } from '../pressupostosLinia/pressupostosLinia.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		PressupostosFormModule,
        RouterModule.forChild( [
            { path: '', component: PressupostosGridComponent },
            { path: 'create', component: PressupostosFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PressupostosFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        PressupostosGridComponent        
    ],
    providers: [
        PressupostosService,

		PressupostosLiniaService
    ]
} )
export class PressupostosModule {}