import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ConfiguracionsImpressosGridComponent } from './configuracionsImpressos-grid.component';
import { ConfiguracionsImpressosFormComponent } from './configuracionsImpressos-form.component';
import { ConfiguracionsImpressosService } from './configuracionsImpressos.service';

import { ConfiguracionsImpressosFormModule } from './configuracionsImpressos-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ConfiguracionsImpressosFormModule,
        RouterModule.forChild( [
            { path: '', component: ConfiguracionsImpressosGridComponent },
            { path: 'create', component: ConfiguracionsImpressosFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ConfiguracionsImpressosFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ConfiguracionsImpressosGridComponent        
    ],
    providers: [
        ConfiguracionsImpressosService
    ]
} )
export class ConfiguracionsImpressosModule {}