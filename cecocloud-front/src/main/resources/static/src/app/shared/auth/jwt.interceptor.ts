import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpUserEvent, HttpSentEvent, HttpHeaderResponse, HttpProgressEvent, HttpInterceptor, HttpErrorResponse } from '@angular/common/http';
import { Observable, BehaviorSubject, throwError } from 'rxjs';
import { switchMap, catchError, finalize, filter, take} from 'rxjs/operators';

import { AuthService } from './auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

	isRefreshingToken: boolean = false;
	tokenSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(null);

	intercept( request: HttpRequest<any>, next: HttpHandler ): Observable<HttpSentEvent | HttpHeaderResponse | HttpProgressEvent | HttpResponse<any> | HttpUserEvent<any> | any> {
        return next.handle(this.addAuthorizationHeader(request)).pipe(
			catchError((error: Error) => {
				if (error instanceof HttpErrorResponse) {
					switch ((<HttpErrorResponse>error).status) {
					case 401:
					case 403:
						return this.tryToRefreshToken(request, next);
					default:
						return throwError(error);
					}
				} else {
					return throwError(error);
				}
            })
		);
	}

	private addAuthorizationHeader(request: HttpRequest<any>): HttpRequest<any> {
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

	private tryToRefreshToken(request: HttpRequest<any>, next: HttpHandler) {
		if (!this.isRefreshingToken) {
			this.isRefreshingToken = true;
			this.tokenSubject.next(null);
			return this.authService.checkAutenticationWithTokenRefresh().pipe(
				switchMap((authenticated: boolean) => {
					if (authenticated) {
						this.tokenSubject.next(authenticated);
						return next.handle(this.addAuthorizationHeader(request));
					}
					return <any>this.authService.logout();
				}),
				catchError(() => {
					return <any>this.authService.logout();
				}),
				finalize(() => {
					this.isRefreshingToken = false;
				})
			);
		} else {
			this.isRefreshingToken = false;
			return this.tokenSubject.pipe(
				filter((authenticated: boolean) => authenticated),
				take(1),
				switchMap(() => {
					return next.handle(this.addAuthorizationHeader(request));
				})
			);
		}
	}

	constructor(
		private authService: AuthService ) {}

}