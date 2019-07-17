import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { MaterialModule } from './shared/material.module';
import { AuthGuard } from './shared/auth/auth-guard';
import { AuthService } from './shared/auth/auth.service';
import { JwtInterceptor } from './shared/auth/jwt.interceptor';
import { DefaultErrorHandler } from './shared/default-error-handler';
import { DefaultErrorDialog } from './shared/default-error-handler';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routing';

@NgModule( {
    imports: [
        BrowserModule,
        ReactiveFormsModule,
        HttpClientModule,
        MaterialModule,
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
        AuthGuard,
        AuthService
    ],
    bootstrap: [
        AppComponent
    ]
} )
export class AppModule { }
