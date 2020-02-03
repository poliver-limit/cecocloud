import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { MultiTranslateHttpLoader } from 'ngx-translate-multi-http-loader';

import { MaterialModule } from '../../../../shared/material.module';
import { IndexComponent } from './index.component';

export function HttpLoaderFactory(http: HttpClient) {
	return new MultiTranslateHttpLoader(
		http, [
			{ prefix: "./assets/i18n/baseapp/", suffix: ".json" },
			{ prefix: "./assets/i18n/", suffix: ".json"},
			{ prefix: "./assets/i18n/marc", suffix: ".json"}
		]);
}

@NgModule( {
    imports: [
        CommonModule,
		TranslateModule,
        MaterialModule,
        RouterModule.forChild( [
            { path: '', component: IndexComponent }
        ] )
    ],
    declarations: [
        IndexComponent
    ]
} )
export class IndexModule {

}