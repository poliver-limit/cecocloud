import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

import { AuthService } from './auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

    intercept( request: HttpRequest<any>, next: HttpHandler ): Observable<HttpEvent<any>> {
        return next.handle( this.requestWithAuthToken( request ) ).pipe(
            map(( event: HttpEvent<any> ) => {
                return event;
            }, catchError(( error: HttpErrorResponse ) => {
                if ( error.status == 401 ) {
                    this.authService.refreshToken().subscribe(( newToken: string ) => {
                        return next.handle( this.requestWithAuthToken( request ) );
                    }, ( error: HttpErrorResponse ) => {
                        this.router.navigate( ['login'] );
                    } );
                } else {
                    return throwError( error );
                }
            } ) )
        );
    }

    private requestWithAuthToken( request: HttpRequest<any> ): HttpRequest<any> {
        let authToken = this.authService.getAuthToken();
        if ( authToken ) {
            return request.clone( {
                setHeaders: {
                    Authorization: 'Bearer ' + authToken
                }
            } );
        } else {
            return request;
        }
    }

    constructor(
        private authService: AuthService,
        private router: Router ) { }

}