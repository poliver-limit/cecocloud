import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { Router } from '@angular/router';

import { AuthResponse } from './auth-response';
import { AuthValidationSession } from './auth-validation-session';
import { AuthTokenPayload } from './auth-token-payload';

@Injectable( {
    providedIn: 'root',
} )
export class AuthService {

    private static readonly LOCAL_STORAGE_AUTH_KEY = 'authResponse';

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

    public checkAutenticationWithTokenRefresh( throwError: boolean ): Observable<boolean> {
        return new Observable(( observer ) => {
            let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
            if ( authResponse && !this.isTokenExpired( authResponse.token ) ) {
                observer.next( true );
                observer.complete();
            } else if ( authResponse ) {
                console.info( 'Refrescant token expirat', authResponse.token );
                const headers = new HttpHeaders().set( 'Content-Type', 'application/json' );
                this.http.post( 'api/auth/refresh', { tokena: authResponse.token }, { headers: headers } ).subscribe(( response: AuthResponse ) => {
                    console.info( 'Token refrescat amb èxit', response.token );
                    this.saveAuthResponseToLocalStorage( response );
                    this.authTokenChangeEvent.next( this.getAuthTokenPayload() );
                    // Token refrescat correctament
                    observer.next( true );
                    observer.complete();
                }, ( error: HttpErrorResponse ) => {
                    console.info( 'Error al refrescar el token', error );
                    // Token refrescat amb error
                    this.logout();
                    observer.next( false );
                    observer.complete();
                } );
            } else {
                this.logout();
                observer.next( false );
                observer.complete();
            }
        } );
    }

    public getAuthToken(): string {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if ( authResponse && !this.isTokenExpired( authResponse.token ) ) {
            return authResponse.token;
        }
    }

    public getAuthTokenPayload(): AuthTokenPayload {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if ( authResponse ) {
            return this.tokenToObject( authResponse.token );
        }
    }

    public logout() {
        this.removeAuthResponseFromLocalStorage();
        this.router.navigate( ['/login'] );
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
        return undefined;
    }

    private isTokenExpired( token: string ): boolean {
        let tokenPayload = this.tokenToObject( token );
        return Date.now() > tokenPayload.exp * 1000;
    }

    private tokenToObject( token: string ): any {
        let base64Url = token.split( '.' )[1];
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
    }

}
