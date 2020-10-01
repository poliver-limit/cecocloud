import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { CategoriesTraduccioGridComponent } from './categoriesTraduccio-grid.component';
import { CategoriesTraduccioFormComponent } from './categoriesTraduccio-form.component';
import { CategoriesTraduccioService } from './categoriesTraduccio.service';

import { CategoriesTraduccioFormModule } from './categoriesTraduccio-form.module';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		CategoriesTraduccioFormModule,
        RouterModule.forChild( [
            { path: '', component: CategoriesTraduccioGridComponent },
            { path: 'create', component: CategoriesTraduccioFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: CategoriesTraduccioFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        CategoriesTraduccioGridComponent        
    ],
    providers: [
        CategoriesTraduccioService
    ]
} )
export class CategoriesTraduccioModule {}