import { NgModule, ErrorHandler, LOCALE_ID } from '@angular/core';
import { registerLocaleData } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { MultiTranslateHttpLoader } from 'ngx-translate-multi-http-loader';
import { AngularHalModule } from 'angular4-hal';
import { NgxMaskModule } from 'ngx-mask';
import { BngBaseAppModule, BngErrorModule, BngJwtInterceptor, BngErrorHandler, BngRestapiConfigService } from 'base-angular';

import { AppService } from './shared/app.service';
import { MaterialModule } from './shared/material.module';
import { LocaleService } from './shared/locale.service';
import { RestapiConfigService } from './shared/restapi-config.service';
import { SelectorIdentificadorEmpresaComponent } from './shared/selector-empresa/selector-identificador-empresa.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';
import localeCa from '@angular/common/locales/ca';

import { FactModule } from './modules/fact/fact.module';
import { MarcModule } from './modules/marc/marc.module';
import { RrhhModule } from './modules/rrhh/rrhh.module';

registerLocaleData(localeCa);

export function HttpLoaderFactory(http: HttpClient) {
	return new MultiTranslateHttpLoader(
		http, [
			{ prefix: "./assets/i18n/baseapp/", suffix: ".json" },
			{ prefix: "./assets/i18n/", suffix: ".json"},
			{ prefix: "./assets/i18n/fact/", suffix: ".json"},
			{ prefix: "./assets/i18n/marc/", suffix: ".json"},
			{ prefix: "./assets/i18n/rrhh/", suffix: ".json"}
		]);
}

@NgModule({
	imports: [
		BrowserModule,
		BrowserAnimationsModule,
		ReactiveFormsModule,
		HttpClientModule,
		MaterialModule,
		TranslateModule.forRoot({
			loader: {
				provide: TranslateLoader,
				useFactory: HttpLoaderFactory,
				deps: [HttpClient]
			}
		}),
		AngularHalModule.forRoot(),
		NgxMaskModule.forRoot(),
		BngBaseAppModule,
		BngErrorModule,
		FactModule,
		MarcModule,
		RrhhModule,
		AppRoutingModule
	],
	declarations: [
		AppComponent,
		SelectorIdentificadorEmpresaComponent
	],
	providers: [
		{ provide: HTTP_INTERCEPTORS, useClass: BngJwtInterceptor, multi: true },
		{ provide: ErrorHandler, useClass: BngErrorHandler },
		{ provide: 'ExternalConfigurationService', useClass: RestapiConfigService },
		{ provide: LOCALE_ID, useFactory: () => LocaleService.getCurrentLocale() },
		{ provide: BngRestapiConfigService, useClass: RestapiConfigService }
	],
	bootstrap: [
		AppComponent
	]
})
export class AppModule {

	constructor(appService: AppService) {}

}
