import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
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
    private static readonly EXPIRATION_OFFSET = 10000;

    authTokenChangeEvent: Subject<AuthTokenPayload> = new Subject<AuthTokenPayload>();

    public authenticate( user: string, pass: string ): Observable<any> {
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

    /*public isAuthenticated(): Observable<boolean> {
        return new Observable(( observer ) => {
            let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
            if ( authResponse ) {
                let validationSession: AuthValidationSession = this.getValidationFromSessionStorage();
                if ( validationSession ) {
                    // Validacio en sessio disponible
                    observer.next( true );
                    observer.complete();
                } else {
                    // Això vol dir que la cache de validació ha expirat o be que
                    // s'està fent una nova petició des d'una pipella diferent o des
                    // d'una nova instància del navegador.
                    // En aquest cas s'ha de validar el token i s'ha de refrescar si
                    // no és vàlid o si està proxim a expirar.
                    let checkUrl = 'api/auth/check/' + authResponse.token;
                    this.http.get( checkUrl ).subscribe(( validated: boolean ) => {
                        let faltaPocPerExpirar = false;
                        if ( validated ) {
                            let tokenPayload = this.tokenToObject( authResponse );
                            faltaPocPerExpirar = Date.now() > tokenPayload.exp * 1000 - AuthService.EXPIRATION_OFFSET;
                        }
                        if ( !validated || faltaPocPerExpirar ) {
                            const params = new HttpParams().set( 'token', authResponse.token );
                            const headers = new HttpHeaders().set( 'Content-Type', 'application/x-www-form-urlencoded' );
                            this.http.post( 'api/auth/refresh', params, { headers: headers } ).subscribe(( response: AuthResponse ) => {
                                this.saveAuthResponseToLocalStorage( response );
                                this.propagateAuthResponseToSessionStorage( response );
                                this.authTokenChangeEvent.next( this.getAuthTokenPayload() );
                                // Token refrescat correctament
                                observer.next( true );
                                observer.complete();
                            }, error => {
                                // Token refrescat amb error
                                this.removeAuthResponseFromLocalStorage();
                                observer.next( false );
                                observer.complete();
                            } );
                        } else {
                            // Token validat i encara falta per expirar
                            observer.next( true );
                            observer.complete();
                        }
                    } );
                }
            } else {
                // Token no disponible
                observer.next( false );
                observer.complete();
            }
        } );
    }*/

    public refreshToken(): Observable<string> {
        return new Observable(( observer ) => {
            let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
            if ( authResponse ) {
                const params = new HttpParams().set( 'token', authResponse.token );
                const headers = new HttpHeaders().set( 'Content-Type', 'application/x-www-form-urlencoded' );
                this.http.post( 'api/auth/refresh', params, { headers: headers } ).subscribe(( response: AuthResponse ) => {
                    this.saveAuthResponseToLocalStorage( response );
                    this.authTokenChangeEvent.next( this.getAuthTokenPayload() );
                    // Token refrescat correctament
                    observer.next( response.token );
                    observer.complete();
                }, ( error: HttpErrorResponse ) => {
                    // Token refrescat amb error
                    this.logout();
                    throw error;
                } );
            } else {
                // No hi ha token per a refrescar
                observer.next();
                observer.complete();
            }
        } );
    }

    public getAuthToken(): string {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if ( authResponse ) {
            return authResponse.token;
        }
    }

    public getAuthTokenPayload(): AuthTokenPayload {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if ( authResponse ) {
            return this.tokenToObject( authResponse );
        }
    }

    public logout() {
        this.removeAuthResponseFromLocalStorage();
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
            let authResponse: AuthResponse = <AuthResponse>JSON.parse( storageContent );
            let tokenPayload = this.tokenToObject( authResponse );
            let isExpired = Date.now() > tokenPayload.exp * 1000;
            if ( !isExpired ) {
                return authResponse;
            } else {
                this.removeAuthResponseFromLocalStorage();
            }
        }
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
        private http: HttpClient ) {
        // Metode periodic per revisar autenticació
        /*const authTimer = timer(
            AuthService.TIME_FIRST_TIMER_CALL, // Temps d'espera fins a la primera cridada (ms)
            AuthService.TIME_BETWEEN_TIMER_CALLS ); // Interval entre cridades (ms)
        const authTimerSubscribe = authTimer.subscribe( numCalls => {
            this.validateAndRefresh();
        } );*/
    }

}
