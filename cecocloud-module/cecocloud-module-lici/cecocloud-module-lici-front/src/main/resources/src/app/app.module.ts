import { NgModule, ErrorHandler, LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { registerLocaleData } from '@angular/common';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { MultiTranslateHttpLoader } from 'ngx-translate-multi-http-loader';
import { AngularHalModule } from 'angular4-hal';
import { NgxMaskModule } from 'ngx-mask';
import localeCa from '@angular/common/locales/ca';
import { BngBaseAppModule, BngErrorModule, BngJwtInterceptor, BngErrorHandler, BngRestapiConfigService } from 'base-angular';

import { MaterialModule } from './shared/material.module';
import { LocaleService } from './shared/locale.service';
import { RestapiConfigService } from './shared/restapi-config.service';
import { AppService } from './shared/app.service';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';

registerLocaleData(localeCa);

export function HttpLoaderFactory(http: HttpClient) {
	return new MultiTranslateHttpLoader(
		http, [
			{ prefix: "./assets/i18n/baseapp/", suffix: ".json" },
			{ prefix: "./assets/i18n/", suffix: ".json"}
		]);
}

@NgModule({
	imports: [
		BrowserModule,
		BrowserAnimationsModule,
		HttpClientModule,
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
		MaterialModule,
		AppRoutingModule
	],
	providers: [
		{ provide: HTTP_INTERCEPTORS, useClass: BngJwtInterceptor, multi: true },
		{ provide: ErrorHandler, useClass: BngErrorHandler },
		{ provide: 'ExternalConfigurationService', useClass: RestapiConfigService },
		{ provide: LOCALE_ID, useFactory: () => LocaleService.getCurrentLocale() },
		{ provide: BngRestapiConfigService, useClass: RestapiConfigService }
	],
	declarations: [
		AppComponent
	],
	bootstrap: [AppComponent]
})
export class AppModule {

	constructor(appService: AppService) {}

}
