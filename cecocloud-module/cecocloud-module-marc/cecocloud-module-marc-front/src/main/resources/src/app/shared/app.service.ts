import { Injectable } from '@angular/core';

import { BngMenuService, BngMenu } from 'base-angular';

@Injectable({
	providedIn: 'root'
})
export class AppService {

	private mainMenu: BngMenu = {
		menuItems: [{
			icon: 'people_alt',
			label: 'Operaris',
			labelKey: 'app.menu.operaris',
			resource: 'operari',
			route: '/marc/operaris'
		}, {
			icon: 'timer',
			label: 'Marcatges',
			labelKey: 'app.menu.marcatges',
			resource: 'marcatge',
			route: '/marc/marcatges'
		}]
	};

	private configureMainMenu() {
		this.menuService.setActiveMenu(this.mainMenu);
	}

	constructor(
		private menuService: BngMenuService) {
		this.configureMainMenu();
	}

}
