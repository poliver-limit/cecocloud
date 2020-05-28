import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { AlbaransLiniaGridComponent } from './albaransLinia-grid.component';
import { AlbaransLiniaFormComponent } from './albaransLinia-form.component';
import { AlbaransLiniaService } from './albaransLinia.service';

import { AlbaransLiniaFormModule } from './albaransLinia-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		AlbaransLiniaFormModule,
        RouterModule.forChild( [
            { path: '', component: AlbaransLiniaGridComponent },
            { path: 'create', component: AlbaransLiniaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: AlbaransLiniaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        AlbaransLiniaGridComponent        
    ],
    providers: [
        AlbaransLiniaService
    ]
} )
export class AlbaransLiniaModule {}