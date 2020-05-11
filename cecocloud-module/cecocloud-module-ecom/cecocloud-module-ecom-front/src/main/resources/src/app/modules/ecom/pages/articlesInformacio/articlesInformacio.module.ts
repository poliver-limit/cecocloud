import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ArticlesInformacioGridComponent } from './articlesInformacio-grid.component';
import { ArticlesInformacioFormComponent } from './articlesInformacio-form.component';
import { ArticlesInformacioService } from './articlesInformacio.service';

import { ArticlesInformacioFormModule } from './articlesInformacio-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		ArticlesInformacioFormModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesInformacioGridComponent },
            { path: 'create', component: ArticlesInformacioFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesInformacioFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesInformacioGridComponent
    ],
    providers: [
        ArticlesInformacioService
    ]
} )
export class ArticlesInformacioModule {}