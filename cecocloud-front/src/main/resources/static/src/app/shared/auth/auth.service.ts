import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { finalize } from 'rxjs/operators';

import { AuthResponse } from './auth-response';
import { AuthTokenPayload } from './auth-token-payload';

@Injectable( {
    providedIn: 'root',
} )
export class AuthService {

    private static readonly LOCAL_STORAGE_AUTH_KEY = 'authResponse';

    authTokenChangeEvent: Subject<AuthTokenPayload> = new Subject<AuthTokenPayload>();

    authenticate( user: string, pass: string ): Observable<any> {
        const params = new HttpParams().
            append( 'user', user ).
            append( 'pass', pass );
        return new Observable(( observer ) => {
            this.http.get( 'api/auth', { params: params } ).subscribe(( response: AuthResponse ) => {
                this.saveAuthResponseToLocalStorage(response);
                this.authTokenChangeEvent.next( this.getAuthTokenPayload() );
                observer.next( response );
                observer.complete();
            }, error => {
                observer.next( error );
                observer.complete();
            } );
        } );
    }

    isAuthenticated(): boolean {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        return authResponse !== undefined;
    }

    getAuthToken(): any {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if (authResponse) {
            return authResponse.token;
        }
    }

    getAuthTokenPayload(): any {
        let authResponse: AuthResponse = this.getAuthResponseFromLocalStorage();
        if (authResponse) {
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
    }

    logout() {
        localStorage.removeItem( AuthService.LOCAL_STORAGE_AUTH_KEY );
    }

    private saveAuthResponseToLocalStorage( authResponse: AuthResponse ) {
        localStorage.setItem(
            AuthService.LOCAL_STORAGE_AUTH_KEY,
            JSON.stringify( authResponse ) );
    }

    private getAuthResponseFromLocalStorage(): AuthResponse {
        let storageContent = localStorage.getItem( AuthService.LOCAL_STORAGE_AUTH_KEY );
        if (storageContent) {
            let authResponse: AuthResponse = JSON.parse( storageContent );
            let currentTime = new Date().getTime();
            if ( currentTime < authResponse.expiresIn ) {
                return authResponse;
            } else {
                localStorage.removeItem( AuthService.LOCAL_STORAGE_AUTH_KEY );
            }
        }
    }

    constructor(
        private http: HttpClient,
        private router: Router ) { }

}
