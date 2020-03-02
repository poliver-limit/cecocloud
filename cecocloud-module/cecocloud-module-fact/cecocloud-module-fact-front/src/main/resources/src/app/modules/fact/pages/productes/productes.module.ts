import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';

import { ProductesGridComponent } from './productes-grid.component';
import { ProductesFormComponent } from './productes-form.component';
import { ProductesService } from './productes.service';
import { EmpresesFactFormModule } from '../empresesFact/empresesFact-form.module'

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
		EmpresesFactFormModule,
        RouterModule.forChild( [
            { path: '', component: ProductesGridComponent },
            { path: 'create', component: ProductesFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ProductesFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ProductesGridComponent        
    ],
    providers: [
        ProductesService
    ]
} )
export class ProductesModule {}