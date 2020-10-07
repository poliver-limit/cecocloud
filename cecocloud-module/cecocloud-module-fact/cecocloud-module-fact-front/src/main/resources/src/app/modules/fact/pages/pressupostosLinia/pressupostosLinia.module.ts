import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { PressupostosLiniaGridComponent } from './pressupostosLinia-grid.component';
import { PressupostosLiniaFormComponent } from './pressupostosLinia-form.component';
import { PressupostosLiniaService } from './pressupostosLinia.service';

import { PressupostosLiniaFormModule } from './pressupostosLinia-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		PressupostosLiniaFormModule,
        RouterModule.forChild( [
            { path: '', component: PressupostosLiniaGridComponent },
            { path: 'create', component: PressupostosLiniaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PressupostosLiniaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        PressupostosLiniaGridComponent        
    ],
    providers: [
        PressupostosLiniaService
    ]
} )
export class PressupostosLiniaModule {}