import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { AngularHalModule } from 'angular4-hal';

import { MaterialModule } from './shared/material.module';
import { AuthGuard } from './shared/auth/auth-guard';
import { AuthService } from './shared/auth/auth.service';
import { JwtInterceptor } from './shared/auth/jwt.interceptor';
import { DefaultErrorHandler } from './shared/default-error-handler';
import { DefaultErrorDialog } from './shared/default-error-handler';
import { RestapiConfigService } from './shared/restapi/restapi-config.service'
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';

export function createTranslateLoader( http: HttpClient ) {
    return new TranslateHttpLoader( http, './assets/i18n/', '.json' );
}

@NgModule( {
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        MaterialModule,
        TranslateModule.forRoot( {
            loader: {
                provide: TranslateLoader,
                useFactory: ( createTranslateLoader ),
                deps: [HttpClient]
            }              
        } ),
        AngularHalModule.forRoot(),
        AppRoutingModule
    ],
    declarations: [
        AppComponent,
        DefaultErrorDialog
    ],
    entryComponents: [
        DefaultErrorDialog],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: ErrorHandler, useClass: DefaultErrorHandler },
        { provide: 'ExternalConfigurationService', useClass: RestapiConfigService },
        RestapiConfigService,
        AuthGuard,
        AuthService
    ],
    bootstrap: [
        AppComponent
    ]
} )
export class AppModule { }
