import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BngAuthService, BngMenuService, BngModuleService, BngMenu, BngAppModule } from 'base-angular';

import { IdentificadorsService } from '../pages/identificadors/identificadors.service';
import { UsuariIdentificadorEmpresaService } from './selector-identificador-empresa/usuari-identificador-empresa.service';

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
		}, {
			icon: 'group_work',
			label: 'Agrupacions',
			labelKey: 'app.menu.agrupacions',
			resource: 'recurs',
			route: '/agrupacions'
		}, {
			icon: 'vpn_key',
			label: 'API keys',
			labelKey: 'app.menu.apikeys',
			resource: 'apikey',
			route: '/apikeys'
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

	public setCurrentRouteActiveMenu() {
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
			this.menuService.setActiveMenu(this.adminMenu);
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
			this.menuService.setActiveMenu(this.adminIdentificadorMenu);
		} else {
			this.findAndSetActiveMenuFromRouterUrl(this.moduleService.getAllowedModuleItems());
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

	private registerGlobalMenus() {
		this.menuService.registerGlobal('admin', this.adminMenu);
		this.menuService.registerGlobal('admin-idf', this.adminIdentificadorMenu);
	}

	private findAndSetActiveMenuFromRouterUrl(allowedModules: BngAppModule[]) {
		let routerUrl = this.router.url.substring(1);
		let moduleCode: string = (routerUrl.indexOf("/") != -1) ? routerUrl.substring(0, routerUrl.indexOf("/")) : routerUrl;
		let menu: BngMenu = this.getModuleMenu(moduleCode);
		const allowedModulesCodes = allowedModules.map(modul => modul.code);
		if (allowedModulesCodes.includes(moduleCode)) {
			this.usuariIdentificadorEmpresaService.getAllowedFuncionalitats(moduleCode).subscribe((funcionalitats: string[]) => {
				let filteredMenu = this.filterMenuFuncionalitatsPermeses(menu, funcionalitats);
				this.menuService.setActiveMenu(filteredMenu);
			});
		}
	}

	private filterMenuFuncionalitatsPermeses(menu: BngMenu, funcionalitats: string[]): BngMenu {
		let menuFiltrat: BngMenu;
		if (menu.items && menu.items.length) {
			let childMenuFiltrat: BngMenu[] = [];
			for (let item of menu.items) {
				let subMenu = this.filterMenuFuncionalitatsPermeses(item, funcionalitats);
				if (subMenu != null) {
					childMenuFiltrat.push(subMenu);
				}
			}
			if (childMenuFiltrat != null && childMenuFiltrat.length > 0) {
				menuFiltrat = menu;
				menuFiltrat.items = childMenuFiltrat;
			}
		} else {
			if (menu.resource != null && funcionalitats.includes(menu.resource)) {
				menuFiltrat = menu;
			}
		}
		return menuFiltrat;
	}

	constructor(
		private router: Router,
		private authService: BngAuthService,
		private menuService: BngMenuService,
		private moduleService: BngModuleService,
		private identificadorsService: IdentificadorsService,
		private usuariIdentificadorEmpresaService: UsuariIdentificadorEmpresaService) {
		this.registerGlobalMenus();
	}

}
