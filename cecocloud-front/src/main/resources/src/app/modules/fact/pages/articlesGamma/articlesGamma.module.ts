import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { ArticlesGammaGridComponent } from './articlesGamma-grid.component';
import { ArticlesGammaFormComponent } from './articlesGamma-form.component';
import { ArticlesGammaService } from './articlesGamma.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesGammaGridComponent },
            { path: 'create', component: ArticlesGammaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesGammaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesGammaGridComponent,
        ArticlesGammaFormComponent
    ],
    providers: [
        ArticlesGammaService
    ]
} )
export class ArticlesGammaModule {}