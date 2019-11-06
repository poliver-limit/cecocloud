import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { BngAuthService, BngAuthTokenPayload } from 'base-angular';
import { ModuleService, ModuleItem } from './module.service';

export class AppMenu {
	icon?: string;
    label: string;
    labelKey: string;
	menuItems: AppMenuItem[]
}
export class AppMenuItem {
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

	private adminMenu: AppMenu = {
		icon: 'build',
		label: 'Administració',
		labelKey: 'app.menu.admin',
		menuItems: [
			{ icon: 'people', label: 'Usuaris', labelKey: 'app.menu.usuaris', route: '/usuaris' },
			{ icon: 'domain', label: 'Companyies', labelKey: 'app.menu.companyies', route: '/companyies' },
        	{ icon: 'business_center', label: 'Empreses', labelKey: 'app.menu.empreses', route: '/empreses' }
		]
	}

	private adminCompanyiaMenu: AppMenu = {
		icon: 'build',
		label: 'Gestionar companyia',
		labelKey: 'app.menu.admin',
		menuItems: [
			{ icon: 'people', label: 'Usuaris', labelKey: 'app.menu.usuaris', route: '/usuaris' },
			{ icon: 'domain', label: 'Companyies', labelKey: 'app.menu.companyies', route: '/companyies' },
        	{ icon: 'business_center', label: 'Empreses', labelKey: 'app.menu.empreses', route: '/empreses' }
		]
	}

	public getAdminMenu(): AppMenu {
		return this.adminMenu;
	}

	public getAdminCompanyiaMenu(): AppMenu {
		return this.adminCompanyiaMenu;
	}

	public getModuleMenu(module: string): AppMenu {
		let moduleItem: ModuleItem = this.moduleService.getModuleItem(module);
		if (moduleItem) {
			return <AppMenu> {
				icon: moduleItem.icon,
				label: moduleItem.label,
				labelKey: 'app.module' + module,
				menuItems: moduleItem.menuItems
			};
		}
	}

    /*private allowedMenuItems = [];
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
    }*/

    constructor(
        authService: BngAuthService,
		private moduleService: ModuleService ) {
        /*this.refreshAllowedMenuItems( authService.getAuthTokenPayload() );
        // Manten actualitzada la llista dels items de menu permesos
        /*authService.getAuthTokenChangeEvent().subscribe(( tokenPayload: BngAuthTokenPayload ) => {
            this.refreshAllowedMenuItems( tokenPayload );
        } );*/
    }

}
