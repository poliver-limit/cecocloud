import { Injectable } from '@angular/core';

import { BngMenuService, BngMenu } from 'base-angular';

@Injectable({
	providedIn: 'root'
})
export class AppService {

	private mainMenu: BngMenu = {
		items: []
	};

	private configureMainMenu() {
		this.menuService.setActiveMenu(this.mainMenu);
	}

	constructor(
		private menuService: BngMenuService) {
		this.configureMainMenu();
	}

}
