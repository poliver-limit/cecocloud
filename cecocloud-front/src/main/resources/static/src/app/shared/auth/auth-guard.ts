import { Injectable } from '@angular/core';
import {
    CanActivate,
    Router,
    ActivatedRouteSnapshot,
    RouterStateSnapshot
} from '@angular/router';

import { AuthService } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

    canActivate( route: ActivatedRouteSnapshot, state: RouterStateSnapshot ) {
        if ( this.authService.isAuthenticated() ) {
            return true;
        } else {
            this.router.navigate( ['/login'] );
            return false;
        }
    }

    constructor( private authService: AuthService, private router: Router ) { }

}
