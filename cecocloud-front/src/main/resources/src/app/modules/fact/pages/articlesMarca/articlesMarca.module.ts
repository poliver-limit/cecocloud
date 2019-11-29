import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { ArticlesMarcaGridComponent } from './articlesMarca-grid.component';
import { ArticlesMarcaFormComponent } from './articlesMarca-form.component';
import { ArticlesMarcaService } from './articlesMarca.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesMarcaGridComponent },
            { path: 'create', component: ArticlesMarcaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesMarcaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesMarcaGridComponent,
        ArticlesMarcaFormComponent
    ],
    providers: [
        ArticlesMarcaService
    ]
} )
export class ArticlesMarcaModule {}