import { NgModule, ErrorHandler, LOCALE_ID } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { AngularHalModule } from 'angular4-hal';
import { BngRestapiConfigService, BngAuthGuard, BngAuthService, BngJwtInterceptor, BngErrorModule, BngErrorHandler } from '@programari-limit/bang';

import { MaterialModule } from './shared/material.module';
import { LocaleService } from './shared/locale.service';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';

export function createTranslateLoader(http: HttpClient) {
	return new TranslateHttpLoader(http, './assets/i18n/', '.json');
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
				useFactory: (createTranslateLoader),
				deps: [HttpClient]
			}
		}),
		AngularHalModule.forRoot(),
		BngErrorModule,
		AppRoutingModule
	],
	declarations: [
		AppComponent
	],
	providers: [
		{ provide: HTTP_INTERCEPTORS, useClass: BngJwtInterceptor, multi: true },
		{ provide: ErrorHandler, useClass: BngErrorHandler },
		{ provide: 'ExternalConfigurationService', useClass: BngRestapiConfigService },
		{ provide: LOCALE_ID, useFactory: () => LocaleService.getCurrentLocale() },
		BngRestapiConfigService,
		BngAuthGuard,
		//RestapiFormExitGuard,
		BngAuthService
	],
	bootstrap: [
		AppComponent
	]
})
export class AppModule { }
