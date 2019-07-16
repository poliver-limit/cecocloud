import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

import { AuthService } from './auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

    intercept( request: HttpRequest<any>, next: HttpHandler ): Observable<HttpEvent<any>> {
        if ( this.authService.isAuthenticated() ) {
            let authToken = this.authService.getAuthToken();
            if ( authToken ) {
                request = request.clone( {
                    setHeaders: {
                        Authorization: 'Bearer ' + authToken
                    }
                } );
            }
        }
        return next.handle( request );
    }

    constructor( private authService: AuthService ) { }

}