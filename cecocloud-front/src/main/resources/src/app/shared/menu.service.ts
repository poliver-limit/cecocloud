import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { BngAuthService, BngAuthTokenPayload } from 'base-angular';

export class MenuItem {
    icon?: string;
    label: string;
    labelKey: string;
    route?: string;
    onlyForRoles?: string[];
}

@Injectable( {
    providedIn: 'root'
} )
export abstract class MenuService {

    private menuItems = [
        { icon: 'people', label: 'Usuaris', labelKey: 'app.menu.usuaris', route: '/usuaris', onlyForRoles: ['ADMIN'] },
        { icon: 'domain', label: 'Companyies', labelKey: 'app.menu.companyies', route: '/companyies', onlyForRoles: ['ADMIN'] },
        { icon: 'business_center', label: 'Empreses', labelKey: 'app.menu.empreses', route: '/empreses', onlyForRoles: ['ADMIN'] },
        { icon: 'people_alt', label: 'Operaris', labelKey: 'app.menu.operaris', route: '/operaris', onlyForRoles: ['ADMIN'] },
        { icon: 'timer', label: 'Marcatges', labelKey: 'app.menu.marcatges', route: '/marcatges', onlyForRoles: ['ADMIN', 'MARCA'] },
        { icon: 'help', label: 'CPK Test', labelKey: 'app.menu.cpktest', route: '/cpktest', onlyForRoles: ['tiruri'] }
    ];
    private allowedMenuItems = [];
    private allowedMenuItemsChangeSubject = new Subject<MenuItem[]>();

    public getAllowedMenuItems() {
        return this.allowedMenuItems;
    }

    public getAllowedMenuItemsChangeSubject(): Subject<MenuItem[]> {
        return this.allowedMenuItemsChangeSubject;
    }

    private refreshAllowedMenuItems( tokenPayload?: BngAuthTokenPayload ) {
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
        authService: BngAuthService ) {
        this.refreshAllowedMenuItems( authService.getAuthTokenPayload() );
        // Manten actualitzada la llista dels items de menu permesos
        authService.getAuthTokenChangeEvent().subscribe(( tokenPayload: BngAuthTokenPayload ) => {
            this.refreshAllowedMenuItems( tokenPayload );
        } );
    }

}
