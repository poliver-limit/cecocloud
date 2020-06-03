import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BngModule } from 'base-angular';

import { MaterialModule } from '../../../../shared/material.module';
import { TranslateModule } from '@ngx-translate/core';

import { ArticlesFamiliaEmpresaService } from '../articlesFamiliaEmpresa/articlesFamiliaEmpresa.service';

import { ArticlesFamiliaFormComponent } from './articlesFamilia-form.component';
import { ArticlesFamiliaService } from './articlesFamilia.service';

@NgModule( {
    imports: [
        CommonModule,
		BngModule,
		MaterialModule,
		TranslateModule
    ],

    declarations: [
        ArticlesFamiliaFormComponent
    ],
	entryComponents: [
		ArticlesFamiliaFormComponent
	],
	exports: [
		ArticlesFamiliaFormComponent
	],
    providers: [
        ArticlesFamiliaService,
	
		ArticlesFamiliaEmpresaService
    ]
} )
export class ArticlesFamiliaFormModule {}