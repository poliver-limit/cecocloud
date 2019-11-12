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

	public getCurrentRouteMenu(companyiesService: CompanyiesService): AppMenu {
		let found: boolean = false;
		this.adminMenu.menuItems.forEach((menuItem: AppMenuItem) => {
			if (menuItem.route && this.router.url.startsWith(menuItem.route)) {
				found = true;
			}
		});
		if (found) {
			return this.adminMenu;
		} else {
			found = false;
			this.adminCompanyiaMenu.menuItems.forEach((menuItem: AppMenuItem) => {
				if (menuItem.route && this.router.url.startsWith(menuItem.route)) {
					found = true;
				}
			});
		}
		if (found) {
			let session: any = this.authService.getSession();
			if (session) {
				companyiesService.whenReady().subscribe(() => {
					companyiesService.get(session.companyia).subscribe((resposta: any) => {
						this.adminCompanyiaMenu.label = resposta.nom;
					});
				});
			}
			return this.adminCompanyiaMenu;
		} else {
			let routerUrl = this.router.url.substring(1);
			let modul = routerUrl.substring(0, routerUrl.indexOf("/"))
			return this.getModuleMenu(modul);
		}
	}

	constructor(
		private router: Router,
		private authService: BngAuthService,
		private moduleService: BngModuleService) {
	}

}
