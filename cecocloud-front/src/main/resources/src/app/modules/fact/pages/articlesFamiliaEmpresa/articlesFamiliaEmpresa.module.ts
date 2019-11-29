import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { TranslateModule } from '@ngx-translate/core';
import { BngModule, BngFormExitGuard } from 'base-angular';

import { MaterialModule } from '../../shared/material.module';

import { ArticlesFamiliaEmpresaGridComponent } from './articlesFamiliaEmpresa-grid.component';
import { ArticlesFamiliaEmpresaFormComponent } from './articlesFamiliaEmpresa-form.component';
import { ArticlesFamiliaEmpresaService } from './articlesFamiliaEmpresa.service';

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
		BngModule,
		MaterialModule,
        RouterModule.forChild( [
            { path: '', component: ArticlesFamiliaEmpresaGridComponent },
            { path: 'create', component: ArticlesFamiliaEmpresaFormComponent, canDeactivate: [BngFormExitGuard] },
            { path: 'update/:id', component: ArticlesFamiliaEmpresaFormComponent, canDeactivate: [BngFormExitGuard] }
        ] )
    ],
    declarations: [
        ArticlesFamiliaEmpresaGridComponent,
        ArticlesFamiliaEmpresaFormComponent
    ],
    providers: [
        ArticlesFamiliaEmpresaService
    ]
} )
export class ArticlesFamiliaEmpresaModule {}