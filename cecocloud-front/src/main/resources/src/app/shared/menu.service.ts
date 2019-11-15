import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

import { BngAuthService, BngModuleService, BngModuleItem, BngModuleMenuItem } from 'base-angular';
import { CompanyiesService } from './companyies.service';

export class AppMenu {
	icon?: string;
	label: string;
	labelKey?: string;
	menuItems: AppMenuItem[]
}
export class AppMenuItem extends BngModuleMenuItem {
	labelKey: string;
};

@Injectable({
	providedIn: 'root'
})
export class MenuService {

	private adminMenu: AppMenu = {
		icon: 'build',
		label: 'Administració',
		labelKey: 'app.menu.admin',
		menuItems: [			
			{ icon: 'people', label: 'Usuaris', labelKey: 'app.menu.usuaris', route: '/usuaris' },
			{ icon: 'domain', label: 'Companyies', labelKey: 'app.menu.companyies', route: '/companyies' }
		]
	}

	private adminCompanyiaMenu: AppMenu = {
		icon: 'build',
		label: '...',
		menuItems: [
			{ icon: 'domain', label: 'Companyia', labelKey: 'app.menu.companyia', route: '/companyia' },
			{ icon: 'people', label: 'Usuaris', labelKey: 'app.menu.usuaris', route: '/companyia-usuaris' },
			{ icon: 'home_work', label: 'Grups d\'empreses', labelKey: 'app.menu.identificadors', route: '/identificadors' },
			{ icon: 'business_center', label: 'Empreses', labelKey: 'app.menu.empreses', route: '/empreses' },
			{ icon: 'portrait', label: 'Perfils', labelKey: 'app.menu.perfils', route: '/perfils' },
			{ icon: 'person_pin', label: 'Rols', labelKey: 'app.menu.rols', route: '/rols' }
		]
	}

	public getAdminMenu(): AppMenu {
		return this.adminMenu;
	}

	public getAdminCompanyiaMenu(companyiaNom: string): AppMenu {
		this.adminCompanyiaMenu.label = companyiaNom;
		return this.adminCompanyiaMenu;
	}

	public getModuleMenu(module: string): AppMenu {
		let moduleItem: BngModuleItem = this.moduleService.getModuleItem(module);
		if (moduleItem) {
			return <AppMenu>{
				icon: moduleItem.icon,
				label: moduleItem.label,
				labelKey: 'app.module.' + module,
				menuItems: moduleItem.menuItems
			};
		}
	}

	public getCurrentRouteMenu(): AppMenu {
		let found: boolean = false;
		if (this.router.url.startsWith('/admin-app')) {
			found = true;
		} else {
			this.adminMenu.menuItems.forEach((menuItem: AppMenuItem) => {
				if (menuItem.route && this.router.url.startsWith(menuItem.route)) {
					found = true;
				}
			});
		}
		if (found) {
			return this.adminMenu;
		} else {
			found = false;
			if (this.router.url.startsWith('/admin-companyia')) {
				found = true;
			} else {
				this.adminCompanyiaMenu.menuItems.forEach((menuItem: AppMenuItem) => {
					if (menuItem.route && this.router.url.startsWith(menuItem.route)) {
						found = true;
					}
				});
			}
		}
		if (found) {
			let session: any = this.authService.getSession();
			if (session) {
				this.companyiesService.whenReady().subscribe(() => {
					this.companyiesService.get(session.companyia).subscribe((resposta: any) => {
						this.adminCompanyiaMenu.label = resposta.nom;
					});
				});
			}
			return this.adminCompanyiaMenu;
		} else {
			let routerUrl = this.router.url.substring(1);
			let modul = (routerUrl.indexOf("/") != -1) ? routerUrl.substring(0, routerUrl.indexOf("/")) : routerUrl;
			return this.getModuleMenu(modul);
		}
	}

	constructor(
		private router: Router,
		private authService: BngAuthService,
		private moduleService: BngModuleService,
		private companyiesService: CompanyiesService) {
	}

}
