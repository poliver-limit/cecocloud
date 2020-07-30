import { NgModule, ErrorHandler, LOCALE_ID } from '@angular/core';
import { registerLocaleData } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { MultiTranslateHttpLoader } from 'ngx-translate-multi-http-loader';
import { NgxHalClientModule } from '@lagoshny/ngx-hal-client';
import { NgxMaskModule } from 'ngx-mask';
import { ModuleRegistry } from '@ag-grid-community/all-modules';
import { InfiniteRowModelModule } from '@ag-grid-community/infinite-row-model';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';
import { RECAPTCHA_V3_SITE_KEY } from 'ng-recaptcha';
import { BngBaseAppModule, BngErrorModule, BngJwtInterceptor, BngErrorHandler, BngRestapiConfigService } from 'base-angular';

import { AppService } from './shared/app.service';
import { MaterialModule } from './shared/material.module';
import { LocaleService } from './shared/locale.service';
import { RestapiConfigService } from './shared/restapi-config.service';
import { SelectorIdentificadorEmpresaComponent } from './shared/selector-identificador-empresa/selector-identificador-empresa.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';
import localeCa from '@angular/common/locales/ca';
import localeEs from '@angular/common/locales/es';
import { environment } from './../environments/environment';

import { FactModule } from './modules/fact/fact.module';
import { LiciModule } from './modules/lici/lici.module';
import { MarcModule } from './modules/marc/marc.module';
import { RrhhModule } from './modules/rrhh/rrhh.module';
import { CitaModule } from './modules/cita/cita.module';
import { EcomModule } from './modules/ecom/ecom.module';

registerLocaleData(localeCa);
registerLocaleData(localeEs);

// Si no es registra aquí el mòdul InfiniteRowModelModule dona un error a la consola Javascript dient
// que el mòdul InfiniteRowModelModule no està carregat.
ModuleRegistry.register(InfiniteRowModelModule);

export function HttpLoaderFactory(http: HttpClient) {
	return new MultiTranslateHttpLoader(
		http, [
			{ prefix: "./assets/i18n/baseapp/", suffix: ".json" },
			{ prefix: "./assets/i18n/", suffix: ".json"},
			{ prefix: "./assets/i18n/fact/", suffix: ".json"},
			{ prefix: "./assets/i18n/lici/", suffix: ".json"},
			{ prefix: "./assets/i18n/marc/", suffix: ".json"},
			{ prefix: "./assets/i18n/rrhh/", suffix: ".json"},
			{ prefix: "./assets/i18n/cita/", suffix: ".json"},
			{ prefix: "./assets/i18n/ecom/", suffix: ".json"}
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
		NgxHalClientModule.forRoot(),
		NgxMaskModule.forRoot(),
		CalendarModule.forRoot({
			provide: DateAdapter,
			useFactory: adapterFactory,
		}),
		BngBaseAppModule,
		BngErrorModule,
		FactModule,
		LiciModule,
		MarcModule,
		RrhhModule,
		CitaModule,
		EcomModule,
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
		{ provide: BngRestapiConfigService, useClass: RestapiConfigService },
		{ provide: RECAPTCHA_V3_SITE_KEY, useValue: environment.recaptchaSiteKey }
	],
	bootstrap: [
		AppComponent
	]
})
export class AppModule {

	constructor(appService: AppService) {}

}
