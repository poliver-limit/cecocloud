import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ArticlesFamiliaGridComponent } from './articlesFamilia-grid.component';
import { ArticlesFamiliaFormComponent } from './articlesFamilia-form.component';
import { ArticlesFamiliaService } from './articlesFamilia.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesFamiliaGridComponent },
            { path: 'create', component: ArticlesFamiliaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesFamiliaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesFamiliaGridComponent,
        ArticlesFamiliaFormComponent
    ],
    providers: [
        ArticlesFamiliaService
    ]
} )
export class ArticlesFamiliaModule {}