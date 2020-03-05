import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BngAuthService, BngMenuService, BngModuleService, BngMenu, BngAppModule } from 'base-angular';

import { IdentificadorsService } from '../pages/identificadors/identificadors.service';

@Injectable({
	providedIn: 'root'
})
export class AppService {

	adminMenu: BngMenu = {
		icon: 'build',
		label: 'Administració',
		labelKey: 'app.menu.admin',
		items: [{
			icon: 'people',
			label: 'Usuaris',
			labelKey: 'app.menu.usuaris',
			resource: 'usuari',
			route: '/usuaris'
		}, {
			icon: 'domain',
			label: 'Grups d\'empreses',
			labelKey: 'app.menu.identificadors',
			resource: 'identificador',
			route: '/identificadors'
		}, {
			icon: 'format_list_bulleted',
			label: 'Funcionalitats',
			labelKey: 'app.menu.funcionalitats',
			resource: 'funcionalitat',
			route: '/funcionalitats'
		}, {
			icon: 'widgets',
			label: 'Recursos',
			labelKey: 'app.menu.recursos',
			resource: 'recurs',
			route: '/recursos'
		}]
	}

	adminIdentificadorMenu: BngMenu = {
		icon: 'build',
		label: '...',
		items: [{
			icon: 'domain',
			label: 'Grups d\'empreses',
			labelKey: 'app.menu.identificador',
			route: '/identificador'
		}, {
			icon: 'apartment',
			label: 'Empreses',
			labelKey: 'app.menu.empreses',
			resource: 'empresa',
			route: '/empreses'
		}, {
			icon: 'people',
			label: 'Usuaris',
			labelKey: 'app.menu.usuaris',
			route: '/usuari-identificadors'
		}, {
			icon: 'perm_contact_calendar',
			label: 'Operaris',
			labelKey: 'app.menu.operaris',
			route: '/operaris'
		}, {
			icon: 'portrait',
			label: 'Perfils',
			labelKey: 'app.menu.perfils',
			route: '/perfils'
		}]
	}

	public getAdminMenu(): BngMenu {
		return this.adminMenu;
	}

	public getAdminIdentificadorMenu(): BngMenu {
		return this.adminIdentificadorMenu;
	}

	public getCurrentRouteMenu(): BngMenu {
		let found: boolean = false;
		if (this.router.url.startsWith('/admin-app')) {
			found = true;
		} else {
			this.adminMenu.items.forEach((menuItem: BngMenu) => {
				if (menuItem.route && this.router.url.startsWith(menuItem.route)) {
					found = true;
				}
			});
		}
		if (found) {
			return this.adminMenu;
		} else {
			found = false;
			if (this.router.url.startsWith('/admin-identificador')) {
				found = true;
			} else {
				this.adminIdentificadorMenu.items.forEach((menuItem: BngMenu) => {
					if (menuItem.route && this.router.url.startsWith(menuItem.route)) {
						found = true;
					}
				});
			}
		}
		if (found) {
			let session: any = this.authService.getSession();
			if (session) {
				this.identificadorsService.whenReady().subscribe(() => {
					this.identificadorsService.get(session.i).subscribe((resposta: any) => {
						this.adminIdentificadorMenu.label = resposta.descripcio;
					});
				});
			}
			return this.adminIdentificadorMenu;
		} else {
			let routerUrl = this.router.url.substring(1);
			let modul = (routerUrl.indexOf("/") != -1) ? routerUrl.substring(0, routerUrl.indexOf("/")) : routerUrl;
			return this.getModuleMenu(modul);
		}
	}

	public getModuleMenu(module: string): BngMenu {
		let moduleItem: BngAppModule = this.moduleService.getModuleItem(module);
		if (moduleItem) {
			return <BngMenu>{
				icon: moduleItem.icon,
				label: moduleItem.label,
				labelKey: 'app.module.' + module,
				items: moduleItem.menuItems
			};
		}
	}

	// public isCurrentRooteAdmin(): boolean {
	// 	let adminRoute = false

	// 	const routerUrl = this.router.url.substring(1);
	// 	const seccio = (routerUrl.indexOf("/") != -1) ? routerUrl.substring(0, routerUrl.indexOf("/")) : routerUrl;
	// 	// Menu admin
	// 	for (let item of this.adminMenu.items) {
	// 		if (item.route === ("/" + seccio))
	// 			return true;
	// 	}
	// 	// Menu admin-identificador
	// 	for (let item of this.adminIdentificadorMenu.items) {
	// 		if (item.route === ("/" + seccio))
	// 			return true;
	// 	}
	// 	return false;
	// }

	private registerGlobalMenus() {
		this.menuService.registerGlobal('admin', this.adminMenu);
		this.menuService.registerGlobal('admin-idf', this.adminIdentificadorMenu);
	}

	/*private registerAvailableModules() {
		this.moduleService.register({
			code: 'comp',
			icon: 'assessment',
			label: 'Comptabilitat'
		});
		this.moduleService.register({
			code: 'rrmm',
			icon: 'commute',
			label: 'Recursos de maquinària'
		});
		this.moduleService.register({
			code: 'banc',
			icon: 'account_balance',
			label: 'Gestió bancària'
		});
		this.moduleService.register({
			code: 'lici',
			icon: 'work',
			label: 'Licitacions'
		});
		this.moduleService.register({
			code: 'comd',
			icon: 'touch_app',
			label: 'Comandes'
		});
		this.moduleService.refreshAllowedModuleItems();
	}*/

	constructor(
		private router: Router,
		private authService: BngAuthService,
		private menuService: BngMenuService,
		private moduleService: BngModuleService,
		private identificadorsService: IdentificadorsService) {
		this.registerGlobalMenus();
		//this.registerAvailableModules();
		//this.menuService.setActiveGlobalMenu('admin');
	}

}
