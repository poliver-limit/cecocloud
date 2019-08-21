import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, Subject, timer } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { Promise } from 'es6-promise';

import { AuthResponse } from './auth-response';
import { AuthValidationSession } from './auth-validation-session';
import { AuthTokenPayload } from './auth-token-payload';

@Injectable( {
    providedIn: 'root',
} )
export class AuthService {

    private static readonly LOCAL_STORAGE_AUTH_KEY = 'authResponse';
    private static readonly SESSION_STORAGE_VALIDATION_KEY = 'authValidation';
    private static readonly TIME_FIRST_TIMER_CALL = 1000;
    private static readonly TIME_BETWEEN_TIMER_CALLS = 10000;

    authTokenChangeEvent: Subject<AuthTokenPayload> = new Subject<AuthTokenPayload>();

    authenticate( user: string, pass: string ): Observable<any> {
        const params = new HttpParams().
            append( 'user', user ).
            append( 'pass', pass );
        return new Observable(( observer ) => {
            this.http.get( 'api/auth', { params: params } ).subscribe(( response: AuthResponse ) => {
                this.saveAuthResponseToLocalStorage( response );
                this.authTokenChangeEvent.next( this.getAuthTokenPayload() );
                observer.next( response );
                observer.complete();
            }, error => {
                observer.next( error );
                observer.complete();
            } );
        } );
    }

    private validateAndRefresh() {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if ( authResponse !== undefined ) {
            let validationSession: AuthValidationSession = this.getValidationFromSessionStorage();
            if ( !validationSession ) {
                //console.info( 'Validació de token no trobada' );
                let checkUrl = 'api/auth/check/' + authResponse.token;
                this.http.get( checkUrl ).subscribe(( validated: boolean ) => {
                    if ( !validated ) {
                        console.info( 'Detectat token d\'autenticació invàlid, refrescant...' );
                        const params = new HttpParams().set( 'token', authResponse.token );
                        const headers = new HttpHeaders().set( 'Content-Type', 'application/x-www-form-urlencoded' );
                        this.http.post( 'api/auth/refresh', params, { headers: headers } ).subscribe(( response: AuthResponse ) => {
                            this.saveAuthResponseToLocalStorage( response );
                            this.authTokenChangeEvent.next( this.getAuthTokenPayload() );
                            console.info( 'Token refrescat correctament' );
                        }, error => {
                            console.info( 'No s\'ha pogut refrescar el token' );
                            //console.debug( 'Error de refresc del token', error );
                            this.removeAuthResponseFromLocalStorage();
                        } );
                    } else {
                        this.propagateAuthResponseToSessionStorage( authResponse );
                        //console.info( 'Validació de token guardada' );
                        //console.debug( 'Token vàlid' );
                    }
                } );
            }
        } else {
            // console.debug( 'Informacio d\'autenticació inexistent' );
        }
    }

    isAuthenticated(): boolean {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        return authResponse !== undefined;
    }

    getAuthToken(): any {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if ( authResponse ) {
            return authResponse.token;
        }
    }

    getAuthTokenPayload(): AuthTokenPayload {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if ( authResponse ) {
            return this.tokenToObject( authResponse );
        }
    }

    logout() {
        this.removeAuthResponseFromLocalStorage();
        this.removeValidationFromSessionStorage();
    }

    private saveAuthResponseToLocalStorage( authResponse: AuthResponse ) {
        localStorage.setItem(
            AuthService.LOCAL_STORAGE_AUTH_KEY,
            JSON.stringify( authResponse ) );
    }
    private removeAuthResponseFromLocalStorage() {
        localStorage.removeItem( AuthService.LOCAL_STORAGE_AUTH_KEY );
    }
    private getAuthResponseFromLocalStorage(): AuthResponse {
        let storageContent = localStorage.getItem( AuthService.LOCAL_STORAGE_AUTH_KEY );
        if ( storageContent ) {
            return <AuthResponse>JSON.parse( storageContent );
        }
    }

    private propagateAuthResponseToSessionStorage( authResponse: AuthResponse ) {
        let tokenPayload = this.tokenToObject( authResponse );
        let validation = {
            token: authResponse.token,
            exp: tokenPayload.exp * 1000 - AuthService.TIME_BETWEEN_TIMER_CALLS
        };
        sessionStorage.setItem(
            AuthService.SESSION_STORAGE_VALIDATION_KEY,
            JSON.stringify( validation ) );
    }
    private removeValidationFromSessionStorage() {
        sessionStorage.removeItem( AuthService.SESSION_STORAGE_VALIDATION_KEY );
    }
    private getValidationFromSessionStorage(): AuthValidationSession {
        let storageContent = sessionStorage.getItem( AuthService.SESSION_STORAGE_VALIDATION_KEY );
        if ( storageContent ) {
            let validation: AuthValidationSession = <AuthValidationSession>JSON.parse( storageContent );
            if ( validation.exp > Date.now() ) {
                return validation;
            } else {
                this.removeValidationFromSessionStorage();
            }
        }
        return undefined;
    }

    private tokenToObject( authResponse: AuthResponse ): any {
        let base64Url = authResponse.token.split( '.' )[1];
        let base64 = base64Url.replace( /-/g, '+' ).replace( /_/g, '/' );
        return JSON.parse( atob( base64 ) );
        /*aud: "secure-app"
        exp: 1563292589
        iss: "secure-api"
        name: "test"
        rol: ["ADMIN"]
        sub: "test"*/
    }

    constructor(
        private http: HttpClient,
        private router: Router ) {
        // Metode periodic per revisar autenticació
        const authTimer = timer(
            AuthService.TIME_FIRST_TIMER_CALL, // Temps d'espera fins a la primera cridada (ms)
            AuthService.TIME_BETWEEN_TIMER_CALLS ); // Interval entre cridades (ms)
        const authTimerSubscribe = authTimer.subscribe( numCalls => {
            this.validateAndRefresh();
        } );
    }

}
