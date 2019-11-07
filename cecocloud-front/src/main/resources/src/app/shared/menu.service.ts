import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { BngAuthService, BngAuthTokenPayload } from 'base-angular';
import { HttpClient, HttpParams } from '@angular/common/http';

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
			{ icon: 'person_pin', label: 'Rols', labelKey: 'app.menu.rols', route: '/rols'},
			{ icon: 'domain', label: 'Companyies', labelKey: 'app.menu.companyies', route: '/companyies' },
        	{ icon: 'business_center', label: 'Empreses', labelKey: 'app.menu.empreses', route: '/empreses' }
		]
	}

	private adminCompanyiaMenu: AppMenu = {
		icon: 'build',
		label: 'Gestionar companyia',
		labelKey: 'app.menu.admin',
		menuItems: [
			{ icon: 'domain', label: 'Companyia', labelKey: 'app.menu.companyia', route: '/companyies/{resourceId}' },
			{ icon: 'home_work', label: "Grup d'empreses", labelKey: 'app.menu.grup.empreses', route: '/{resourceId}/identificadors' },
        	{ icon: 'business_center', label: 'Empreses', labelKey: 'app.menu.empreses', route: '/empreses' },
			{ icon: 'person_outline', label: 'Usuaris', labelKey: 'app.menu.usuaris', route: '/usuaris' },
			{ icon: 'person_pin', label: 'Perfils', labelKey: 'app.menu.perfils', route: '/perfils' },
        	{ icon: 'people', label: 'Rols', labelKey: 'app.menu.rols', route: '/rols' }
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

    private refreshMenuCompanyia( tokenPayload?: BngAuthTokenPayload ) {
        let usuariCodi;
        let companyiaId;
        let empresaId;
debugger;
         if ( tokenPayload && tokenPayload.sub ) {
             usuariCodi = tokenPayload.sub;
         }
         if ( tokenPayload && tokenPayload.session ) {
             companyiaId = tokenPayload.session['companyia'];
             empresaId = tokenPayload.session['empresa'];
         }

         if (usuariCodi) {
             let rsqlquery = "usuari.id==" + usuariCodi;
             let params = new HttpParams()
                 .set('query', rsqlquery)
                 .set('sort', "companyia.nom,desc");
             this.http.get('api/companyies', {params: params}).subscribe(
                 (response) => {
					console.log("Companyies: ", response);
				}
             );
         } else {

         }

    }

    constructor(
        authService: BngAuthService,
        private http: HttpClient,
		private moduleService: ModuleService ) {
			debugger;
			this.refreshMenuCompanyia( authService.getAuthTokenPayload() );
        //this.refreshAllowedMenuItems( authService.getAuthTokenPayload() );
        // Manten actualitzada la llista de empreses i companyies
//        authService.getAuthTokenChangeEvent().subscribe(( tokenPayload: BngAuthTokenPayload ) => {
//			debugger;
//            this.refreshMenuCompanyia( tokenPayload );
//        } );
    }

}
