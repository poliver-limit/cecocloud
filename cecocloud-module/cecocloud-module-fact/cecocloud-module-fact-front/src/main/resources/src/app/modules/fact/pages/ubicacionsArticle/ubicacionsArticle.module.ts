import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { UbicacionsArticleGridComponent } from './ubicacionsArticle-grid.component';
import { UbicacionsArticleFormComponent } from './ubicacionsArticle-form.component';
import { UbicacionsArticleService } from './ubicacionsArticle.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: UbicacionsArticleGridComponent },
            { path: 'create', component: UbicacionsArticleFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: UbicacionsArticleFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        UbicacionsArticleGridComponent,
        UbicacionsArticleFormComponent
    ],
    providers: [
        UbicacionsArticleService
    ]
} )
export class UbicacionsArticleModule {}