import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

import { AuthService } from './auth/auth.service';
import { AuthTokenPayload } from './auth/auth-token-payload';

export class MenuItem {
    icon?: string;
    label: string;
    route?: string;
    onlyForRoles?: string[];
}

@Injectable( {
    providedIn: 'root'
} )
export abstract class MenuService {

    private menuItems = [
        { icon: 'people', label: 'Usuaris', route: '/usuaris', onlyForRoles: ['ADMIN'] },
        { icon: 'domain', label: 'Companyies', route: '/companyies', onlyForRoles: ['ADMIN'] },
        { icon: 'business_center', label: 'Empreses', route: '/empreses', onlyForRoles: ['ADMIN'] },
        { icon: 'people_alt', label: 'Operaris', route: '/operaris', onlyForRoles: ['ADMIN', 'MARCA'] },
        { icon: 'timer', label: 'Marcatges', route: '/marcatges', onlyForRoles: ['ADMIN', 'MARCA'] }
    ];
    private allowedMenuItems = [];
    private allowedMenuItemsChangeSubject = new Subject<MenuItem[]>();

    public getAllowedMenuItems() {
        return this.allowedMenuItems;
    }

    public getAllowedMenuItemsChangeSubject(): Subject<MenuItem[]> {
        return this.allowedMenuItemsChangeSubject;
    }

    private refreshAllowedMenuItems( tokenPayload?: AuthTokenPayload ) {
        let roles = [];
        if ( tokenPayload && tokenPayload.rol ) {
            roles = tokenPayload.rol;
        }
        this.allowedMenuItems.splice( 0, this.allowedMenuItems.length );
        this.menuItems.forEach( menuItem => {
            if ( menuItem.onlyForRoles ) {
                let allowed = menuItem.onlyForRoles.some( menuItemRole => {
                    return roles.includes( menuItemRole );
                } );
                if ( allowed ) {
                    this.allowedMenuItems.push( menuItem );
                }
            } else {
                this.allowedMenuItems.push( menuItem );
            }
        } );
        this.allowedMenuItemsChangeSubject.next( this.allowedMenuItems );
    }

    constructor(
        private authService: AuthService ) {
        this.refreshAllowedMenuItems( authService.getAuthTokenPayload() );
        // Manten actualitzada la llista dels items de menu permesos
        authService.getAuthTokenChangeEvent().subscribe(( tokenPayload: AuthTokenPayload ) => {
            this.refreshAllowedMenuItems( tokenPayload );
        } );
    }

}