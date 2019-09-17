import { Injectable, Component } from '@angular/core';
import { Observable } from 'rxjs';
import { CanDeactivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';

@Injectable( {
    providedIn: 'root'
} )
export class RestapiFormExitGuard implements CanDeactivate<Component> {

    private modified: boolean;

    public setModified( modified: boolean ) {
        this.modified = modified;
    }

    canDeactivate( component: Component, route: ActivatedRouteSnapshot, state: RouterStateSnapshot ): Observable<boolean> | boolean {
        if ( this.modified ) {
            return confirm( this.translate.instant( 'component.restapi.form.undo.confirm' ) );
        } else {
            return true;
        }
    }

    constructor(
        private translate: TranslateService ) {
    }

}
