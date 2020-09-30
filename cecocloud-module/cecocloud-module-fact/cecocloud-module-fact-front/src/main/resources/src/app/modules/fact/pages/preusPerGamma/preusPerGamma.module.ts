import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { PreusPerGammaGridComponent } from './preusPerGamma-grid.component';
import { PreusPerGammaFormComponent } from './preusPerGamma-form.component';
import { PreusPerGammaService } from './preusPerGamma.service';
import { ArticlesGammaFormModule } from '../articlesGamma/articlesGamma-form.module';
import { TransportistesFormModule } from '../transportistes/transportistes-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
        MaterialModule,
        ArticlesGammaFormModule,
        TransportistesFormModule,
        RouterModule.forChild( [
            { path: '', component: PreusPerGammaGridComponent },
            { path: 'create', component: PreusPerGammaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: PreusPerGammaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        PreusPerGammaGridComponent,
        PreusPerGammaFormComponent
    ],
    providers: [
        PreusPerGammaService
    ]
} )
export class PreusPerGammaModule {}