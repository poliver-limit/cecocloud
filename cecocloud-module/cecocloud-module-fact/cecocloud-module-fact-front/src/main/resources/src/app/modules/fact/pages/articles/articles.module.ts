import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ArticlesGridComponent } from './articles-grid.component';
import { ArticlesFormComponent } from './articles-form.component';
import { ArticlesService } from './articles.service';
import { IvesFormComponent } from '../ives/ives-form.component'
import { IvesService } from '../ives/ives.service'

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesGridComponent },
            { path: 'create', component: ArticlesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesGridComponent,
        ArticlesFormComponent,
		IvesFormComponent
    ],
    providers: [
        ArticlesService,
		IvesService
    ],
	entryComponents: [
		IvesFormComponent
	]
} )
export class ArticlesModule {}